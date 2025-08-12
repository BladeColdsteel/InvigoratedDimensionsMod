package com.bladecoldsteel.invigorateddimensions.universal.item.custom;

import com.bladecoldsteel.invigorateddimensions.universal.block.custom.GeneralizedPortalBlock;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemUseContext;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.function.Supplier;

public class UniversalActivatorItem extends Item {
    private final Supplier<? extends Block> portalBlock;
    private final RegistryKey<World> destinationDimension;

    public UniversalActivatorItem(Properties properties, RegistryKey<World> destinationDimension, Supplier<? extends Block> portalBlock) {
        super(properties);
        this.destinationDimension = destinationDimension;
        this.portalBlock = portalBlock;
    }

    @Override
    public ActionResultType useOn(ItemUseContext context) {
        if (context.getPlayer() == null) {
            System.out.println("[Activator Debug] Player is null, aborting.");
            return ActionResultType.FAIL;
        }
        if (!(context.getPlayer().level.dimension() == destinationDimension || context.getPlayer().level.dimension() == World.OVERWORLD)) {
            System.out.println("[Activator Debug] Player is not in allowed dimension.");
            return ActionResultType.FAIL;
        }
        if (portalBlock == null) {
            System.out.println("[Activator Debug] portalBlock supplier is NULL!");
            return ActionResultType.FAIL;
        }
        Block portal = portalBlock.get();
        if (portal == null) {
            System.out.println("[Activator Debug] portalBlock.get() returned NULL! Probably not registered yet.");
            return ActionResultType.FAIL;
        }
        if (!(portal instanceof GeneralizedPortalBlock)) {
            System.out.println("[Activator Debug] portalBlock is NOT a GeneralizedPortalBlock! It is: " + portal.getClass().getName());
            return ActionResultType.FAIL;
        }
        for (Direction direction : Direction.Plane.VERTICAL) {
            BlockPos framePos = context.getClickedPos().relative(direction);

            if (((GeneralizedPortalBlock) portal).trySpawnPortal(context.getLevel(), framePos)) {
                context.getLevel().playSound(context.getPlayer(), framePos, SoundEvents.LIGHTNING_BOLT_IMPACT, SoundCategory.BLOCKS, 1.0F, 1.0F);
                context.getItemInHand().shrink(1);
                return ActionResultType.CONSUME;
            } else {
                System.out.println("[Activator Debug] Failed to spawn portal at: " + framePos);
                return ActionResultType.FAIL;
            }
        }

        return ActionResultType.FAIL;
    }
}
