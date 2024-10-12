package com.bladecoldsteel.invigorateddimensions.block.custom;

import com.bladecoldsteel.invigorateddimensions.InvigoratedDimensions;
import com.bladecoldsteel.invigorateddimensions.world.dimension.ModDimensions;
import com.bladecoldsteel.invigorateddimensions.world.dimension.SimpleTeleporter;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

public class AltarBlock extends Block {
    public AltarBlock(Properties properties) {
        super(properties);
    }

    @Override
    public ActionResultType use(BlockState state, World world, BlockPos pos,
                                PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
        // Log player and world interaction
        System.out.println("AltarBlock used at position: " + pos);
        System.out.println("World: " + world.dimension().location());
        System.out.println("Player: " + player.getName().getString());

        if (!world.isClientSide()) {
            if (!player.isCrouching()) {
                MinecraftServer server = world.getServer();

                if (server != null) {
                    System.out.println("Server is available.");

                    // Check which dimension the player is currently in
                    if (world.dimension() == ModDimensions.ELECTRIC_HIGHLANDS) {
                        System.out.println("Player is in Electric Highlands.");

                        ServerWorld overWorld = server.getLevel(World.OVERWORLD);
                        if (overWorld != null) {
                            System.out.println("Overworld found, teleporting player to Overworld.");
                            player.changeDimension(overWorld, new SimpleTeleporter(pos, false));
                        } else {
                            System.out.println("Error: Overworld is null.");
                        }
                    } else {
                        System.out.println("Player is not in Electric Highlands. Trying to teleport to Electric Highlands.");

                        ServerWorld electricHighlands = server.getLevel(ModDimensions.ELECTRIC_HIGHLANDS);
                        if (electricHighlands != null) {
                            System.out.println("Electric Highlands found, teleporting player to Electric Dimension.");
                            player.changeDimension(electricHighlands, new SimpleTeleporter(pos, true));
                        } else {
                            System.out.println("Error: Electric Highlands is null.");
                        }
                    }
                    return ActionResultType.SUCCESS;
                } else {
                    System.out.println("Error: Server is null.");
                }
            } else {
                System.out.println("Player is crouching, no teleportation.");
            }
        } else {
            System.out.println("This code is running on the client side, no teleportation.");
        }

        return super.use(state, world, pos, player, handIn, hit);
    }
}

