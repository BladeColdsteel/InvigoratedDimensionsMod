package com.bladecoldsteel.invigorateddimensions.ultra.entity.projectile;

import com.bladecoldsteel.invigorateddimensions.ultra.entity.UltraDimEntityTypes;
import com.bladecoldsteel.invigorateddimensions.ultra.item.UltraDimItems;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.ProjectileItemEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.network.IPacket;
import net.minecraft.particles.IParticleData;
import net.minecraft.particles.ItemParticleData;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.EntityRayTraceResult;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.network.NetworkHooks;

public class BoarTuskProjectileEntity extends ProjectileItemEntity {
    public BoarTuskProjectileEntity(EntityType<? extends ProjectileItemEntity> entity, World world) {
        super(entity, world);
    }

    public BoarTuskProjectileEntity(LivingEntity shooter, World world) {
        super(UltraDimEntityTypes.BOAR_TUSK_PROJECTILE.get(), shooter, world);
    }

    public BoarTuskProjectileEntity(World world, double x, double y, double z) {
        super(UltraDimEntityTypes.BOAR_TUSK_PROJECTILE.get(), x, y, z, world);
    }

    @Override
    protected Item getDefaultItem() {
        return UltraDimItems.BOAR_TUSK.get();
    }

    @OnlyIn(Dist.CLIENT)
    private IParticleData getParticle() {
        ItemStack item = this.getItemRaw();
        return (IParticleData) (item.isEmpty() ? ParticleTypes.ITEM : new ItemParticleData(ParticleTypes.ITEM, item));
    }

    @Override
    public void handleEntityEvent(byte amount) {
        if (amount == 3) {
            IParticleData particle = this.getParticle();

            for (int i = 0; i < 8; ++i) {
                this.level.addParticle(particle, this.getX(), this.getY(), this.getZ(), 0.0, 0.0, 0.0);
            }
        }
    }

    @Override
    protected void onHitEntity(EntityRayTraceResult result) {
        super.onHitEntity(result);
        Entity entity = result.getEntity();
        int damage = entity instanceof PlayerEntity ? 5 : 0;
        entity.hurt(DamageSource.thrown(this, this.getOwner()), (float) damage);
        entity.push(this.getDeltaMovement().x * 0.1, 0.1, this.getDeltaMovement().z * 0.1);
    }

    @Override
    protected void onHit(RayTraceResult result) {
        super.onHit(result);
        if (!this.level.isClientSide) {
            this.level.broadcastEntityEvent(this, (byte) 3);
            this.remove();
        }
    }

    @Override
    public IPacket<?> getAddEntityPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }
}
