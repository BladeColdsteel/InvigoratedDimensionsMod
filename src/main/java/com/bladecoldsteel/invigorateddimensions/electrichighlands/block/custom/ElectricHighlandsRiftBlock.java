package com.bladecoldsteel.invigorateddimensions.electrichighlands.block.custom;

import com.bladecoldsteel.invigorateddimensions.world.dimension.ElectricHighlandsRiftTeleporter;
import com.bladecoldsteel.invigorateddimensions.world.dimension.ModDimensions;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

public class ElectricHighlandsRiftBlock extends Block {

    public ElectricHighlandsRiftBlock() {
        super(Properties.of(Material.STONE)
                .strength(-1f)
                .lightLevel((state) -> 15)
                .noDrops());
    }

    @Override
    public void stepOn(World worldIn, BlockPos pos, Entity entity) {
        if (entity.getVehicle() != null || entity.isVehicle()) return;

        if (worldIn instanceof ServerWorld && worldIn.getServer() != null) {
            ServerWorld world2 = worldIn.getServer().getLevel(ModDimensions.ELECTRIC_HIGHLANDS);
            if (world2 == null) return;

            BlockPos targetPos = new BlockPos(entity.position().x * 5, entity.position().y, entity.position().z * 5);

            entity.changeDimension(world2, new ElectricHighlandsRiftTeleporter(targetPos));
        }

    }
}
