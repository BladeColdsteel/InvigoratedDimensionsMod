package com.bladecoldsteel.invigorateddimensions.dreamland.effects.custom;

import com.bladecoldsteel.invigorateddimensions.dreamland.client.MentalPrisonClientHooks;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.attributes.AttributeModifierManager;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectType;

public class MentalPrisonEffect extends Effect {
    private static final String PRISON_SET_NO_AI = "MentalPrisonSetNoAi";

    public MentalPrisonEffect() {
        super(EffectType.HARMFUL, 0xFF00AA);
    }

    @Override
    public void applyEffectTick(LivingEntity entity, int amplifier) {
        if (entity instanceof MobEntity) {
            MobEntity mob = (MobEntity) entity;
            mob.setDeltaMovement(0, 0, 0);
            mob.getNavigation().stop();

            CompoundNBT data = mob.getPersistentData();
            if (!mob.isNoAi()) {
                mob.setNoAi(true);
                data.putBoolean(PRISON_SET_NO_AI, true);
            }
            return;
        }

        if (entity.level.isClientSide) {
            MentalPrisonClientHooks.openScreenIfNeeded(entity);
        }
    }

    @Override
    public void removeAttributeModifiers(LivingEntity entity, AttributeModifierManager manager, int amplifier) {
        super.removeAttributeModifiers(entity, manager, amplifier);

        if (entity instanceof MobEntity) {
            MobEntity mob = (MobEntity) entity;
            CompoundNBT data = mob.getPersistentData();
            if (data.getBoolean(PRISON_SET_NO_AI)) {
                mob.setNoAi(false);
                data.remove(PRISON_SET_NO_AI);
            }
            return;
        }

        if (entity.level.isClientSide) {
            MentalPrisonClientHooks.closeScreenIfOpen(entity);
        }
    }

    @Override
    public boolean isDurationEffectTick(int duration, int amplifier) {
        return true;
    }
}
