package com.bladecoldsteel.invigorateddimensions.deeptundra.entity.boss.render;

import com.bladecoldsteel.invigorateddimensions.deeptundra.entity.boss.custom.RimeboundEntity;
import com.bladecoldsteel.invigorateddimensions.deeptundra.entity.boss.model.RimeboundModel;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class RimeboundRender extends GeoEntityRenderer<RimeboundEntity> {
    public RimeboundRender(EntityRendererManager manager) {
        super(manager, new RimeboundModel());
    }
}
