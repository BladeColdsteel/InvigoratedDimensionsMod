package com.bladecoldsteel.invigorateddimensions.util.ritual;

import com.google.common.collect.Maps;
import net.minecraft.util.ResourceLocation;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class RitualData {
    private static final Map<ResourceLocation, RitualDefinition> RITUALS = new HashMap<>();
    private RitualData() {}

    public static void setRituals(Map<ResourceLocation, RitualDefinition> rituals) {
        RITUALS.clear();
        RITUALS.putAll(rituals);
    }

    public static Collection<RitualDefinition> getRitualsCollection() {
        return Collections.unmodifiableCollection(RITUALS.values());
    }

    public static Map<ResourceLocation, RitualDefinition> getRitualsMap() {
        return Maps.newHashMap(RITUALS);
    }

    public static RitualDefinition getRitual(ResourceLocation id) {
        return RITUALS.get(id);
    }

    public static void clear() {
        RITUALS.clear();
    }
}
