package com.bladecoldsteel.invigorateddimensions.integrations.jei;

import com.bladecoldsteel.invigorateddimensions.InvigoratedDimensions;
import com.bladecoldsteel.invigorateddimensions.util.ritual.RitualData;
import com.bladecoldsteel.invigorateddimensions.util.ritual.RitualDataLoader;
import com.bladecoldsteel.invigorateddimensions.util.ritual.RitualDefinition;
import com.bladecoldsteel.invigorateddimensions.util.ritual.RitualType;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import net.minecraft.util.ResourceLocation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@JeiPlugin
public class InvigoratedDimensionsJei implements IModPlugin {
    @Override
    public ResourceLocation getPluginUid() {
        return new ResourceLocation(InvigoratedDimensions.MOD_ID, "jei_plugin");
    }

    @Override
    public void registerCategories(IRecipeCategoryRegistration registration) {
        registration.addRecipeCategories(new RitualRecipeCategory(registration.getJeiHelpers().getGuiHelper()));
    }

    @Override
    public void registerRecipes(IRecipeRegistration registration) {
        List<RitualDefinition> ritualData = new ArrayList<>(RitualData.getRitualsCollection());
        registration.addRecipes(ritualData, RitualRecipeCategory.UID);
    }
}
