package com.bladecoldsteel.invigorateddimensions.emberwilds.entity.model;

import com.bladecoldsteel.invigorateddimensions.emberwilds.entity.custom.FireLordEntity;
import net.minecraft.client.renderer.entity.model.AbstractZombieModel;

public class FireLordModel<T extends FireLordEntity> extends AbstractZombieModel<T> {
    public FireLordModel(float p_i51070_1_, float p_i51070_2_, int p_i51070_3_, int p_i51070_4_) {
        super(p_i51070_1_, p_i51070_2_, p_i51070_3_, p_i51070_4_);
    }

    @Override
    public boolean isAggressive(T t) {
        return false;
    }
}