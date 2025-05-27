package com.bladecoldsteel.invigorateddimensions.electrichighlands.effects.custom;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.attributes.AttributeModifierManager;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ParalyzedEffect extends Effect {
    public ParalyzedEffect() {
        super(EffectType.HARMFUL, 7435822);
    }

    @Override
    public void applyEffectTick(LivingEntity entity, int amplifier) {
        if (entity.level.isClientSide) return;

        entity.setDeltaMovement(0, 0, 0);
        entity.fallDistance = 0;
        entity.hurtMarked = true;

        if (entity instanceof MobEntity) {
            MobEntity mob = (MobEntity) entity;
            if (!mob.isNoAi()) {
                mob.setNoAi(true);
            }
        }

        if (entity instanceof PlayerEntity) {
            PlayerEntity player = (PlayerEntity) entity;
            player.resetAttackStrengthTicker();
        }
    }

    @Override
    public void removeAttributeModifiers(LivingEntity entity, AttributeModifierManager manager, int amplifier) {
        super.removeAttributeModifiers(entity, manager, amplifier);
        if (entity instanceof MobEntity) {
            MobEntity mob = (MobEntity) entity;
            if (mob.isNoAi()) {
                mob.setNoAi(false);
            }
        }
    }

    @Override
    public boolean isDurationEffectTick(int duration, int amplifier) {
        return duration > 0;
    }
}
