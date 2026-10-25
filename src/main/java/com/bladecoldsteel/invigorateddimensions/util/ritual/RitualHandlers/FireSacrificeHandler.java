package com.bladecoldsteel.invigorateddimensions.util.ritual.RitualHandlers;

import com.bladecoldsteel.invigorateddimensions.InvigoratedDimensions;
import com.bladecoldsteel.invigorateddimensions.util.ritual.RitualData;
import com.bladecoldsteel.invigorateddimensions.util.ritual.RitualDefinition;
import com.bladecoldsteel.invigorateddimensions.util.ritual.RitualType;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Set;
import java.util.WeakHashMap;

@Mod.EventBusSubscriber(modid = InvigoratedDimensions.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class FireSacrificeHandler {
    @SubscribeEvent
    public static void onWorldTick(TickEvent.WorldTickEvent event) {
        if (event.phase == TickEvent.Phase.END) {
            if (!event.world.isClientSide) {
                if (event.world.getGameTime() % 5 != 0) {
                    return;
                }
                for (ItemEntity item : new ArrayList<>(TRACKED_ITEMS)) {
                    if (!item.isAlive()) {
                        TRACKED_ITEMS.remove(item);
                        continue;
                    }

                    if (item.level == event.world) {
                        checkRitual(item);
                    }
                }
            }
        }
    }

    @SubscribeEvent
    public static void onEntityJoinWorld(EntityJoinWorldEvent event) {
        if (!event.getWorld().isClientSide) {
            Entity entity = event.getEntity();
            if (entity instanceof ItemEntity) {
                ItemEntity item = (ItemEntity) entity;
                ResourceLocation itemId = item.getItem().getItem().getRegistryName();
                if (itemId == null) {
                    return;
                }
                for (RitualDefinition rituals : RitualData.getRitualsCollection()) {
                    if (rituals.getType() == RitualType.FIRE_SACRIFICE && itemId.equals(rituals.getInput()) && item.level.dimension().location().equals(rituals.getDimension())) {
                        TRACKED_ITEMS.add(item);
                        break;
                    }
                }
            }
        }
    }

    private static final Set<ItemEntity> TRACKED_ITEMS = Collections.newSetFromMap(new WeakHashMap<>());

    private static void checkRitual(ItemEntity item) {
        ItemStack stack = item.getItem();
        if (!stack.isEmpty()) {
            ResourceLocation itemId = stack.getItem().getRegistryName();
            if (itemId != null) {
                BlockPos pos = item.blockPosition();
                for (RitualDefinition ritual : RitualData.getRitualsCollection()) {
                    if (ritual.getType() == RitualType.FIRE_SACRIFICE) {
                        if (item.level.dimension().location().equals(ritual.getDimension())) {
                            if (itemId.equals(ritual.getInput())) {
                                if ((ritual.getRitualSpecifics() instanceof RitualDefinition.FireType)) {
                                    RitualDefinition.FireType fireSpecifics = (RitualDefinition.FireType) ritual.getRitualSpecifics();
                                    Block requiredFire = fireSpecifics.toBlock();
                                    if (requiredFire != null) {
                                        Block actualBlock = item.level.getBlockState(pos).getBlock();
                                        if (actualBlock == requiredFire) {
                                            executeRitual(item, ritual);
                                            item.level.setBlock(pos, Blocks.AIR.defaultBlockState(), 3);
                                            break;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    private static void executeRitual(ItemEntity item, RitualDefinition ritual) {
        Item outputItem = ForgeRegistries.ITEMS.getValue(ritual.getOutput());
        if (outputItem == null) {
            System.out.println("[Fire Sacrifice] Unknown object: " + ritual.getOutput());
            return;
        }

        ItemStack inputStack = item.getItem();
        inputStack.shrink(1);

        if (inputStack.isEmpty()) {
            item.remove();
        } else {
            item.setItem(inputStack);
        }

        ItemEntity result = new ItemEntity(item.level, item.getX(), item.getY(), item.getZ(), new ItemStack(outputItem));
        item.level.addFreshEntity(result);
        System.out.println("[Fire Sacrifice] Completed Ritual: " + ritual.getOutput());
    }
}
