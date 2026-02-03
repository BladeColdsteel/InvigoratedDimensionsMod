package com.bladecoldsteel.invigorateddimensions.electrichighlands.entity.custom.projectiles;

import com.bladecoldsteel.invigorateddimensions.electrichighlands.entity.ElectricHighlandsEntityTypes;
import com.bladecoldsteel.invigorateddimensions.electrichighlands.item.ElectricHighlandsItems;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.LightningBoltEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.projectile.ProjectileItemEntity;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.network.IPacket;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.EntityRayTraceResult;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;

public class LightningItemProjectileEntity extends ProjectileItemEntity {
    public LightningItemProjectileEntity(EntityType<? extends ProjectileItemEntity> type, World world) {
        super(type, world);
    }

    public LightningItemProjectileEntity(World world, LivingEntity shooter) {
        super(ElectricHighlandsEntityTypes.LIGHTNING_BOLT_PROJECTILE.get(), shooter, world);
    }

    public LightningItemProjectileEntity(World world, double x, double y, double z) {
        super(ElectricHighlandsEntityTypes.LIGHTNING_BOLT_PROJECTILE.get(), x, y, z, world);
    }

    @Override
    protected Item getDefaultItem() {
        return ElectricHighlandsItems.LIGHTNING_BOLT.get();
    }

    @Override
    protected void onHitEntity(EntityRayTraceResult result) {
        super.onHitEntity(result);

        if (!this.level.isClientSide) {
            Entity entity = result.getEntity();
            LightningBoltEntity bolt = EntityType.LIGHTNING_BOLT.create(this.level);
            if (bolt != null) {
                bolt.moveTo(entity.getX(), entity.getY(), entity.getZ());
                bolt.setCause((ServerPlayerEntity) null);
                this.level.addFreshEntity(bolt);
            }
        }
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
    protected void onHitBlock(BlockRayTraceResult result) {
        super.onHitBlock(result);
        if (!this.level.isClientSide) {
            LightningBoltEntity bolt = EntityType.LIGHTNING_BOLT.create(this.level);
            if (bolt != null) {
                bolt.moveTo(result.getLocation());
                bolt.setCause((ServerPlayerEntity) null);
                this.level.addFreshEntity(bolt);
            }
        }
    }

    @Override
    public IPacket<?> getAddEntityPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }
}
