package com.bladecoldsteel.invigorateddimensions.deeptundra.entity.projectile.custom;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.SnowballEntity;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.EntityRayTraceResult;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

public class HarmfulSnowballEntity extends SnowballEntity {

    public HarmfulSnowballEntity(EntityType<? extends SnowballEntity> p_i50159_1_, World p_i50159_2_) {
        super(p_i50159_1_, p_i50159_2_);
    }

    public HarmfulSnowballEntity(World p_i1774_1_, LivingEntity p_i1774_2_) {
        super(p_i1774_1_, p_i1774_2_);
    }

    public HarmfulSnowballEntity(World p_i1775_1_, double p_i1775_2_, double p_i1775_4_, double p_i1775_6_) {
        super(p_i1775_1_, p_i1775_2_, p_i1775_4_, p_i1775_6_);
    }

    @Override
    protected void onHitEntity(EntityRayTraceResult result) {
        super.onHitEntity(result);
        Entity entity = result.getEntity();
        entity.hurt(DamageSource.thrown(this, this.getOwner()), 10.0F);
        entity.push(this.getDeltaMovement().x * 0.1, 0.1, this.getDeltaMovement().z * 0.1);
    }

    @Override
    public void tick() {
        super.tick();

        if (!this.level.isClientSide && this.level instanceof ServerWorld) {
            ServerWorld world = (ServerWorld) this.level;

            world.sendParticles(ParticleTypes.END_ROD,
                    this.getX(),
                    this.getY(),
                    this.getZ(),
                    8,
                    0.08D,
                    0.08D,
                    0.08D,
                    0.02D);
        }
    }
}
