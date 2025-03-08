package com.bladecoldsteel.invigorateddimensions;

import com.bladecoldsteel.invigorateddimensions.draconicrift.block.DraconicRiftBlocks;
import com.bladecoldsteel.invigorateddimensions.draconicrift.block.DraconicRiftWoodTypes;
import com.bladecoldsteel.invigorateddimensions.draconicrift.item.DraconicRiftItems;
import com.bladecoldsteel.invigorateddimensions.electrichighlands.block.ElectricHighlandsBlocks;
import com.bladecoldsteel.invigorateddimensions.electrichighlands.block.ElectricHighlandsWoodTypes;
import com.bladecoldsteel.invigorateddimensions.electrichighlands.item.ElectricHighlandsItems;
import com.bladecoldsteel.invigorateddimensions.electrichighlands.tileentity.ElectricHighlandsTileEntities;
import com.bladecoldsteel.invigorateddimensions.electrichighlands.util.ElectricHighlandsSoundEvents;
import com.bladecoldsteel.invigorateddimensions.emberwilds.block.EmberwildsBlocks;
import com.bladecoldsteel.invigorateddimensions.emberwilds.block.EmberwildsWoodTypes;
import com.bladecoldsteel.invigorateddimensions.emberwilds.item.EmberwildsItems;
import com.bladecoldsteel.invigorateddimensions.grassyknoll.block.GrassyKnollBlocks;
import com.bladecoldsteel.invigorateddimensions.grassyknoll.block.GrassyKnollWoodTypes;
import com.bladecoldsteel.invigorateddimensions.grassyknoll.item.GrassyKnollItems;
import com.bladecoldsteel.invigorateddimensions.insectoidparadisio.block.InsectoidParadisioBlocks;
import com.bladecoldsteel.invigorateddimensions.insectoidparadisio.block.InsectoidParadisioWoodTypes;
import com.bladecoldsteel.invigorateddimensions.insectoidparadisio.item.InsectoidParadisioItems;
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
import com.bladecoldsteel.invigorateddimensions.world.gen.features.*;
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
        //Fire
        EmberwildsBlocks.register(eventBus);
        EmberwildsItems.register(eventBus);
        //Dragon
        DraconicRiftBlocks.register(eventBus);
        DraconicRiftItems.register(eventBus);
        //Grass
        GrassyKnollBlocks.register(eventBus);
        GrassyKnollItems.register(eventBus);
        //Bug
        InsectoidParadisioBlocks.register(eventBus);
        InsectoidParadisioItems.register(eventBus);

        DeferredRegister<?>[] registers = {
                //Electric
          ElectricFeatures.ELECTRIC_FEATURES,
          ElectricHighlandsStructures.STRUCTURES,
                //Water
          WaterFeatures.WATER_FEATURES,
                //Fire
          FireFeatures.FIRE_FEATURES,
                //Dragon
          DragonFeatures.DRAGON_FEATURE,
                //Grass
          GrassFeatures.GRASS_FEATURES,
                //Bug
          BugFeatures.BUG_FEATURES
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
            //Fire
            FireFeatures.registerConfiguredFeatures();
            //Dragon
            DragonFeatures.registerConfiguredFeatures();
            //Grass
            GrassFeatures.registerConfiguredFeatures();
            //Bug
            BugFeatures.registerConfiguredFeatures();

            //Strippable Wood
            AxeItem.STRIPABLES = new ImmutableMap.Builder<Block, Block>().putAll(AxeItem.STRIPABLES)
                    //Electric
                    .put(ElectricHighlandsBlocks.ELECTRICALLY_CHARGED_LOG.get(), ElectricHighlandsBlocks.STRIPPED_ELECTRICALLY_CHARGED_LOG.get())
                    .put(ElectricHighlandsBlocks.ELECTRICALLY_CHARGED_WOOD.get(), ElectricHighlandsBlocks.STRIPPED_ELECTRICALLY_CHARGED_WOOD.get())
                    //Water
                    .build();

            WoodType.register(ElectricHighlandsWoodTypes.ELECTRICALLY_CHARGED);
            WoodType.register(WateryDepthsWoodTypes.WATERY);
            WoodType.register(EmberwildsWoodTypes.EMBERED);
            WoodType.register(DraconicRiftWoodTypes.DRACONIC);
            WoodType.register(GrassyKnollWoodTypes.GRASSY);
            WoodType.register(InsectoidParadisioWoodTypes.BUGGED);

            InvigoratedDimensions.LOGGER.info("Registered Trees: {}", WorldGenRegistries.CONFIGURED_FEATURE.keySet());

            InvigoratedDimensions.LOGGER.info("Registered Feature Key: {}",
                    WorldGenRegistries.CONFIGURED_FEATURE.getKey(ElectricFeatures.ConfiguredFeatures.ELECTRIC_TREE));
            InvigoratedDimensions.LOGGER.info("Registered Feature Key: {}",
                    WorldGenRegistries.CONFIGURED_FEATURE.getKey(WaterFeatures.ConfiguredFeatures.WATERY_TREE));
            InvigoratedDimensions.LOGGER.info("Registered Feature Key: {}",
                    WorldGenRegistries.CONFIGURED_FEATURE.getKey(FireFeatures.ConfiguredFeatures.FIRE_TREE_STRAIGHT));
            InvigoratedDimensions.LOGGER.info("Registered Feature Key: {}",
                    WorldGenRegistries.CONFIGURED_FEATURE.getKey(FireFeatures.ConfiguredFeatures.FIRE_TREE_FUNKY));
            InvigoratedDimensions.LOGGER.info("Registered Feature Key: {}",
                    WorldGenRegistries.CONFIGURED_FEATURE.getKey(DragonFeatures.ConfiguredFeatures.DRACONIC_TREE));
            InvigoratedDimensions.LOGGER.info("Registered Feature Key: {}",
                    WorldGenRegistries.CONFIGURED_FEATURE.getKey(GrassFeatures.ConfiguredFeatures.GRASSY_TREE));
            InvigoratedDimensions.LOGGER.info("Registered Feature Key: {}",
                    WorldGenRegistries.CONFIGURED_FEATURE.getKey(BugFeatures.ConfiguredFeatures.BUGGED_TREE));

        });

    }

    private void doClientStuff(final FMLClientSetupEvent event) {

        //Universal
        RenderTypeLookup.setRenderLayer(UniversalBlocks.CRYSTALLIZED_LEAVES.get(), RenderType.cutout());

        //Electric
        RenderTypeLookup.setRenderLayer(ElectricHighlandsBlocks.ELECTRICALLY_CHARGED_SAPLING.get(), RenderType.cutout());

        RenderTypeLookup.setRenderLayer(ElectricHighlandsBlocks.ELECTRICALLY_CHARGED_DOOR.get(), RenderType.cutout());
        RenderTypeLookup.setRenderLayer(ElectricHighlandsBlocks.ELECTRICALLY_CHARGED_WOODEN_TRAPDOOR.get(), RenderType.cutout());

        ClientRegistry.bindTileEntityRenderer(ElectricHighlandsTileEntities.SIGN_TILE_ENTITIES.get(),
                SignTileEntityRenderer::new);

        //Water
        RenderTypeLookup.setRenderLayer(WateryDepthsBlocks.WATERY_SAPLING.get(), RenderType.cutout());

        //Fire
        RenderTypeLookup.setRenderLayer(EmberwildsBlocks.EMBERED_SAPLING.get(), RenderType.cutout());

        //Dragon
        RenderTypeLookup.setRenderLayer(DraconicRiftBlocks.DRACONIC_SAPLING.get(), RenderType.cutout());

        //Grass
        RenderTypeLookup.setRenderLayer(GrassyKnollBlocks.GRASSY_SAPLING.get(), RenderType.cutout());

        //Bug
        RenderTypeLookup.setRenderLayer(InsectoidParadisioBlocks.BUGGED_SAPLING.get(), RenderType.cutout());

        //Wood Types
        Atlases.addWoodType(ElectricHighlandsWoodTypes.ELECTRICALLY_CHARGED);
        Atlases.addWoodType(WateryDepthsWoodTypes.WATERY);
        Atlases.addWoodType(EmberwildsWoodTypes.EMBERED);
        Atlases.addWoodType(DraconicRiftWoodTypes.DRACONIC);
        Atlases.addWoodType(GrassyKnollWoodTypes.GRASSY);
        Atlases.addWoodType(InsectoidParadisioWoodTypes.BUGGED);
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
