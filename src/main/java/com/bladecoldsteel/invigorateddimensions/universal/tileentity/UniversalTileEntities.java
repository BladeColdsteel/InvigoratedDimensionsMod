package com.bladecoldsteel.invigorateddimensions.universal.tileentity;

import com.bladecoldsteel.invigorateddimensions.InvigoratedDimensions;
import com.bladecoldsteel.invigorateddimensions.universal.block.UniversalBlocks;
import com.bladecoldsteel.invigorateddimensions.universal.tileentity.custom.EnergySinkTileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class UniversalTileEntities {
    public static DeferredRegister<TileEntityType<?>> TILE_ENTITIES = DeferredRegister.create(ForgeRegistries.TILE_ENTITIES, InvigoratedDimensions.MOD_ID);

    public static RegistryObject<TileEntityType<EnergySinkTileEntity>> ENERGY_SINK_TILE =
            TILE_ENTITIES.register("energy_sink_tile", () -> TileEntityType.Builder.of(
                    EnergySinkTileEntity::new, UniversalBlocks.ENERGY_SINK.get()).build(null));

    public static void register(IEventBus eventBus) {
        TILE_ENTITIES.register(eventBus);
    }
}
