package com.bladecoldsteel.invigorateddimensions.universal.entity.tileentity.custom;

import com.bladecoldsteel.invigorateddimensions.electrichighlands.effects.ElectricHighlandsEffects;
import com.bladecoldsteel.invigorateddimensions.universal.block.custom.EnergySinkBlock;
import com.bladecoldsteel.invigorateddimensions.universal.screens.custom.containers.EnergySinkContainer;
import com.bladecoldsteel.invigorateddimensions.universal.entity.tileentity.UniversalTileEntities;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.Direction;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.energy.CapabilityEnergy;
import net.minecraftforge.energy.IEnergyStorage;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class EnergySinkTileEntity extends TileEntity implements ITickableTileEntity, INamedContainerProvider {

    private final LazyOptional<IEnergyStorage> energyCapability = LazyOptional.of(this::createEnergyHandler);
    private IEnergyStorage createEnergyHandler() {
        return new DirectionalOutputEnergyStorage();
    }

    public EnergySinkTileEntity(TileEntityType<?> tileEntityType) {
        super(tileEntityType);
    }

    public EnergySinkTileEntity() {
        this(UniversalTileEntities.ENERGY_SINK_TILE.get());
    }

    @Override
    public ITextComponent getDisplayName() {
        return new StringTextComponent("Energy Sink");
    }

    @Nullable
    @Override
    public Container createMenu(int windowId, PlayerInventory playerInventory, PlayerEntity playerEntity) {
        return new EnergySinkContainer(windowId, playerInventory, this.getBlockPos());
    }

    @Override
    public void tick() {
        if (level == null || level.isClientSide) return;

        BlockPos above = worldPosition.above();

        level.getEntitiesOfClass(PlayerEntity.class, new AxisAlignedBB(above)).forEach(player -> {
            if (player.hasEffect(ElectricHighlandsEffects.CHARGED.get())) {
                int amp = player.getEffect(ElectricHighlandsEffects.CHARGED.get()).getAmplifier();
                int energy = getEnergyForAmplifier(amp);
                outputEnergyToTarget(getFacing(), energy);
            }
        });
    }

    public ItemStack getTargetBlockItem() {
        if (level == null) return ItemStack.EMPTY;

        Direction visualFacing = getFacing() == Direction.DOWN ? Direction.DOWN : getFacing().getOpposite();
        BlockPos targetPos = worldPosition.relative(visualFacing);
        BlockState targetState = level.getBlockState(targetPos);

        return targetState.getBlock().asItem().getDefaultInstance();
    }

    public String getFacingInfo() {
        if (level == null) return "Unknown";

        Direction visualFacing = getFacing() == Direction.DOWN ? Direction.DOWN : getFacing().getOpposite();
        String directionName = visualFacing.getName().toUpperCase();

        return "Facing: " + directionName;
    }

    public int getCurrentOutput() {
        if (level == null) return 0;
        BlockPos above = worldPosition.above();

        for (PlayerEntity player : level.getEntitiesOfClass(PlayerEntity.class, new AxisAlignedBB(above))) {
            if (player.hasEffect(ElectricHighlandsEffects.CHARGED.get())) {
                int amp = player.getEffect(ElectricHighlandsEffects.CHARGED.get()).getAmplifier();
                return getEnergyForAmplifier(amp);
            }
        }

        return 0;
    }

    private int getEnergyForAmplifier(int amplifier) {
        return 10 * (amplifier + 1);
    }

    private void outputEnergyToTarget(Direction out, int amount) {
        BlockPos targetPos = worldPosition.relative(out);
        TileEntity targetTile = level.getBlockEntity(targetPos);

        if (targetTile != null) {
            targetTile.getCapability(CapabilityEnergy.ENERGY, out.getOpposite()).ifPresent(receiver -> {
                receiver.receiveEnergy(amount, false);
            });
        }
    }

    private Direction getFacing(){
        BlockState state = this.getBlockState();
        return state.hasProperty(EnergySinkBlock.FACING) ? state.getValue(EnergySinkBlock.FACING) : Direction.DOWN;
    }

    @Nonnull
    @Override
    public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, Direction side) {
        if (cap == CapabilityEnergy.ENERGY && side == getFacing()) {
            return energyCapability.cast();
        }
        return super.getCapability(cap, side);
    }

    private boolean isOutputSide(Direction side) {
        return side == Direction.DOWN;
    }

    private static class DirectionalOutputEnergyStorage implements IEnergyStorage {

        @Override
        public int receiveEnergy(int maxReceive, boolean simulate) {
            return 0;
        }

        @Override
        public int extractEnergy(int maxExtract, boolean simulate) {
            return 30;
        }

        @Override
        public int getEnergyStored() {
            return 0;
        }

        @Override
        public int getMaxEnergyStored() {
            return 0;
        }

        @Override
        public boolean canExtract() {
            return false;
        }

        @Override
        public boolean canReceive() {
            return false;
        }
    }
}
