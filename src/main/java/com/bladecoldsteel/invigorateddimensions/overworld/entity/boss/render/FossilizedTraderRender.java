package com.bladecoldsteel.invigorateddimensions.overworld.entity.boss.render;

import com.bladecoldsteel.invigorateddimensions.InvigoratedDimensions;
import com.bladecoldsteel.invigorateddimensions.overworld.entity.boss.custom.FossilizedTraderEntity;
import com.bladecoldsteel.invigorateddimensions.overworld.entity.boss.model.FossilizedTraderModel;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class FossilizedTraderRender extends MobRenderer<FossilizedTraderEntity, FossilizedTraderModel<FossilizedTraderEntity>> {
    public FossilizedTraderRender(EntityRendererManager manager) {
        super(manager, new FossilizedTraderModel(), 0.6F);
    }

    @Override
    public ResourceLocation getTextureLocation(FossilizedTraderEntity fossilizedTraderEntity) {
        return new ResourceLocation(InvigoratedDimensions.MOD_ID, "textures/entity/fossilized_trader.png");
    }
}
