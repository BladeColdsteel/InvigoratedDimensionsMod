package com.bladecoldsteel.invigorateddimensions.electrichighlands.entity.render.boss;

import com.bladecoldsteel.invigorateddimensions.electrichighlands.entity.custom.boss.RagingTempestEntity;
import com.bladecoldsteel.invigorateddimensions.electrichighlands.entity.model.boss.RagingTempestModel;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class RagingTempestRenderer extends GeoEntityRenderer<RagingTempestEntity> {
    public RagingTempestRenderer(EntityRendererManager renderManager) {
        super(renderManager, new RagingTempestModel());
    }
}
