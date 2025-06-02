package com.bladecoldsteel.invigorateddimensions.universal.network;

import com.bladecoldsteel.invigorateddimensions.universal.item.UniversalItems;
import com.pixelmonmod.pixelmon.Pixelmon;
import com.pixelmonmod.pixelmon.api.events.battles.BattleEndEvent;
import com.pixelmonmod.pixelmon.api.pokemon.Element;
import com.pixelmonmod.pixelmon.api.pokemon.Pokemon;
import com.pixelmonmod.pixelmon.battles.controller.participants.BattleParticipant;
import com.pixelmonmod.pixelmon.battles.controller.participants.PixelmonWrapper;
import com.pixelmonmod.pixelmon.battles.controller.participants.PlayerParticipant;
import com.pixelmonmod.pixelmon.entities.pixelmon.PixelmonEntity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EssenceDropHandler {
    public EssenceDropHandler() {
        Pixelmon.EVENT_BUS.register(this);
    }

    private static final Map<Element, ItemStack> TYPE_ESSENCE_MAP = new HashMap<>();

    public static void initTypeEssenceMap() {
        TYPE_ESSENCE_MAP.put(Element.NORMAL, new ItemStack(UniversalItems.NORMAL_ESSENCE.get()));
        TYPE_ESSENCE_MAP.put(Element.ELECTRIC, new ItemStack(UniversalItems.ELECTRIC_ESSENCE.get()));
        TYPE_ESSENCE_MAP.put(Element.WATER, new ItemStack(UniversalItems.WATER_ESSENCE.get()));
        TYPE_ESSENCE_MAP.put(Element.FIRE, new ItemStack(UniversalItems.FIRE_ESSENCE.get()));
        TYPE_ESSENCE_MAP.put(Element.GRASS, new ItemStack(UniversalItems.GRASS_ESSENCE.get()));
        TYPE_ESSENCE_MAP.put(Element.STEEL, new ItemStack(UniversalItems.STEEL_ESSENCE.get()));
        TYPE_ESSENCE_MAP.put(Element.FAIRY, new ItemStack(UniversalItems.FAIRY_ESSENCE.get()));
        TYPE_ESSENCE_MAP.put(Element.ROCK, new ItemStack(UniversalItems.ROCK_ESSENCE.get()));
        TYPE_ESSENCE_MAP.put(Element.GROUND, new ItemStack(UniversalItems.GROUND_ESSENCE.get()));
        TYPE_ESSENCE_MAP.put(Element.DARK, new ItemStack(UniversalItems.DARK_ESSENCE.get()));
        TYPE_ESSENCE_MAP.put(Element.FIGHTING, new ItemStack(UniversalItems.FIGHTING_ESSENCE.get()));
        TYPE_ESSENCE_MAP.put(Element.BUG, new ItemStack(UniversalItems.BUG_ESSENCE.get()));
        TYPE_ESSENCE_MAP.put(Element.DRAGON, new ItemStack(UniversalItems.DRAGON_ESSENCE.get()));
        TYPE_ESSENCE_MAP.put(Element.ICE, new ItemStack(UniversalItems.ICE_ESSENCE.get()));
        TYPE_ESSENCE_MAP.put(Element.POISON, new ItemStack(UniversalItems.POISON_ESSENCE.get()));
        TYPE_ESSENCE_MAP.put(Element.GHOST, new ItemStack(UniversalItems.GHOST_ESSENCE.get()));
        TYPE_ESSENCE_MAP.put(Element.PSYCHIC, new ItemStack(UniversalItems.PSYCHIC_ESSENCE.get()));
        TYPE_ESSENCE_MAP.put(Element.FLYING, new ItemStack(UniversalItems.FLYING_ESSENCE.get()));
    }

    @SubscribeEvent
    public static void onBattleEnd(BattleEndEvent event) {
        for (BattleParticipant participant : event.getBattleController().getPlayers()) {
            if (participant instanceof PlayerParticipant) {
                PlayerParticipant playerPart = (PlayerParticipant) participant;
                PlayerEntity player = playerPart.player;
                World world = player.level;

                List<PixelmonWrapper> teamWrapper = playerPart.getTeamPokemon();

                if (teamWrapper.isEmpty() || teamWrapper.get(0) == null) continue;

                Pokemon playerPokemon = teamWrapper.get(0).pokemon;
                int level = playerPokemon.getPokemonLevel();

                for (BattleParticipant opponent : event.getBattleController().getOpponents(playerPart)) {
                    if (opponent.getEntity() instanceof PixelmonEntity) {
                        PixelmonEntity defeated = (PixelmonEntity) opponent.getEntity();
                        BlockPos pos = defeated.blockPosition();

                        int baseRolls = 2 + (level >= 25 ? 2 : 0) + (level >= 50 ? 2 : 0) + (level >= 75 ? 2 : 0) + (level >= 100 ? 2 : 0);
                        for (int i = 0; i < baseRolls; i++) {
                            if (Math.random() < 0.75) {
                                world.addFreshEntity(new ItemEntity(
                                        world,
                                        pos.getX() + 0.5, pos.getY() + 1, pos.getZ() + 0.5,
                                        new ItemStack(UniversalItems.BASE_ESSENCE.get())
                                ));
                            }
                        }

                        for (Element type : defeated.getPokemon().getForm().getTypes()) {
                            ItemStack essence = getTypeEssence(type);
                            if (essence == null) continue;

                            if (Math.random() < 0.99) {
                                world.addFreshEntity(new ItemEntity(world, pos.getX() + 0.5, pos.getY() + 1, pos.getZ() + 0.5, essence.copy()));
                            }
                            if (level >= 25 && Math.random() < 0.20)
                                world.addFreshEntity(new ItemEntity(world, pos.getX() + 0.5, pos.getY() + 1, pos.getZ() + 0.5, essence.copy()));
                            if (level >= 50 && Math.random() < 0.20)
                                world.addFreshEntity(new ItemEntity(world, pos.getX() + 0.5, pos.getY() + 1, pos.getZ() + 0.5, essence.copy()));
                            if (level >= 75 && Math.random() < 0.20)
                                world.addFreshEntity(new ItemEntity(world, pos.getX() + 0.5, pos.getY() + 1, pos.getZ() + 0.5, essence.copy()));
                            if (level >= 100 && Math.random() < 0.20)
                                world.addFreshEntity(new ItemEntity(world, pos.getX() + 0.5, pos.getY() + 1, pos.getZ() + 0.5, essence.copy()));
                        }
                    }
                }
            }
        }
    }

    private static ItemStack getTypeEssence(Element type) {
        return TYPE_ESSENCE_MAP.get(type);
    }
}
