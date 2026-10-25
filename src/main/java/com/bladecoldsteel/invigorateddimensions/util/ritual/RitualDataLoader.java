package com.bladecoldsteel.invigorateddimensions.util.ritual;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import net.minecraft.client.resources.JsonReloadListener;
import net.minecraft.profiler.IProfiler;
import net.minecraft.resources.IResource;
import net.minecraft.resources.IResourceManager;
import net.minecraft.util.ResourceLocation;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class RitualDataLoader extends JsonReloadListener {
    private static final Gson GSON;
    public static final RitualDataLoader INSTANCE;

    static {
        GSON = new GsonBuilder().create();
        INSTANCE = new RitualDataLoader();
    }

    public RitualDataLoader() {
        super(GSON, "ritual");
    }

    @Override
    protected void apply(Map<ResourceLocation, JsonElement> jsonElementMap, IResourceManager resourceManager, IProfiler profiler) {
        Map<ResourceLocation, RitualDefinition> ritualData = new HashMap<>();
        for (Map.Entry<ResourceLocation, JsonElement> entry : jsonElementMap.entrySet()) {
            ResourceLocation id = entry.getKey();
            if (!id.getNamespace().equals("invigorated_dimensions")) {
                continue;
            }
            try {
                JsonObject obj = entry.getValue().getAsJsonObject();

                if (!obj.has("type") || !obj.has("dimension") || !obj.has("output") || !obj.has("input")) {
                    System.err.println("[RitualDataLoader] Skipping " + id + " - missing required fields");
                    continue;
                }

                RitualType typeId = RitualType.valueOf(obj.get("type").getAsString().toUpperCase());
                ResourceLocation dimensionId = new ResourceLocation(obj.get("dimension").getAsString());
                ResourceLocation outputId = new ResourceLocation(obj.get("output").getAsString());
                ResourceLocation inputId = new ResourceLocation(obj.get("input").getAsString());

                RitualDefinition.RitualSpecifics specifics = null;
                switch (typeId) {
                    case FIRE_SACRIFICE: {
                        JsonObject ritualObj = obj.getAsJsonObject("ritual");
                        ResourceLocation fireType = new ResourceLocation(ritualObj.get("fire_type").getAsString());
                        specifics = new RitualDefinition.FireType(fireType);
                        break;
                    }
                    case FLUID_SACRIFICE: {
                        JsonObject ritualObj = obj.getAsJsonObject("ritual");
                        ResourceLocation fluidType = new ResourceLocation(ritualObj.get("fluid_type").getAsString());
                        specifics = new RitualDefinition.FluidType(fluidType);
                        break;
                    }
                    default: System.out.println(
                            "[RitualDataLoader] Ritual type not implemented yet: " + typeId
                    );
                        continue;
                }

                RitualDefinition definition = new RitualDefinition(typeId, dimensionId, inputId, outputId, specifics);

                ritualData.put(id, definition);
            } catch (Exception e) {
                System.err.println("Failed to load ritual data from " + entry.getKey() + ": " + e.getMessage());
            }
        }
        RitualData.setRituals(ritualData);
    }

    @Override
    protected Map<ResourceLocation, JsonElement> prepare(IResourceManager resourceManager, IProfiler profiler) {
        Map<ResourceLocation, JsonElement> loaded = new HashMap<>();
        try {
            for (ResourceLocation rl : resourceManager.listResources("ritual", path -> path.endsWith(".json"))) {
                try {
                    IResource resource = resourceManager.getResource(rl);
                    try (InputStream stream = resource.getInputStream()) {
                        JsonElement json = GSON.fromJson(new InputStreamReader(stream), JsonElement.class);
                        loaded.put(rl, json);
                        System.out.println("[DEBUG] Successfully loaded: " + rl);
                    }
                } catch (Exception e) {
                    System.err.println("[ERROR] Failed to load: " + rl + " - " + e.getMessage());
                    e.printStackTrace();
                }
            }
        } catch (Exception e) {
            System.err.println("[ERROR] Manual prepare failed: " + e.getMessage());
            e.printStackTrace();
        }
        return loaded;
    }
}
