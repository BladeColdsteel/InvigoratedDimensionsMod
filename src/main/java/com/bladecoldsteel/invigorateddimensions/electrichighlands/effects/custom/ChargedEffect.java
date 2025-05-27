package com.bladecoldsteel.invigorateddimensions.electrichighlands.effects.custom;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.LightningBoltEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.Mod;

import java.util.Random;

@Mod.EventBusSubscriber
public class ChargedEffect extends Effect {
    public ChargedEffect() {
        super(EffectType.NEUTRAL, 14608942);
    }

    @Override
    public void applyEffectTick(LivingEntity entity, int amplifier) {
        World world = entity.level;
        BlockPos pos = new BlockPos(entity.getX(), entity.getY(), entity.getZ());
        int level = amplifier + 1;
        Random lightningChance = entity.getRandom();

        if (!world.isClientSide && lightningChance.nextInt(100) < 0.05 * level) {
            LightningBoltEntity lightningBolt = EntityType.LIGHTNING_BOLT.create(world);
            if (lightningBolt != null) {
                lightningBolt.moveTo(pos.getX(), pos.getY(), pos.getZ());
                if (entity instanceof ServerPlayerEntity) {
                    lightningBolt.setCause((ServerPlayerEntity) entity);
                }
                world.addFreshEntity(lightningBolt);
            }
        }
    }

    @Override
    public boolean isDurationEffectTick(int duration, int amplifier) {
        return duration > 0;
    }
}
