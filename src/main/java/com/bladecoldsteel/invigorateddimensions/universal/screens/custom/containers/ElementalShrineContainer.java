package com.bladecoldsteel.invigorateddimensions.universal.screens.custom.containers;

import com.bladecoldsteel.invigorateddimensions.universal.screens.UniversalContainers;
import com.bladecoldsteel.invigorateddimensions.universal.entity.tileentity.custom.ElementalShrineTileEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.Slot;
import net.minecraft.util.math.BlockPos;

public class ElementalShrineContainer extends Container {
    private final ElementalShrineTileEntity tile;
    private final BlockPos blockPos;
    public ElementalShrineContainer(int windowId, PlayerInventory playerInventory, BlockPos pos) {
        super(UniversalContainers.ELEMENTAL_SHRINE_MENU.get(), windowId);
        this.blockPos = pos;
        this.tile = (ElementalShrineTileEntity) playerInventory.player.level.getBlockEntity(pos);
        addPlayerInventory(playerInventory, 108, 84);
        addHotbar(playerInventory, 108, 142);
    }
    
    public ElementalShrineTileEntity getTile() {
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
