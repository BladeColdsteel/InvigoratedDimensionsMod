package com.bladecoldsteel.invigorateddimensions.universal.block.custom;

import com.bladecoldsteel.invigorateddimensions.universal.block.UniversalBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.RotatedPillarBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemStack;
import net.minecraft.loot.LootContext;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.StateContainer;
import net.minecraftforge.common.ToolType;

import java.util.ArrayList;
import java.util.List;

public class RiftChargingBlock extends RotatedPillarBlock {
    public static final BooleanProperty ACTIVE = BooleanProperty.create("active");

    public RiftChargingBlock() {
        super(Properties.of(Material.STONE)
                .strength(10.0F)
                .sound(SoundType.METAL)
                .harvestTool(ToolType.PICKAXE)
                .harvestLevel(3)
                .requiresCorrectToolForDrops());
        BlockState defaultBoolean = this.stateDefinition.any().setValue(ACTIVE, false);
        this.registerDefaultState(defaultBoolean);
    }

    @Override
    public List<ItemStack> getDrops(BlockState state, LootContext.Builder loot) {
        List<ItemStack> drops = new ArrayList<>();
        drops.add(new ItemStack(UniversalBlocks.PORTAL_CHARGING_BLOCK_REDSTONE.get()));
        return drops;
    }

    @Override
    protected void createBlockStateDefinition(StateContainer.Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder);
        builder.add(ACTIVE);
    }
}
