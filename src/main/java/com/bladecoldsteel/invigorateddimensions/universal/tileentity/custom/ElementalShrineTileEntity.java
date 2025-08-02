package com.bladecoldsteel.invigorateddimensions.universal.tileentity.custom;

import com.bladecoldsteel.invigorateddimensions.universal.screens.custom.containers.ElementalShrineContainer;
import com.bladecoldsteel.invigorateddimensions.universal.tileentity.UniversalTileEntities;
import com.bladecoldsteel.invigorateddimensions.util.DimensionInfo;
import com.bladecoldsteel.invigorateddimensions.util.DimensionInfoDataLoader;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.item.Item;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.INBT;
import net.minecraft.nbt.ListNBT;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SUpdateTileEntityPacket;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraftforge.registries.ForgeRegistries;

import javax.annotation.Nullable;
import java.util.HashMap;
import java.util.Map;

public class ElementalShrineTileEntity extends TileEntity implements ITickableTileEntity, INamedContainerProvider {
    private ResourceLocation selectedDimension = null;
    private final Map<Item, Integer> submittedCounts = new HashMap<>();
    private ResourceLocation lockedDimension;

    public ElementalShrineTileEntity(TileEntityType<?> tileEntityType) {
        super(tileEntityType);
    }

    public ElementalShrineTileEntity() {
        this(UniversalTileEntities.ELEMENTAL_SHRINE_TILE.get());
    }

    @Override
    public void tick() {

    }

    @Nullable
    @Override
    public Container createMenu(int windowId, PlayerInventory playerInventory, PlayerEntity playerEntity) {
        return new ElementalShrineContainer(windowId, playerInventory, this.getBlockPos());
    }

    @Override
    public ITextComponent getDisplayName() {
        return new StringTextComponent("Elemental Shrine");
    }

    public void setSelectedDimension(ResourceLocation dimension) {
        if (this.selectedDimension == null) {
            this.selectedDimension = dimension;
        }
    }

    public ResourceLocation getSelectedDimension() {
        return selectedDimension;
    }

    public int getSubmittedCount(Item item) {
        return submittedCounts.getOrDefault(item, 0);
    }

    public void submitItem(Item item, int count) {
        submittedCounts.put(item, getSubmittedCount(item) + count);
        setChanged();
    }

    public boolean hasSubmissionFor(ResourceLocation dimensionId) {
        DimensionInfo info = DimensionInfoDataLoader.INSTANCE.dimensionData.get(dimensionId);
        if (info != null) {
            for (DimensionInfo.TeleportationIngredient ing : info.recipe.getIngredients()) {
                Item item = ForgeRegistries.ITEMS.getValue(ing.item);
                if (getSubmittedCount(item) > 0) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean hasSubmittedAll(DimensionInfo info) {
        for (DimensionInfo.TeleportationIngredient ing : info.recipe.getIngredients()) {
            Item item = ForgeRegistries.ITEMS.getValue(ing.item);
            if (getSubmittedCount(item) < ing.count) {
                return false;
            }
        }
        return true;
    }

    public ResourceLocation getLockedDimension() {
        return lockedDimension;
    }

    public void setLockedDimension(ResourceLocation dimension) {
        this.lockedDimension = dimension;
    }

    @Override
    public CompoundNBT save(CompoundNBT nbt) {
        super.save(nbt);
        if (selectedDimension != null) {
            nbt.putString("SelectedDimension", selectedDimension.toString());
        }
        if (lockedDimension != null) {
            nbt.putString("LockedDimension", lockedDimension.toString());
        }
        ListNBT list = new ListNBT();
        for (Map.Entry<Item, Integer> entry : submittedCounts.entrySet()) {
            CompoundNBT itemNbt = new CompoundNBT();
            itemNbt.putString("Item", entry.getKey().getRegistryName().toString());
            itemNbt.putInt("Count", entry.getValue());
            list.add(itemNbt);
        }
        nbt.put("SubmittedCounts", list);
        return nbt;
    }

    @Override
    public void load(BlockState state, CompoundNBT nbt) {
        super.load(state, nbt);
        if (nbt.contains("SelectedDimension")) {
            this.selectedDimension = new ResourceLocation(nbt.getString("SelectedDimension"));
        }
        if (nbt.contains("LockedDimension")) {
            this.lockedDimension = new ResourceLocation(nbt.getString("LockedDimension"));
        }

        submittedCounts.clear();
        ListNBT list = nbt.getList("SubmittedCounts", 10);
        for (INBT tag : list) {
            CompoundNBT itemNBT = (CompoundNBT) tag;
            Item item = ForgeRegistries.ITEMS.getValue(new ResourceLocation(itemNBT.getString("Item")));
            int count = itemNBT.getInt("Count");
            if (item != null) {
                submittedCounts.put(item, count);
            }
        }
    }

    @Override
    public CompoundNBT getUpdateTag() {
        return this.save(new CompoundNBT());
    }

    @Override
    public void handleUpdateTag(BlockState state, CompoundNBT tag) {
        this.load(state, tag);
    }

    @Nullable
    @Override
    public SUpdateTileEntityPacket getUpdatePacket() {
        CompoundNBT nbtTag = new CompoundNBT();
        this.save(nbtTag);
        return new SUpdateTileEntityPacket(this.getBlockPos(), 1, nbtTag);
    }

    @Override
    public void onDataPacket(NetworkManager net, SUpdateTileEntityPacket pkt) {
        this.load(this.getBlockState(), pkt.getTag());
    }
}
