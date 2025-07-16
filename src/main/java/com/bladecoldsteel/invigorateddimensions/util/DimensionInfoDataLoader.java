package com.bladecoldsteel.invigorateddimensions.util;

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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DimensionInfoDataLoader extends JsonReloadListener {
    public static final DimensionInfoDataLoader INSTANCE;

    static {
        System.out.println("[DimensionInfoDataLoader] Static block start");
        INSTANCE = new DimensionInfoDataLoader();
        System.out.println("[DimensionInfoDataLoader] Static block end");
    }

    private static final Gson GSON;

    static {
        GSON = new GsonBuilder().create();
        System.out.println("[DimensionInfoDataLoader] GSON initialized");
    }

    public final Map<ResourceLocation, DimensionInfo> dimensionData = new HashMap<>();

    public DimensionInfoDataLoader() {
        super(GSON, "shrine");
        System.out.println("[DimensionInfoDataLoader] Constructor called");
    }

    @Override
    protected Map<ResourceLocation, JsonElement> prepare(IResourceManager resourceManager, IProfiler profiler) {
        Map<ResourceLocation, JsonElement> loaded = new HashMap<>();
        try {
            for (ResourceLocation rl : resourceManager.listResources("shrine", path -> path.endsWith(".json"))) {
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

    @Override
    protected void apply(Map<ResourceLocation, JsonElement> jsonMap, IResourceManager resourceManager, IProfiler profiler) {
        System.out.println("[DimensionInfoDataLoader] APPLY CALLED");
        dimensionData.clear();

        for (Map.Entry<ResourceLocation, JsonElement> entry : jsonMap.entrySet()) {
            ResourceLocation id = entry.getKey();
            if (!id.getNamespace().equals("invigorated_dimensions")) {
                continue;
            }
            try {
                JsonObject obj = entry.getValue().getAsJsonObject();

                if (!obj.has("dimension") || !obj.has("display_item")) {
                    System.err.println("[DimensionInfoDataLoader] Skipping " + id + " - missing required fields");
                    continue;
                }

                ResourceLocation dimensionId = new ResourceLocation(obj.get("dimension").getAsString());
                ResourceLocation displayItemId = new ResourceLocation(obj.get("display_item").getAsString());

                String name = obj.has("name") ? obj.get("name").getAsString() : dimensionId.toString();
                int color = obj.has("color") ? obj.get("color").getAsInt() : 0xFFFFFF;

                DimensionInfo.PortalUnlockConditions conditions = null;
                if (obj.has("portal_unlock_conditions")) {
                    JsonObject condObj = obj.getAsJsonObject("portal_unlock_conditions");

                    ResourceLocation advancement = condObj.has("advancement") ? new ResourceLocation(condObj.get("advancement").getAsString()) : null;
                    ResourceLocation mobKill = condObj.has("mob_kill") ? new ResourceLocation(condObj.get("mob_kill").getAsString()) : null;

                    conditions = new DimensionInfo.PortalUnlockConditions(advancement, mobKill);
                }

                DimensionInfo.TeleportationRecipe recipe = null;
                if (obj.has("recipe")) {
                    List<DimensionInfo.TeleportationIngredient> ingredients = new ArrayList<>();
                    for (JsonElement element : obj.getAsJsonArray("recipe")) {
                        JsonObject ing = element.getAsJsonObject();
                        if (!ing.has("item")) continue;

                        ResourceLocation itemId = new ResourceLocation(ing.get("item").getAsString());
                        int count = ing.has("count") ? ing.get("count").getAsInt() : 1;

                        ingredients.add(new DimensionInfo.TeleportationIngredient(itemId, count));
                    }

                    if (!ingredients.isEmpty()) {
                        recipe = new DimensionInfo.TeleportationRecipe(ingredients);
                    }
                }

                dimensionData.put(dimensionId, new DimensionInfo(dimensionId, displayItemId, name, color, conditions, recipe));
            } catch (Exception e) {
                System.err.println("Failed to load dimension display data from " + entry.getKey() + ": " + e.getMessage());
            }
        }
        System.out.println("[DimensionInfoDataLoader] Loaded entries: " + jsonMap.size());
    }
}
