package com.bladecoldsteel.invigorateddimensions.electrichighlands.item.custom;

import com.bladecoldsteel.invigorateddimensions.electrichighlands.block.ElectricHighlandsBlocks;
import com.bladecoldsteel.invigorateddimensions.electrichighlands.block.custom.ElectricHighlandsPortalBlock;
import com.bladecoldsteel.invigorateddimensions.electrichighlands.item.ElectricHighlandsItemGroup;
import com.bladecoldsteel.invigorateddimensions.world.dimension.ModDimensions;
import net.minecraft.item.Item;
import net.minecraft.item.ItemUseContext;
import net.minecraft.item.Rarity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ElectricHighlandsActivatorItem extends Item {

    public ElectricHighlandsActivatorItem() {
        super(new Properties()
                .tab(ElectricHighlandsItemGroup.INVIGORATED_DIMENSIONS_GROUP)
                .stacksTo(1)
                .rarity(Rarity.RARE));
    }

    @Override
    public ActionResultType useOn(ItemUseContext context) {
        if (context.getPlayer() != null) {
            if (context.getPlayer().level.dimension() == ModDimensions.ELECTRIC_HIGHLANDS || context.getPlayer().level.dimension() == World.OVERWORLD) {
                for (Direction direction : Direction.Plane.VERTICAL) {
                    BlockPos framePos = context.getClickedPos().relative(direction);
                    if (((ElectricHighlandsPortalBlock) ElectricHighlandsBlocks.ELECTRIC_HIGHLANDS_PORTAL.get()).trySpawnPortal(context.getLevel(), framePos)) {
                        context.getLevel().playSound(context.getPlayer(), framePos, SoundEvents.LIGHTNING_BOLT_THUNDER, SoundCategory.BLOCKS, 1.0F, 1.0F);
                        return ActionResultType.CONSUME;
                    }
                    else return ActionResultType.FAIL;
                }
            }
        }
        return ActionResultType.FAIL;
    }
}
