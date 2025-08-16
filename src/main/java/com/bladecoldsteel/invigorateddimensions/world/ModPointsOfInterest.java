package com.bladecoldsteel.invigorateddimensions.world;

import com.bladecoldsteel.invigorateddimensions.InvigoratedDimensions;
import com.bladecoldsteel.invigorateddimensions.cavernouscove.block.CavernousCoveBlocks;
import com.bladecoldsteel.invigorateddimensions.celestialrealm.block.HeavenlyRealmBlocks;
import com.bladecoldsteel.invigorateddimensions.corrosivefields.block.CorrosiveFieldsBlocks;
import com.bladecoldsteel.invigorateddimensions.deeptundra.block.DeepTundraBlocks;
import com.bladecoldsteel.invigorateddimensions.dreamland.block.DreamlandBlocks;
import com.bladecoldsteel.invigorateddimensions.electrichighlands.block.ElectricHighlandsBlocks;
import com.bladecoldsteel.invigorateddimensions.feywildexpanse.block.FeywildExpanseBlocks;
import com.bladecoldsteel.invigorateddimensions.ghastlymarsh.block.GhastlyMarshBlocks;
import com.bladecoldsteel.invigorateddimensions.grassyknoll.block.GrassyKnollBlocks;
import com.bladecoldsteel.invigorateddimensions.infinitedungeon.block.InfiniteDungeonBlocks;
import com.bladecoldsteel.invigorateddimensions.insectoidparadisio.block.InsectoidParadisioBlocks;
import com.bladecoldsteel.invigorateddimensions.metallicmountains.block.MetallicMountainsBlocks;
import com.bladecoldsteel.invigorateddimensions.terranata.block.TerraNataBlocks;
import com.bladecoldsteel.invigorateddimensions.valleydeath.block.ValleyDeathBlocks;
import com.bladecoldsteel.invigorateddimensions.waterydepths.block.WateryDepthsBlocks;
import net.minecraft.village.PointOfInterestType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModPointsOfInterest {

    public static final DeferredRegister<PointOfInterestType> POI = DeferredRegister.create(ForgeRegistries.POI_TYPES, InvigoratedDimensions.MOD_ID);

    public static final RegistryObject<PointOfInterestType> ELECTRIC_HIGHLANDS_PORTAL = POI.register("electric_highlands_portal",
            () -> new PointOfInterestType("electric_highlands_portal", PointOfInterestType.getBlockStates(ElectricHighlandsBlocks.PORTAL.get()), 0, 1));

    public static final RegistryObject<PointOfInterestType> CAVERNOUS_COVE_PORTAL = POI.register("cavernous_cove_portal",
            () -> new PointOfInterestType("cavernous_cove_portal", PointOfInterestType.getBlockStates(CavernousCoveBlocks.PORTAL.get()), 0, 1));

    public static final RegistryObject<PointOfInterestType> CELESTIAL_REALM_PORTAL = POI.register("celestial_realm_portal",
            () -> new PointOfInterestType("celestial_realm_portal", PointOfInterestType.getBlockStates(HeavenlyRealmBlocks.PORTAL.get()), 0, 1));

    public static final RegistryObject<PointOfInterestType> CORROSIVE_FIELDS_PORTAL = POI.register("corrosive_fields_portal",
            () -> new PointOfInterestType("corrosive_fields_portal", PointOfInterestType.getBlockStates(CorrosiveFieldsBlocks.PORTAL.get()), 0, 1));

    public static final RegistryObject<PointOfInterestType> DEEP_TUNDRA_PORTAL = POI.register("deep_tundra_portal",
            () -> new PointOfInterestType("deep_tundra_portal", PointOfInterestType.getBlockStates(DeepTundraBlocks.PORTAL.get()), 0, 1));

    public static final RegistryObject<PointOfInterestType> DREAMLAND_PORTAL = POI.register("dreamland_portal",
            () -> new PointOfInterestType("dreamland_portal", PointOfInterestType.getBlockStates(DreamlandBlocks.PORTAL.get()), 0, 1));

    public static final RegistryObject<PointOfInterestType> FEYWILD_EXPANSE_PORTAL = POI.register("feywild_expanse_portal",
            () -> new PointOfInterestType("feywild_expanse_portal", PointOfInterestType.getBlockStates(FeywildExpanseBlocks.PORTAL.get()), 0, 1));

    public static final RegistryObject<PointOfInterestType> GHASTLY_MARSH_PORTAL = POI.register("ghastly_marsh_portal",
            () -> new PointOfInterestType("ghastly_marsh_portal", PointOfInterestType.getBlockStates(GhastlyMarshBlocks.PORTAL.get()), 0, 1));

    public static final RegistryObject<PointOfInterestType> GRASSY_KNOLL_PORTAL = POI.register("grassy_knoll_portal",
            () -> new PointOfInterestType("grassy_knoll_portal", PointOfInterestType.getBlockStates(GrassyKnollBlocks.PORTAL.get()), 0, 1));

    public static final RegistryObject<PointOfInterestType> INFINITE_DUNGEON_PORTAL = POI.register("infinite_dungeon_portal",
            () -> new PointOfInterestType("infinite_dungeon_portal", PointOfInterestType.getBlockStates(InfiniteDungeonBlocks.PORTAL.get()), 0, 1));

    public static final RegistryObject<PointOfInterestType> INSECTOID_PARADISIO_PORTAL = POI.register("insectoid_paradisio_portal",
            () -> new PointOfInterestType("insectoid_paradisio_portal", PointOfInterestType.getBlockStates(InsectoidParadisioBlocks.PORTAL.get()), 0, 1));

    public static final RegistryObject<PointOfInterestType> METALLIC_MOUNTAINS_PORTAL = POI.register("metallic_mountains_portal",
            () -> new PointOfInterestType("metallic_mountains_portal", PointOfInterestType.getBlockStates(MetallicMountainsBlocks.PORTAL.get()), 0, 1));

    public static final RegistryObject<PointOfInterestType> TERRA_NATA_PORTAL = POI.register("terra_nata_portal",
            () -> new PointOfInterestType("terra_nata_portal", PointOfInterestType.getBlockStates(TerraNataBlocks.PORTAL.get()), 0, 1));

    public static final RegistryObject<PointOfInterestType> VALLEY_DEATH_PORTAL = POI.register("valley_of_death_portal",
            () -> new PointOfInterestType("valley_of_death_portal", PointOfInterestType.getBlockStates(ValleyDeathBlocks.PORTAL.get()), 0, 1));

    public static final RegistryObject<PointOfInterestType> WATERY_DEPTHS_PORTAL = POI.register("watery_depths_portal",
            () -> new PointOfInterestType("watery_depths_portal", PointOfInterestType.getBlockStates(WateryDepthsBlocks.PORTAL.get()), 0, 1));

    public static void register(IEventBus eventBus) {
        POI.register(eventBus);
        System.out.println("Registering Point of Interest: Electric Highlands Portal");
        ELECTRIC_HIGHLANDS_PORTAL.ifPresent(poi -> {
            System.out.println("POI Name: " + poi.toString());
            System.out.println("Registered Blocks: " + poi.getBlockStates());
        });
        System.out.println("Registering Point of Interest: Cavernous Cove Portal");
        CAVERNOUS_COVE_PORTAL.ifPresent(poi -> {
            System.out.println("POI Name: " + poi.toString());
            System.out.println("Registered Blocks: " + poi.getBlockStates());
        });
        System.out.println("Registering Point of Interest: Celestial Realm Portal");
        CELESTIAL_REALM_PORTAL.ifPresent(poi -> {
            System.out.println("POI Name: " + poi.toString());
            System.out.println("Registered Blocks: " + poi.getBlockStates());
        });
        System.out.println("Registering Point of Interest: Corrosive Fields Portal");
        CORROSIVE_FIELDS_PORTAL.ifPresent(poi -> {
            System.out.println("POI Name: " + poi.toString());
            System.out.println("Registered Blocks: " + poi.getBlockStates());
        });
        System.out.println("Registering Point of Interest: Deep Tundra Portal");
        DEEP_TUNDRA_PORTAL.ifPresent(poi -> {
            System.out.println("POI Name: " + poi.toString());
            System.out.println("Registered Blocks: " + poi.getBlockStates());
        });
        System.out.println("Registering Point of Interest: Dreamland Portal");
        DREAMLAND_PORTAL.ifPresent(poi -> {
            System.out.println("POI Name: " + poi.toString());
            System.out.println("Registered Blocks: " + poi.getBlockStates());
        });
        System.out.println("Registering Point of Interest: Feywild Expanse Portal");
        FEYWILD_EXPANSE_PORTAL.ifPresent(poi -> {
            System.out.println("POI Name: " + poi.toString());
            System.out.println("Registered Blocks: " + poi.getBlockStates());
        });
        System.out.println("Registering Point of Interest: Ghastly Marsh Portal");
        GHASTLY_MARSH_PORTAL.ifPresent(poi -> {
            System.out.println("POI Name: " + poi.toString());
            System.out.println("Registered Blocks: " + poi.getBlockStates());
        });
        System.out.println("Registering Point of Interest: Grassy Knoll Portal");
        GRASSY_KNOLL_PORTAL.ifPresent(poi -> {
            System.out.println("POI Name: " + poi.toString());
            System.out.println("Registered Blocks: " + poi.getBlockStates());
        });
        System.out.println("Registering Point of Interest: Infinite Dungeon Portal");
        INFINITE_DUNGEON_PORTAL.ifPresent(poi -> {
            System.out.println("POI Name: " + poi.toString());
            System.out.println("Registered Blocks: " + poi.getBlockStates());
        });
        System.out.println("Registering Point of Interest: Insectoid Paradisio Portal");
        INSECTOID_PARADISIO_PORTAL.ifPresent(poi -> {
            System.out.println("POI Name: " + poi.toString());
            System.out.println("Registered Blocks: " + poi.getBlockStates());
        });
        System.out.println("Registering Point of Interest: Metallic Mountains Portal");
        METALLIC_MOUNTAINS_PORTAL.ifPresent(poi -> {
            System.out.println("POI Name: " + poi.toString());
            System.out.println("Registered Blocks: " + poi.getBlockStates());
        });
        System.out.println("Registering Point of Interest: Terra Nata Portal");
        TERRA_NATA_PORTAL.ifPresent(poi -> {
            System.out.println("POI Name: " + poi.toString());
            System.out.println("Registered Blocks: " + poi.getBlockStates());
        });
        System.out.println("Registering Point of Interest: Valley of Death Portal");
        VALLEY_DEATH_PORTAL.ifPresent(poi -> {
            System.out.println("POI Name: " + poi.toString());
            System.out.println("Registered Blocks: " + poi.getBlockStates());
        });
        System.out.println("Registering Point of Interest: Watery Depths Portal");
        WATERY_DEPTHS_PORTAL.ifPresent(poi -> {
            System.out.println("POI Name: " + poi.toString());
            System.out.println("Registered Blocks: " + poi.getBlockStates());
        });
    }

}
