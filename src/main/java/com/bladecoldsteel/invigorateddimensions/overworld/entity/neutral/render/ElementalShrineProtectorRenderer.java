package com.bladecoldsteel.invigorateddimensions.overworld.entity.neutral.render;

import com.bladecoldsteel.invigorateddimensions.overworld.entity.neutral.custom.ElementalShrineProtectorsEntity;
import com.bladecoldsteel.invigorateddimensions.overworld.entity.neutral.model.ElementalShrineProtectorModel;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class ElementalShrineProtectorRenderer extends GeoEntityRenderer<ElementalShrineProtectorsEntity> {
    public ElementalShrineProtectorRenderer(EntityRendererManager renderManager) {
        super(renderManager, new ElementalShrineProtectorModel());
        this.addLayer(new ElementalShrineProtectorOverlayRenderer(this));
    }
}
