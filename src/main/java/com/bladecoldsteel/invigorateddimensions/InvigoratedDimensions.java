package com.bladecoldsteel.invigorateddimensions;

import com.bladecoldsteel.invigorateddimensions.electrichighlands.block.ElectricHighlandsBlocks;
import com.bladecoldsteel.invigorateddimensions.electrichighlands.block.ElectricHighlandsWoodTypes;
import com.bladecoldsteel.invigorateddimensions.electrichighlands.item.ElectricHighlandsItems;
import com.bladecoldsteel.invigorateddimensions.electrichighlands.tileentity.ElectricHighlandsTileEntities;
import com.bladecoldsteel.invigorateddimensions.electrichighlands.util.ElectricHighlandsSoundEvents;
import com.bladecoldsteel.invigorateddimensions.universal.block.UniversalBlocks;
import com.bladecoldsteel.invigorateddimensions.universal.item.UniversalItems;
import com.bladecoldsteel.invigorateddimensions.waterydepths.block.WateryDepthsBlocks;
import com.bladecoldsteel.invigorateddimensions.waterydepths.block.WateryDepthsWoodTypes;
import com.bladecoldsteel.invigorateddimensions.waterydepths.item.WateryDepthsItems;
import com.bladecoldsteel.invigorateddimensions.world.ElectricHighlandsStructures;
import com.bladecoldsteel.invigorateddimensions.world.ModParticleTypes;
import com.bladecoldsteel.invigorateddimensions.world.ModPointsOfInterest;
import com.bladecoldsteel.invigorateddimensions.world.biome.ModBiomesDatapack;
import com.bladecoldsteel.invigorateddimensions.world.dimension.CustomSurfaceBuilders;
import com.bladecoldsteel.invigorateddimensions.world.dimension.ModDimensions;
import com.bladecoldsteel.invigorateddimensions.world.gen.features.ElectricFeatures;
import com.bladecoldsteel.invigorateddimensions.world.gen.features.WaterFeatures;
import com.google.common.collect.ImmutableMap;
import net.minecraft.block.Block;
import net.minecraft.block.WoodType;
import net.minecraft.client.renderer.Atlases;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.client.renderer.tileentity.SignTileEntityRenderer;
import net.minecraft.item.AxeItem;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ExtensionPoint;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.*;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.network.FMLNetworkConstants;
import net.minecraftforge.registries.DeferredRegister;
import org.apache.commons.lang3.tuple.Pair;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(InvigoratedDimensions.MOD_ID)
public class InvigoratedDimensions
{
    public static final String MOD_ID = "invigorated_dimensions";
    public static final Logger LOGGER = LogManager.getLogger();

    public InvigoratedDimensions() {

        ModLoadingContext.get().registerExtensionPoint(
                ExtensionPoint.DISPLAYTEST,
                () -> Pair.of(() -> FMLNetworkConstants.IGNORESERVERONLY, (remote, isServer) -> true)
        );

        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        IEventBus forgeBus = MinecraftForge.EVENT_BUS;
        forgeBus.addListener(EventPriority.NORMAL, ElectricHighlandsStructures::addDimensionalSpacing);
        //Base
        ModBiomesDatapack.register(eventBus);
        CustomSurfaceBuilders.register(eventBus);
        ModParticleTypes.register(eventBus);
        ModPointsOfInterest.register(eventBus);
        UniversalBlocks.register(eventBus);
        UniversalItems.register(eventBus);
        //Electric
        ElectricHighlandsItems.register(eventBus);
        ElectricHighlandsBlocks.register(eventBus);
        ElectricHighlandsSoundEvents.register(eventBus);
        ElectricHighlandsTileEntities.register(eventBus);
        //Water
        WateryDepthsItems.register(eventBus);
        WateryDepthsBlocks.register(eventBus);

        DeferredRegister<?>[] registers = {
                //Electric
          ElectricFeatures.ELECTRIC_FEATURES,
          ElectricHighlandsStructures.STRUCTURES,
                //Water
          WaterFeatures.WATER_FEATURES
        };

        for (DeferredRegister<?> register : registers) {
            register.register(eventBus);
        }

        // Register the setup method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        // Register the enqueueIMC method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::enqueueIMC);
        // Register the processIMC method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::processIMC);
        // Register the doClientStuff method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event)
    {

        event.enqueueWork(() -> {
            //Base
            ModDimensions.register();
            //Electric
            ElectricFeatures.registerConfiguredFeatures();
            ElectricHighlandsStructures.registerStructures();
            ElectricHighlandsStructures.registerConfiguredStructures();
            //Water
            WaterFeatures.registerConfiguredFeatures();

            //Strippable Wood
            AxeItem.STRIPABLES = new ImmutableMap.Builder<Block, Block>().putAll(AxeItem.STRIPABLES)
                    //Electric
                    .put(ElectricHighlandsBlocks.ELECTRICALLY_CHARGED_LOG.get(), ElectricHighlandsBlocks.STRIPPED_ELECTRICALLY_CHARGED_LOG.get())
                    .put(ElectricHighlandsBlocks.ELECTRICALLY_CHARGED_WOOD.get(), ElectricHighlandsBlocks.STRIPPED_ELECTRICALLY_CHARGED_WOOD.get())
                    //Water
                    .build();

            WoodType.register(ElectricHighlandsWoodTypes.ELECTRICALLY_CHARGED);
            WoodType.register(WateryDepthsWoodTypes.WATERY);

            InvigoratedDimensions.LOGGER.info("Registered Trees: {}", WorldGenRegistries.CONFIGURED_FEATURE.keySet());

            InvigoratedDimensions.LOGGER.info("Registered Feature Key: {}",
                    WorldGenRegistries.CONFIGURED_FEATURE.getKey(ElectricFeatures.ConfiguredFeatures.ELECTRIC_TREE));
            InvigoratedDimensions.LOGGER.info("Registered Feature Key: {}",
                    WorldGenRegistries.CONFIGURED_FEATURE.getKey(WaterFeatures.ConfiguredFeatures.WATERY_TREE));

        });

    }

    private void doClientStuff(final FMLClientSetupEvent event) {

        //Electric
        RenderTypeLookup.setRenderLayer(UniversalBlocks.CRYSTALLIZED_LEAVES.get(), RenderType.cutout());
        RenderTypeLookup.setRenderLayer(ElectricHighlandsBlocks.ELECTRICALLY_CHARGED_SAPLING.get(), RenderType.cutout());

        RenderTypeLookup.setRenderLayer(ElectricHighlandsBlocks.ELECTRICALLY_CHARGED_DOOR.get(), RenderType.cutout());
        RenderTypeLookup.setRenderLayer(ElectricHighlandsBlocks.ELECTRICALLY_CHARGED_WOODEN_TRAPDOOR.get(), RenderType.cutout());

        ClientRegistry.bindTileEntityRenderer(ElectricHighlandsTileEntities.SIGN_TILE_ENTITIES.get(),
                SignTileEntityRenderer::new);

        //Water
        RenderTypeLookup.setRenderLayer(WateryDepthsBlocks.WATERY_SAPLING.get(), RenderType.cutout());

        //Wood Types
        Atlases.addWoodType(ElectricHighlandsWoodTypes.ELECTRICALLY_CHARGED);
        Atlases.addWoodType(WateryDepthsWoodTypes.WATERY);
    }

    public void gatherData(GatherDataEvent event) {

    }

    private void enqueueIMC(final InterModEnqueueEvent event)
    {
        // some example code to dispatch IMC to another mod
        InterModComms.sendTo("Invigorated_Dimensions", "helloworld", () -> { LOGGER.info("Hello world from the MDK"); return "Hello world";});
    }

    private void processIMC(final InterModProcessEvent event)
    {

    }
    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(FMLServerStartingEvent event) {
        // do something when the server starts
        LOGGER.info("HELLO from server starting");
    }

    // You can use EventBusSubscriber to automatically subscribe events on the contained class (this is subscribing to the MOD
    // Event bus for receiving Registry Events)
    @Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
    public static class RegistryEvents {
        @SubscribeEvent
        public static void onBlocksRegistry(final RegistryEvent.Register<Block> blockRegistryEvent) {
            // register a new block here
            LOGGER.info("HELLO from Register Block");
        }
    }
}
