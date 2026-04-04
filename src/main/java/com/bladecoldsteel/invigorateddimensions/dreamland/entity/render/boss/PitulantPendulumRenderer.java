package com.bladecoldsteel.invigorateddimensions.dreamland.entity.render.boss;

import com.bladecoldsteel.invigorateddimensions.dreamland.entity.custom.boss.PitulantPendulumEntity;
import com.bladecoldsteel.invigorateddimensions.dreamland.entity.model.boss.PitulantPendulumModel;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class PitulantPendulumRenderer extends GeoEntityRenderer<PitulantPendulumEntity> {
    public PitulantPendulumRenderer(EntityRendererManager renderManager) {
        super(renderManager, new PitulantPendulumModel());
    }
}
