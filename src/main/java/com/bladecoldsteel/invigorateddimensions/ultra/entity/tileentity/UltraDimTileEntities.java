package com.bladecoldsteel.invigorateddimensions.ultra.entity.tileentity;

import com.bladecoldsteel.invigorateddimensions.InvigoratedDimensions;
import com.bladecoldsteel.invigorateddimensions.ultra.block.UltraDimBlocks;
import com.bladecoldsteel.invigorateddimensions.ultra.entity.tileentity.custom.BeastlyBoarTuskPortalTileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class UltraDimTileEntities {
    public static DeferredRegister<TileEntityType<?>> TILE_ENTITIES = DeferredRegister.create(ForgeRegistries.TILE_ENTITIES, InvigoratedDimensions.MOD_ID);

    public static RegistryObject<TileEntityType<BeastlyBoarTuskPortalTileEntity>> BEASTLY_BOAR_PORTAL_TILE =
            TILE_ENTITIES.register("beastly_boar_portal_block_tile", () -> TileEntityType.Builder.of(
                    BeastlyBoarTuskPortalTileEntity::new, UltraDimBlocks.BEASTLY_BOAR_PORTAL.get()).build(null));

    public static void register(IEventBus eventBus) {
        TILE_ENTITIES.register(eventBus);
    }
}
