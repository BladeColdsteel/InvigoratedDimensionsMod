package com.bladecoldsteel.invigorateddimensions.universal.network.packets;

import com.bladecoldsteel.invigorateddimensions.electrichighlands.block.ElectricHighlandsBlocks;
import com.bladecoldsteel.invigorateddimensions.universal.block.UniversalBlocks;
import com.bladecoldsteel.invigorateddimensions.universal.tileentity.custom.ElementalShrineTileEntity;
import com.bladecoldsteel.invigorateddimensions.universal.tileentity.custom.RiftBlockTileEntity;
import com.bladecoldsteel.invigorateddimensions.util.DimensionInfo;
import com.bladecoldsteel.invigorateddimensions.util.DimensionInfoDataLoader;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
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
                player.displayClientMessage(new StringTextComponent("All items submitted for teleportation!"), false);

                int delayedTick = 40;
                BlockPos shrinePos = shrine.getBlockPos();
                BlockPos riftPos = shrinePos.below();
                World world = player.level;
                ServerWorld serverWorld = (ServerWorld) shrine.getLevel();

                world.setBlockAndUpdate(shrinePos, Blocks.AIR.defaultBlockState());
                player.closeContainer();
                serverWorld.getServer().tell(new TickDelayedTask(delayedTick, () -> {
                    world.setBlockAndUpdate(shrinePos.below(), UniversalBlocks.RIFT_BLOCK.get().defaultBlockState());


                    TileEntity riftTile = world.getBlockEntity(riftPos);
                    if (riftTile instanceof RiftBlockTileEntity) {
                        ((RiftBlockTileEntity) riftTile).setTargetDimension(data.dimension);
                    }

                    world.playSound(null, shrinePos, SoundEvents.LIGHTNING_BOLT_IMPACT, SoundCategory.BLOCKS, 0.5F, 0.5F);
                    ((ServerWorld) world).sendParticles(ParticleTypes.CRIT,
                            shrinePos.getX() - 0.5, shrinePos.getY(), shrinePos.getZ() - 0.5,
                            50, 0.5, 1, 0.5, 0.05);
                }));

                serverWorld.getServer().tell(new TickDelayedTask(delayedTick * 2, () -> {
                    world.setBlockAndUpdate(riftPos.north(), Blocks.STONE_BRICKS.defaultBlockState());
                    world.playSound(null, shrinePos, SoundEvents.LIGHTNING_BOLT_IMPACT, SoundCategory.BLOCKS, 0.5F, 0.5F);
                    ((ServerWorld) world).sendParticles(ParticleTypes.CRIT,
                            riftPos.getX() + 0.5, riftPos.getY() + 1, riftPos.getZ() + 0.5,
                            50, 0.5, 1, 0.5, 0.05);
                }));
                serverWorld.getServer().tell(new TickDelayedTask(delayedTick * 3, () -> {
                    world.setBlockAndUpdate(riftPos.south(), Blocks.STONE_BRICKS.defaultBlockState());
                    world.playSound(null, shrinePos, SoundEvents.LIGHTNING_BOLT_IMPACT, SoundCategory.BLOCKS, 0.5F, 0.5F);
                    ((ServerWorld) world).sendParticles(ParticleTypes.CRIT,
                            riftPos.getX() + 0.5, riftPos.getY() + 1, riftPos.getZ() + 0.5,
                            50, 0.5, 1, 0.5, 0.05);
                }));
                serverWorld.getServer().tell(new TickDelayedTask(delayedTick * 4, () -> {
                    world.setBlockAndUpdate(riftPos.east(), Blocks.STONE_BRICKS.defaultBlockState());
                    world.playSound(null, shrinePos, SoundEvents.LIGHTNING_BOLT_IMPACT, SoundCategory.BLOCKS, 0.5F, 0.5F);
                    ((ServerWorld) world).sendParticles(ParticleTypes.CRIT,
                            riftPos.getX() + 0.5, riftPos.getY() + 1, riftPos.getZ() + 0.5,
                            50, 0.5, 1, 0.5, 0.05);
                }));
                serverWorld.getServer().tell(new TickDelayedTask(delayedTick * 5, () -> {
                    world.setBlockAndUpdate(riftPos.west(), Blocks.STONE_BRICKS.defaultBlockState());
                    world.playSound(null, shrinePos, SoundEvents.LIGHTNING_BOLT_IMPACT, SoundCategory.BLOCKS, 0.5F, 0.5F);
                    ((ServerWorld) world).sendParticles(ParticleTypes.CRIT,
                            riftPos.getX() + 0.5, riftPos.getY() + 1, riftPos.getZ() + 0.5,
                            50, 0.5, 1, 0.5, 0.05);
                }));
                world.playSound(null, shrinePos, SoundEvents.BEACON_ACTIVATE, SoundCategory.BLOCKS, 2.0F, 2.0F);
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
}
