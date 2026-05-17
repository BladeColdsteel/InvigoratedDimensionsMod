package com.bladecoldsteel.invigorateddimensions.universal.entity.entitygoals.boss;

import com.bladecoldsteel.invigorateddimensions.universal.entity.entitybases.BossMonsterEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.particles.IParticleData;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.server.ServerWorld;

import java.util.EnumSet;

public class BossBreathGoal extends Goal {
    private final BossMonsterEntity boss;
    private final int combatCooldown;
    private final int breathDuration;
    private int breathTime;

    private LivingEntity target;

    private final Effect goalEffect;
    private final int effectLevel;
    private final int effectTime;
    private final boolean visibleEffect;
    private final boolean showIcon;

    private final IParticleData breathParticle;
    private final double breathRange;
    private final double coneAngle;
    private final int particleDensity;
    private final double particleSpeed;
    private final float damage;
    private final int hitInterval;

    public BossBreathGoal(BossMonsterEntity entity, int combatCooldown, int breathDuration, IParticleData breathParticle, double breathRange, double coneAngle, int particleDensity, double particleSpeed, float damage, int hitInterval, Effect effect, int effectLevel, int effectTime, boolean visibleEffect, boolean showIcon) {
        this.boss = entity;
        this.combatCooldown = combatCooldown;
        this.breathDuration = breathDuration;

        this.breathParticle = breathParticle;
        this.breathRange = breathRange;
        this.coneAngle = coneAngle;
        this.particleDensity = particleDensity;
        this.particleSpeed = particleSpeed;
        this.damage = damage;
        this.hitInterval = hitInterval;

        this.goalEffect = effect;
        this.effectLevel = effectLevel;
        this.effectTime = effectTime;
        this.visibleEffect = visibleEffect;
        this.showIcon = showIcon;

        this.setFlags(EnumSet.of(Flag.LOOK));
    }

    @Override
    public void start() {
        this.breathTime = 0;
    }

    @Override
    public void stop() {
        this.target = null;
        this.breathTime = 0;
    }

    @Override
    public void tick() {
        if (this.target == null || !this.target.isAlive()) return;

        this.boss.getLookControl().setLookAt(this.target, 60.0F, 60.0F);

        spawnBreathParticles();

        if (this.hitInterval > 0 && this.breathTime % this.hitInterval == 0) {
            damageEntitiesInCone();
        }

        this.breathTime++;
        if (this.breathTime >= this.breathDuration) {
            endBreath();
        }
    }

    @Override
    public boolean canUse() {
        LivingEntity target = this.boss.getTarget();

        if (!(target instanceof PlayerEntity)) {
            return false;
        }

        if (boss.isTargetValid() && boss.getCurrentAction() == BossMonsterEntity.CombatAction.BREATH) {
            this.target = target;
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean canContinueToUse() {
        return this.target instanceof PlayerEntity && this.target.isAlive() && boss.getCurrentAction() == BossMonsterEntity.CombatAction.BREATH;
    }

    @Override
    public boolean isInterruptable() {
        return false;
    }

    private void damageEntitiesInCone() {
        Vector3d mouthPos = getMouthPosition();
        Vector3d look = getBreathDirection();

        double coneDotThreshold = Math.cos(Math.toRadians(this.coneAngle / 2.0D));

        for (LivingEntity entity : this.boss.level.getEntitiesOfClass(LivingEntity.class, this.boss.getBoundingBox().inflate(this.breathRange))) {
            if (entity == this.boss || !entity.isAlive()) continue;

            Vector3d fromMouthToEntity = entity.position().add(0, entity.getBbHeight() * 0.5D, 0).subtract(mouthPos);
            double distance = fromMouthToEntity.length();

            if (distance > this.breathRange || distance <= 0.0D) continue;

            Vector3d directionToEntity = fromMouthToEntity.normalize();
            double dot = look.dot(directionToEntity);

            if (dot >= coneDotThreshold) {
                entity.hurt(DamageSource.mobAttack(this.boss), this.damage);

                if (this.goalEffect != null) {
                    int amplifier = this.effectLevel;
                    if (entity.hasEffect(this.goalEffect)) {
                        amplifier++;
                    }
                    entity.addEffect(new EffectInstance(
                            this.goalEffect,
                            this.effectTime,
                            amplifier,
                            false,
                            this.visibleEffect,
                            this.showIcon
                    ));
                }
            }
        }
    }

    private void spawnBreathParticles() {
        Vector3d mouthPos = getMouthPosition();
        Vector3d look = getBreathDirection();

        Vector3d right = new Vector3d(-look.z, 0, look.x).normalize();
        Vector3d up = right.cross(look).normalize();

        double progress = Math.min(1.0D, this.breathTime / 20.0D);
        double maxDistanceThisTick = this.breathRange * progress;

        for (int i = 0; i < particleDensity; i++) {
            double distance = this.boss.getRandom().nextDouble() * maxDistanceThisTick;
            double radius = distance * Math.tan(Math.toRadians(this.coneAngle / 2.0D));

            double angle = this.boss.getRandom().nextDouble() * Math.PI * 2.0D;
            double spread = this.boss.getRandom().nextDouble() * radius;

            Vector3d offset = look.scale(distance)
                    .add(right.scale(Math.cos(angle) * spread))
                    .add(up.scale(Math.sin(angle) * spread));

            Vector3d particlePos = mouthPos.add(offset);
            if (!this.boss.level.isClientSide && this.boss.level instanceof ServerWorld) {
                ((ServerWorld)this.boss.level).sendParticles(
                        this.breathParticle,
                        particlePos.x,
                        particlePos.y,
                        particlePos.z,
                        1,
                        0.0D, 0.0D, 0.0D,
                        this.particleSpeed
                );
            }
        }
    }

    private Vector3d getBreathDirection() {
        if (this.target == null) {
            return this.boss.getLookAngle().normalize();
        }

        Vector3d mouthPos = getMouthPositionRaw();
        Vector3d targetPos = this.target.position().add(0, this.target.getBbHeight() * 0.5D, 0);

        return targetPos.subtract(mouthPos).normalize();
    }

    private Vector3d getMouthPositionRaw() {
        return new Vector3d(boss.getX(), boss.getY() + 2.9D, boss.getZ());
    }

    private Vector3d getMouthPosition() {
        return getMouthPositionRaw().add(getBreathDirection().scale(0.6D));
    }

    private void endBreath() {
        boss.setCurrentAction(BossMonsterEntity.CombatAction.NONE);
        boss.resetCombatCooldown(this.combatCooldown);
    }
}
