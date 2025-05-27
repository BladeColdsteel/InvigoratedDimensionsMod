package com.bladecoldsteel.invigorateddimensions.universal.screens.custom.containers;

import com.bladecoldsteel.invigorateddimensions.universal.screens.UniversalContainers;
import com.bladecoldsteel.invigorateddimensions.universal.tileentity.custom.EnergySinkTileEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.Slot;
import net.minecraft.util.math.BlockPos;

public class EnergySinkContainer extends Container {
    private final EnergySinkTileEntity tile;
    private final BlockPos blockPos;
    public EnergySinkContainer(int windowId, PlayerInventory playerInventory, BlockPos pos) {
        super(UniversalContainers.ENERGY_SINK_MENU.get(), windowId);
        this.blockPos = pos;
        this.tile = (EnergySinkTileEntity) playerInventory.player.level.getBlockEntity(pos);
        addPlayerInventory(playerInventory, 8, 84);
        addHotbar(playerInventory, 8, 142);
    }
    
    public EnergySinkTileEntity getTile() {
        return tile;
    }

    public BlockPos getBlockPos() {
        return blockPos;
    }

    @Override
    public boolean stillValid(PlayerEntity playerEntity) {
        return true;
    }

    private void addPlayerInventory(PlayerInventory playerInventory, int x, int y) {
        for (int row = 0; row < 3; ++row) {
            for (int col = 0; col < 9; col++) {
                this.addSlot(new Slot(playerInventory, col + row * 9 + 9, x + col * 18, y + row * 18));
            }
        }
    }

    private void addHotbar(PlayerInventory playerInventory, int x, int y) {
        for (int i = 0; i < 9; i++) {
            this.addSlot(new Slot(playerInventory, i, x + i * 18, y));
        }
    }
}
