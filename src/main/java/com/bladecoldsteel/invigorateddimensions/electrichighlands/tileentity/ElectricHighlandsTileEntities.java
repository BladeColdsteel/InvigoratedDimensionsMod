package com.bladecoldsteel.invigorateddimensions.electrichighlands.tileentity;

import com.bladecoldsteel.invigorateddimensions.InvigoratedDimensions;
import com.bladecoldsteel.invigorateddimensions.electrichighlands.block.ElectricHighlandsBlocks;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ElectricHighlandsTileEntities {

    public static DeferredRegister<TileEntityType<?>> TILE_ENTITIES =
            DeferredRegister.create(ForgeRegistries.TILE_ENTITIES, InvigoratedDimensions.MOD_ID);

    public static RegistryObject<TileEntityType<ElectricHighlandsSignTileEntity>> SIGN_TILE_ENTITIES =
            TILE_ENTITIES.register("sign", () -> TileEntityType.Builder.of(ElectricHighlandsSignTileEntity::new,
                    ElectricHighlandsBlocks.ELECTRICALLY_CHARGED_SIGN.get(),
                    ElectricHighlandsBlocks.ELECTRICALLY_CHARGED_WALL_SIGN.get()
            ).build(null));

    public static void register(IEventBus eventBus) {
        TILE_ENTITIES.register(eventBus);
    }
}
