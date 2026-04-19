package com.bladecoldsteel.invigorateddimensions.terranata.entity.render;

import com.bladecoldsteel.invigorateddimensions.terranata.entity.custom.GiantEarthmawEntity;
import com.bladecoldsteel.invigorateddimensions.terranata.entity.model.GiantEarthmawModel;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class GiantEarthmawRender extends GeoEntityRenderer<GiantEarthmawEntity> {
    public GiantEarthmawRender(EntityRendererManager manager) {
        super(manager, new GiantEarthmawModel());
    }
}
