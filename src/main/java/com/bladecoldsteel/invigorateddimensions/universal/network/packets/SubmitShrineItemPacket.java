package com.bladecoldsteel.invigorateddimensions.universal.network.packets;

import com.bladecoldsteel.invigorateddimensions.universal.block.UniversalBlocks;
import com.bladecoldsteel.invigorateddimensions.universal.block.custom.RiftChargingBlock;
import com.bladecoldsteel.invigorateddimensions.universal.entity.tileentity.custom.ElementalShrineTileEntity;
import com.bladecoldsteel.invigorateddimensions.universal.entity.tileentity.custom.RiftBlockTileEntity;
import com.bladecoldsteel.invigorateddimensions.util.DimensionInfo;
import com.bladecoldsteel.invigorateddimensions.util.DimensionInfoDataLoader;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.RedstoneLampBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketBuffer;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.concurrent.TickDelayedTask;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.fml.network.NetworkEvent;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Supplier;

public class SubmitShrineItemPacket {
    private final ResourceLocation dimensionId;
    private final BlockPos pos;

    public SubmitShrineItemPacket(ResourceLocation dimensionId, BlockPos pos) {
        this.dimensionId = dimensionId;
        this.pos = pos;
    }

    public static void encode(SubmitShrineItemPacket msg, PacketBuffer buf) {
        buf.writeResourceLocation(msg.dimensionId);
        buf.writeBlockPos(msg.pos);
    }

    public static SubmitShrineItemPacket decode(PacketBuffer buf) {
        return new SubmitShrineItemPacket(buf.readResourceLocation(), buf.readBlockPos());
    }

    public static void handle(SubmitShrineItemPacket msg, Supplier<NetworkEvent.Context> ctx) {
        ctx.get().enqueueWork(() -> {
            ServerPlayerEntity player = ctx.get().getSender();
            if (player == null) return;

            TileEntity tile = player.level.getBlockEntity(msg.pos);
            if (!(tile instanceof ElementalShrineTileEntity)) return;

            ElementalShrineTileEntity shrine = (ElementalShrineTileEntity) tile;
            DimensionInfo data = DimensionInfoDataLoader.INSTANCE.dimensionData.get(msg.dimensionId);

            if (data == null) return;

            if (shrine.isDimensionUnlocked(data.dimension)) {
                player.displayClientMessage(new StringTextComponent("This dimension is already unlocked at this Shrine."), false);
                return;
            }

            if (shrine.getLockedDimension() != null && !shrine.getLockedDimension().equals(msg.dimensionId)) {
                return;
            }

            if (shrine.getLockedDimension() == null) {
                shrine.setLockedDimension(msg.dimensionId);
            }

            boolean anySubmitted = false;

            for (DimensionInfo.TeleportationIngredient ingredient : data.recipe.getIngredients()) {
                Item item = ForgeRegistries.ITEMS.getValue(ingredient.item);
                int submitted = shrine.getSubmittedCount(item);
                int needed = ingredient.count - submitted;
                if (needed > 0) {
                    int removed = removeItemsFromPlayer(player, item, needed);
                    shrine.submitItem(item, removed);
                    if (removed > 0) {
                        anySubmitted = true;
                    }
                }
            }
            if (anySubmitted && shrine.hasSubmittedAll(data)) {
                player.displayClientMessage(new StringTextComponent("Rift opened to " + data.name), true);

                int delayedTick = 40;
                BlockPos shrinePos = shrine.getBlockPos();
                World world = player.level;
                ServerWorld serverWorld = (ServerWorld) shrine.getLevel();

                BlockPos riftPos = shrine.getRandomAvailableRiftPos();
                if (riftPos == null) {
                    player.displayClientMessage(new StringTextComponent("No available rift positions remain."), false);
                    return;
                }

                player.closeContainer();
                if (serverWorld != null) {
                    int now = serverWorld.getServer().getTickCount();

                    serverWorld.getServer().tell(new TickDelayedTask(now + delayedTick * 2, () -> {
                        activateChargingBlock(world, riftPos.north());
                        world.playSound(null, shrinePos, SoundEvents.LEVER_CLICK, SoundCategory.BLOCKS, 0.5F, 0.5F);
                        ((ServerWorld) world).sendParticles(ParticleTypes.CRIT,
                                riftPos.getX() + 0.5, riftPos.getY() + 1, riftPos.getZ() + 0.5,
                                50, 0.5, 1, 0.5, 0.05);
                    }));
                    serverWorld.getServer().tell(new TickDelayedTask(now + delayedTick * 3, () -> {
                        activateChargingBlock(world, riftPos.south());
                        world.playSound(null, shrinePos, SoundEvents.LEVER_CLICK, SoundCategory.BLOCKS, 0.5F, 0.5F);
                        ((ServerWorld) world).sendParticles(ParticleTypes.CRIT,
                                riftPos.getX() + 0.5, riftPos.getY() + 1, riftPos.getZ() + 0.5,
                                50, 0.5, 1, 0.5, 0.05);
                    }));
                    serverWorld.getServer().tell(new TickDelayedTask(now + delayedTick * 4, () -> {
                        activateChargingBlock(world, riftPos.east());
                        world.playSound(null, shrinePos, SoundEvents.LEVER_CLICK, SoundCategory.BLOCKS, 0.5F, 0.5F);
                        ((ServerWorld) world).sendParticles(ParticleTypes.CRIT,
                                riftPos.getX() + 0.5, riftPos.getY() + 1, riftPos.getZ() + 0.5,
                                50, 0.5, 1, 0.5, 0.05);
                    }));
                    serverWorld.getServer().tell(new TickDelayedTask(now + delayedTick * 5, () -> {
                        activateChargingBlock(world, riftPos.west());
                        world.playSound(null, shrinePos, SoundEvents.LEVER_CLICK, SoundCategory.BLOCKS, 0.5F, 0.5F);
                        ((ServerWorld) world).sendParticles(ParticleTypes.CRIT,
                                riftPos.getX() + 0.5, riftPos.getY() + 1, riftPos.getZ() + 0.5,
                                50, 0.5, 1, 0.5, 0.05);
                    }));
                    serverWorld.getServer().tell(new TickDelayedTask(now + delayedTick * 8, () -> {
                        world.setBlockAndUpdate(riftPos, UniversalBlocks.RIFT_BLOCK.get().defaultBlockState());


                        TileEntity riftTile = world.getBlockEntity(riftPos);
                        if (riftTile instanceof RiftBlockTileEntity) {
                            ((RiftBlockTileEntity) riftTile).setTargetDimension(data.dimension);
                            shrine.markDimensionUnlocked(data.dimension);
                            shrine.clearSubmission();
                        }

                        world.playSound(null, shrinePos, SoundEvents.LIGHTNING_BOLT_IMPACT, SoundCategory.BLOCKS, 0.5F, 0.5F);
                        ((ServerWorld) world).sendParticles(ParticleTypes.CRIT,
                                shrinePos.getX() - 0.5, shrinePos.getY(), shrinePos.getZ() - 0.5,
                                50, 0.5, 1, 0.5, 0.05);


                    }));
                    world.playSound(null, shrinePos, SoundEvents.BEACON_ACTIVATE, SoundCategory.BLOCKS, 2.0F, 2.0F);

                    float riftsActivated = (float) shrine.getActivatedRifts() / 16;

                    BlockPos lamp1 = shrinePos.offset(-7, 2, -7);
                    BlockPos lamp2 = shrinePos.offset(-7, 2, 7);
                    BlockPos lamp3 = shrinePos.offset(7, 2, -7);
                    BlockPos lamp4 = shrinePos.offset(7, 2, 7);

                    if (riftsActivated == 1.0F) {
                        world.setBlock(lamp1, world.getBlockState(lamp1).setValue(RedstoneLampBlock.LIT, true), 2);
                        world.setBlock(lamp2, world.getBlockState(lamp2).setValue(RedstoneLampBlock.LIT, true), 2);
                        world.setBlock(lamp3, world.getBlockState(lamp3).setValue(RedstoneLampBlock.LIT, true), 2);
                        world.setBlock(lamp4, world.getBlockState(lamp4).setValue(RedstoneLampBlock.LIT, true), 2);
                    } else if (riftsActivated >= 0.75F) {
                        world.setBlock(lamp1, world.getBlockState(lamp1).setValue(RedstoneLampBlock.LIT, true), 2);
                        world.setBlock(lamp2, world.getBlockState(lamp2).setValue(RedstoneLampBlock.LIT, true), 2);
                        world.setBlock(lamp3, world.getBlockState(lamp3).setValue(RedstoneLampBlock.LIT, true), 2);
                    } else if (riftsActivated >= 0.5F) {
                        world.setBlock(lamp1, world.getBlockState(lamp1).setValue(RedstoneLampBlock.LIT, true), 2);
                        world.setBlock(lamp2, world.getBlockState(lamp2).setValue(RedstoneLampBlock.LIT, true), 2);
                    } else if (riftsActivated >= 0.25F){
                        world.setBlock(lamp1, world.getBlockState(lamp1).setValue(RedstoneLampBlock.LIT, true), 2);
                    }
                }
            }

            BlockState state = shrine.getLevel().getBlockState(msg.pos);
            shrine.setChanged();
            shrine.getLevel().sendBlockUpdated(msg.pos, state, state, 3);
        });
        ctx.get().setPacketHandled(true);
    }

    private static int removeItemsFromPlayer(PlayerEntity player, Item item, int maxToRemove) {
        int removed = 0;
        for (int i = 0; i < player.inventory.getContainerSize(); i++) {
            ItemStack stack = player.inventory.getItem(i);
            if (stack.getItem() == item && !stack.isEmpty()) {
                int toTake = Math.min(stack.getCount(), maxToRemove - removed);
                stack.shrink(toTake);
                removed += toTake;
                if (stack.getCount() <= 0) {
                    player.inventory.setItem(i, ItemStack.EMPTY);
                }

                if (removed >= maxToRemove) break;
            }
        }
        player.inventory.setChanged();

        return removed;
    }

    private static void activateChargingBlock(World world, BlockPos pos) {
        BlockState state = world.getBlockState(pos);
        if (state.getBlock() instanceof RiftChargingBlock && state.hasProperty(RiftChargingBlock.ACTIVE)) {
            world.setBlockAndUpdate(pos, state.setValue(RiftChargingBlock.ACTIVE, true));
        }
    }
}
