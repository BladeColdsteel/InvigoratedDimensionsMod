package com.bladecoldsteel.invigorateddimensions.ultra.entity.boss.render;

import com.bladecoldsteel.invigorateddimensions.ultra.entity.boss.custom.BeastlyBoarEntity;
import com.bladecoldsteel.invigorateddimensions.ultra.entity.boss.model.BeastlyBoarModel;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class BeastlyBoarRender extends GeoEntityRenderer<BeastlyBoarEntity> {
    public BeastlyBoarRender(EntityRendererManager manager) {
        super(manager, new BeastlyBoarModel());
    }
}
