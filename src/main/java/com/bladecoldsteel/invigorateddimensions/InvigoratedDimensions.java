package com.bladecoldsteel.invigorateddimensions;

import com.bladecoldsteel.invigorateddimensions.celestialrealm.block.HeavenlyRealmBlocks;
import com.bladecoldsteel.invigorateddimensions.celestialrealm.block.HeavenlyRealmWoodTypes;
import com.bladecoldsteel.invigorateddimensions.celestialrealm.item.HeavenlyRealmItems;
import com.bladecoldsteel.invigorateddimensions.corrosivefields.block.CorrosiveFieldsBlocks;
import com.bladecoldsteel.invigorateddimensions.corrosivefields.block.CorrosiveFieldsWoodTypes;
import com.bladecoldsteel.invigorateddimensions.corrosivefields.item.CorrosiveFieldsItems;
import com.bladecoldsteel.invigorateddimensions.deeptundra.block.DeepTundraBlocks;
import com.bladecoldsteel.invigorateddimensions.deeptundra.block.DeepTundraWoodTypes;
import com.bladecoldsteel.invigorateddimensions.deeptundra.item.DeepTundraItems;
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
import com.bladecoldsteel.invigorateddimensions.feywildexpanse.block.FeywildExpanseBlocks;
import com.bladecoldsteel.invigorateddimensions.feywildexpanse.block.FeywildExpanseWoodTypes;
import com.bladecoldsteel.invigorateddimensions.feywildexpanse.item.FeywildExpanseItems;
import com.bladecoldsteel.invigorateddimensions.grassyknoll.block.GrassyKnollBlocks;
import com.bladecoldsteel.invigorateddimensions.grassyknoll.block.GrassyKnollWoodTypes;
import com.bladecoldsteel.invigorateddimensions.grassyknoll.item.GrassyKnollItems;
import com.bladecoldsteel.invigorateddimensions.infinitedungeon.block.InfiniteDungeonBlocks;
import com.bladecoldsteel.invigorateddimensions.infinitedungeon.block.InfiniteDungeonWoodTypes;
import com.bladecoldsteel.invigorateddimensions.infinitedungeon.item.InfiniteDungeonItems;
import com.bladecoldsteel.invigorateddimensions.insectoidparadisio.block.InsectoidParadisioBlocks;
import com.bladecoldsteel.invigorateddimensions.insectoidparadisio.block.InsectoidParadisioWoodTypes;
import com.bladecoldsteel.invigorateddimensions.insectoidparadisio.item.InsectoidParadisioItems;
import com.bladecoldsteel.invigorateddimensions.terranata.block.TerraNataBlocks;
import com.bladecoldsteel.invigorateddimensions.terranata.block.TerraNataWoodTypes;
import com.bladecoldsteel.invigorateddimensions.terranata.item.TerraNataItems;
import com.bladecoldsteel.invigorateddimensions.universal.block.UniversalBlocks;
import com.bladecoldsteel.invigorateddimensions.universal.item.UniversalItems;
import com.bladecoldsteel.invigorateddimensions.valleydeath.block.ValleyDeathBlocks;
import com.bladecoldsteel.invigorateddimensions.valleydeath.block.ValleyDeathWoodTypes;
import com.bladecoldsteel.invigorateddimensions.valleydeath.item.ValleyDeathItems;
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
        CustomFeatures.register(eventBus);
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
        //Dark
        ValleyDeathBlocks.register(eventBus);
        ValleyDeathItems.register(eventBus);
        //Fairy
        FeywildExpanseBlocks.register(eventBus);
        FeywildExpanseItems.register(eventBus);
        //Fighting
        InfiniteDungeonBlocks.register(eventBus);
        InfiniteDungeonItems.register(eventBus);
        //Ground
        TerraNataBlocks.register(eventBus);
        TerraNataItems.register(eventBus);
        //Flying
        HeavenlyRealmBlocks.register(eventBus);
        HeavenlyRealmItems.register(eventBus);
        //Ice
        DeepTundraBlocks.register(eventBus);
        DeepTundraItems.register(eventBus);
        //Poison
        CorrosiveFieldsBlocks.register(eventBus);
        CorrosiveFieldsItems.register(eventBus);

        DeferredRegister<?>[] registers = {
                //Electric
          ElectricFeatures.ELECTRIC_FEATURES,
          ElectricHighlandsStructures.STRUCTURES,
                //Water
          WaterFeatures.WATER_FEATURES,
                //Fire
          FireFeatures.FIRE_FEATURES,
                //Dragon
          DragonFeatures.DRAGON_FEATURES,
                //Grass
          GrassFeatures.GRASS_FEATURES,
                //Bug
          BugFeatures.BUG_FEATURES,
                //Dark
          DarkFeatures.DARK_FEATURES,
                //Fairy
          FairyFeatures.FAIRY_FEATURES,
                //Fighting
          FightingFeatures.FIGHTING_FEATURES,
                //Ground
          GroundFeatures.GROUND_FEATURES,
                //Flying
          FlyingFeatures.FLYING_FEATURES,
                //Ice
          IceFeatures.ICE_FEATURES,
                //Poison
          PoisonFeatures.POISON_FEATURES
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
            //Dark
            DarkFeatures.registerConfiguredFeatures();
            //Fairy
            FairyFeatures.registerConfiguredFeatures();
            //Fighting
            FightingFeatures.registerConfiguredFeatures();
            //Ground
            GroundFeatures.registerConfiguredFeatures();
            //Flying
            FlyingFeatures.registerConfiguredFeatures();
            //Ice
            IceFeatures.registerConfiguredFeatures();
            //Poison
            PoisonFeatures.registerConfiguredFeatures();

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
            WoodType.register(ValleyDeathWoodTypes.DARKENED);
            WoodType.register(FeywildExpanseWoodTypes.FEYAN);
            WoodType.register(InfiniteDungeonWoodTypes.TOUGH);
            WoodType.register(TerraNataWoodTypes.GROUNDED);
            WoodType.register(HeavenlyRealmWoodTypes.FLOATING);
            WoodType.register(DeepTundraWoodTypes.ICEY);
            WoodType.register(CorrosiveFieldsWoodTypes.CORROSIVE);

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

        //Dark
        RenderTypeLookup.setRenderLayer(ValleyDeathBlocks.DARKENED_SAPLING.get(), RenderType.cutout());

        //Fairy
        RenderTypeLookup.setRenderLayer(FeywildExpanseBlocks.FEYAN_SAPLING.get(), RenderType.cutout());

        //Fighting

        //Ground
        RenderTypeLookup.setRenderLayer(TerraNataBlocks.GROUNDED_SAPLING.get(), RenderType.cutout());

        //Flying
        RenderTypeLookup.setRenderLayer(HeavenlyRealmBlocks.FLOATING_SAPLING.get(), RenderType.cutout());

        //Ice
        RenderTypeLookup.setRenderLayer(DeepTundraBlocks.ICEY_SAPLING.get(), RenderType.cutout());

        //Poison
        RenderTypeLookup.setRenderLayer(CorrosiveFieldsBlocks.CORROSIVE_SAPLING.get(), RenderType.cutout());

        //Wood Types
        Atlases.addWoodType(ElectricHighlandsWoodTypes.ELECTRICALLY_CHARGED);
        Atlases.addWoodType(WateryDepthsWoodTypes.WATERY);
        Atlases.addWoodType(EmberwildsWoodTypes.EMBERED);
        Atlases.addWoodType(DraconicRiftWoodTypes.DRACONIC);
        Atlases.addWoodType(GrassyKnollWoodTypes.GRASSY);
        Atlases.addWoodType(InsectoidParadisioWoodTypes.BUGGED);
        Atlases.addWoodType(ValleyDeathWoodTypes.DARKENED);
        Atlases.addWoodType(FeywildExpanseWoodTypes.FEYAN);
        Atlases.addWoodType(InfiniteDungeonWoodTypes.TOUGH);
        Atlases.addWoodType(TerraNataWoodTypes.GROUNDED);
        Atlases.addWoodType(HeavenlyRealmWoodTypes.FLOATING);
        Atlases.addWoodType(DeepTundraWoodTypes.ICEY);
        Atlases.addWoodType(CorrosiveFieldsWoodTypes.CORROSIVE);
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
