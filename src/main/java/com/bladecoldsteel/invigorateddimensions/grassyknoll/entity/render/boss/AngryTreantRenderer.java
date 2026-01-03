package com.bladecoldsteel.invigorateddimensions.grassyknoll.entity.render.boss;

import com.bladecoldsteel.invigorateddimensions.grassyknoll.entity.custom.boss.AngryTreantEntity;
import com.bladecoldsteel.invigorateddimensions.grassyknoll.entity.model.boss.AngryTreantModel;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class AngryTreantRenderer extends GeoEntityRenderer<AngryTreantEntity> {
    public AngryTreantRenderer(EntityRendererManager renderManager) {
        super(renderManager, new AngryTreantModel());
    }
}
