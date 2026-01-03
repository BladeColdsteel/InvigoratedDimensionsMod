package com.bladecoldsteel.invigorateddimensions.grassyknoll.entity.custom.boss;

import com.bladecoldsteel.invigorateddimensions.config.InvigoratedDimensionsConfig;
import com.bladecoldsteel.invigorateddimensions.grassyknoll.entity.GrassyKnollEntityTypes;
import com.bladecoldsteel.invigorateddimensions.grassyknoll.item.GrassyKnollItems;
import com.bladecoldsteel.invigorateddimensions.universal.entity.entitygoals.GrowTreeGoal;
import com.bladecoldsteel.invigorateddimensions.universal.entity.entitygoals.SpawnOnPlayer;
import com.bladecoldsteel.invigorateddimensions.world.gen.features.*;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.projectile.ProjectileItemEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.IPacket;
import net.minecraft.particles.IParticleData;
import net.minecraft.particles.ItemParticleData;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.*;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.*;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Features;
import net.minecraft.world.server.ServerBossInfo;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.network.NetworkHooks;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;
import software.bernie.geckolib3.util.GeckoLibUtil;

import javax.annotation.Nullable;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class AngryTreantEntity extends MonsterEntity implements IAnimatable, IRangedAttackMob, SpawnOnPlayer {
    private final ServerBossInfo bossEvent;
    protected static final AnimationBuilder WALK_ANIM = new AnimationBuilder().addAnimation("animation.model.walk");
    protected static final AnimationBuilder APPLE_ANIM = new AnimationBuilder().addAnimation("animation.model.apple_attack");
    private int throwing;
    private int growTree;
    private int projectileBlockHits;

    private final AnimationFactory factory = GeckoLibUtil.createFactory(this);

    public AngryTreantEntity(EntityType<? extends MonsterEntity> type, World worldIn) {
        super(type, worldIn);
        this.bossEvent = (ServerBossInfo) (new ServerBossInfo(this.getDisplayName(), BossInfo.Color.GREEN, BossInfo.Overlay.PROGRESS)).setDarkenScreen(true);
        this.setHealth(this.getMaxHealth());
    }

    @Nullable
    @Override
    public ILivingEntityData finalizeSpawn(IServerWorld world, DifficultyInstance difficulty, SpawnReason reason, @Nullable ILivingEntityData data, @Nullable CompoundNBT compoundNBT) {
        projectileBlockHits = 0;
        return super.finalizeSpawn(world, difficulty, reason, data, compoundNBT);
    }

    public static AttributeModifierMap.MutableAttribute setCustomAttributes() {
        if (InvigoratedDimensionsConfig.DIFFICULTY_MODE.get().equalsIgnoreCase("progressive")) {
            return MonsterEntity.createMobAttributes()
                    .add(Attributes.MAX_HEALTH, 200.0D)
                    .add(Attributes.ARMOR, 3.0D)
                    .add(Attributes.ARMOR_TOUGHNESS, 1.0D)
                    .add(Attributes.KNOCKBACK_RESISTANCE, 0.75D)
                    .add(Attributes.MOVEMENT_SPEED, 0.34D)
                    .add(Attributes.FOLLOW_RANGE, 50.0D)
                    .add(Attributes.ATTACK_DAMAGE, 3.0D);
        } else if (InvigoratedDimensionsConfig.DIFFICULTY_MODE.get().equalsIgnoreCase("linear")) {
            return MonsterEntity.createMobAttributes()
                    .add(Attributes.MAX_HEALTH, 250.0D)
                    .add(Attributes.ARMOR, 3.0D)
                    .add(Attributes.ARMOR_TOUGHNESS, 1.0D)
                    .add(Attributes.KNOCKBACK_RESISTANCE, 0.75D)
                    .add(Attributes.MOVEMENT_SPEED, 0.3D)
                    .add(Attributes.FOLLOW_RANGE, 45.0D)
                    .add(Attributes.ATTACK_DAMAGE, 5.0D);
        } else {
            return MonsterEntity.createMobAttributes()
                    .add(Attributes.MAX_HEALTH, 200.0D)
                    .add(Attributes.ARMOR, 3.0D)
                    .add(Attributes.ARMOR_TOUGHNESS, 1.0D)
                    .add(Attributes.KNOCKBACK_RESISTANCE, 0.75D)
                    .add(Attributes.MOVEMENT_SPEED, 0.34D)
                    .add(Attributes.FOLLOW_RANGE, 50.0D)
                    .add(Attributes.ATTACK_DAMAGE, 3.0D);
        }
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(0, new SwimGoal(this));
        this.goalSelector.addGoal(1, new DistanceRangedAttackGoal(this, 1.25D, 10, 24.0F, 16.0F));
        this.goalSelector.addGoal(2, new GrowTreeGoal<>(this, 1.0D, 40, 80, 15));
        this.goalSelector.addGoal(3, new MeleeAttackGoal(this, 1, true));
        this.goalSelector.addGoal(4, new LookAtGoal(this, PlayerEntity.class, 8.0F));
        this.goalSelector.addGoal(5, new MoveTowardsTargetGoal(this, 1.0D, 30.0F));

        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, PlayerEntity.class, false, false));
        this.targetSelector.addGoal(2, new HurtByTargetGoal(this));
    }

    @Override
    public boolean canChangeDimensions() {
        return false;
    }

    @Override
    protected int getExperienceReward(PlayerEntity player) {
        return (int) (this.random.nextInt(40) + this.getHealth());
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundEvents.WOOD_STEP;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource damageSource) {
        return SoundEvents.WOOD_HIT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.WOOD_BREAK;
    }

    @Override
    protected void playStepSound(BlockPos pos, BlockState blockState) {
        this.playSound(SoundEvents.WOOD_PLACE, 0.2F, 1.0F);
    }

    @Override
    public void setCustomName(@Nullable ITextComponent name) {
        super.setCustomName(name);
        this.bossEvent.setName(this.getDisplayName());
    }

    @Override
    public void startSeenByPlayer(ServerPlayerEntity player) {
        super.startSeenByPlayer(player);
        this.bossEvent.addPlayer(player);
    }

    @Override
    public void stopSeenByPlayer(ServerPlayerEntity player) {
        super.stopSeenByPlayer(player);
        this.bossEvent.removePlayer(player);
    }

    @Override
    public void aiStep() {
        super.aiStep();
        this.bossEvent.setPercent(this.getHealth() / this.getMaxHealth());
        if (!level.isClientSide) {
            if (throwing > 0) {
                throwing--;
            }

            if (growTree > 0) {
                growTree--;
            }
        }
    }

    @Override
    public void checkDespawn() {
        if (this.level.getDifficulty() == Difficulty.PEACEFUL && this.shouldDespawnInPeaceful()) {
            this.remove();
        } else {
            this.noActionTime = 0;
        }
    }

    public boolean dropApplesauce() {
        float minChance = 0.01F;
        float decayFactor = 0.9F;
        float chance = (0.99F * (float) Math.pow((double) decayFactor, (double) projectileBlockHits)) + minChance;
        projectileBlockHits++;
        if (chance >= this.random.nextFloat()) {
            return true;
        }
            return false;
    }

    @Override
    public void registerControllers(final AnimationData data) {
        data.addAnimationController(new AnimationController<>(this, "Animations", 5, this::animationController));
    }

    protected <E extends AngryTreantEntity> PlayState animationController(final AnimationEvent<E> event) {
        if (throwing > 0) {
            event.getController().setAnimation(APPLE_ANIM);
            return PlayState.CONTINUE;
        } else if (event.isMoving()) {
            event.getController().setAnimation(WALK_ANIM);
            return PlayState.CONTINUE;
        }

        return PlayState.STOP;
    }

    public void startGrowthAttack() {
        growTree = 100;
    }

    public void startThrowAttack() {
        throwing = 20;
    }

    @Override
    public AnimationFactory getFactory() {
        return this.factory;
    }

    @Override
    public void performRangedAttack(LivingEntity target, float distanceFactor) {
        if (target.distanceTo(this) >= 16 && target.distanceTo(this) <= 24) {
            this.startThrowAttack();
            AppleItemProjectile projectile = new AppleItemProjectile(this.level, this);
            projectile.setOwner(this);
            projectile.setPos(this.getX(), this.getEyeY() - 0.1, this.getZ());

            double dx = target.getX() - this.getX();
            double dz = target.getZ() - this.getZ();
            double dy = target.getEyeY() - projectile.getY();
            double horizon = MathHelper.sqrt(dx * dx + dz * dz);
            dy += horizon * 0.1;

            float speed = 1.6F;
            float inaccuracy = (float)(10 - this.level.getDifficulty().getId() * 4);

            projectile.shoot(dx, dy, dz, speed, inaccuracy);
            this.playSound(SoundEvents.CROP_PLANTED, 1.0F, 1.0F / (this.getRandom().nextFloat() * 0.4F + 0.8F));
            this.level.addFreshEntity(projectile);
        }
    }

    @Override
    public void spawnOnPlayer(LivingEntity target, float distanceFactor) {
        this.startGrowthAttack();
        System.out.println("Spawning Tree");
        if (!(target.level instanceof ServerWorld)) {
            return;
        }

        ServerWorld seed = (ServerWorld) target.level;
        ChunkGenerator chunkGen = seed.getChunkSource().getGenerator();
        Random random1 = this.getRandom();

        BlockPos underneath = new BlockPos(target.getX() , target.getY() - 1, target.getZ());

        BlockState dirtSet = Blocks.DIRT.defaultBlockState();
        BlockState airSet = Blocks.AIR.defaultBlockState();
        seed.setBlock(underneath, dirtSet, 3);
        for (int i = 1; i < 21; ++i) {
            seed.setBlock(underneath.above(i), airSet, 3);
        }

        ConfiguredFeature<?, ?> tree = TREES.get(random1.nextInt(TREES.size()));

        boolean didTreePlace = tree.place(seed, chunkGen, random1, underneath.above(1));
        System.out.println("Tree Spawned: " + didTreePlace);
    }

    public static final List<ConfiguredFeature<?, ?>> TREES = Arrays.asList(
            //Invigorated Dimensions
            ElectricFeatures.ConfiguredFeatures.ELECTRIC_TREE,
            FairyFeatures.ConfiguredFeatures.FEYAN_TREE,
            FireFeatures.ConfiguredFeatures.FIRE_TREE_STRAIGHT,
            FireFeatures.ConfiguredFeatures.FIRE_TREE_FUNKY,
            GhostFeatures.ConfiguredFeatures.SPOOKY_TREE,
            GrassFeatures.ConfiguredFeatures.GRASSY_TREE,
            GroundFeatures.ConfiguredFeatures.GROUNDED_TREE,
            IceFeatures.ConfiguredFeatures.ICEY_TREE,
            PoisonFeatures.ConfiguredFeatures.CORROSIVE_TREE,
            PsychicFeatures.ConfiguredFeatures.PSYCHIC_TREE,
            SteelFeatures.ConfiguredFeatures.METALLIC_TREE,
            WaterFeatures.ConfiguredFeatures.WATERY_TREE,
            //Minecraft
            Features.OAK,
            Features.BIRCH,
            Features.SPRUCE,
            Features.ACACIA
            );

    public static class AppleItemProjectile extends ProjectileItemEntity {
        public AppleItemProjectile(EntityType<? extends ProjectileItemEntity> entity, World world) {
            super(entity, world);
        }

        public AppleItemProjectile(World world, LivingEntity shooter) {
            super(GrassyKnollEntityTypes.APPLE_PROJECTILE.get(), shooter, world);
        }

        public AppleItemProjectile(World world, double x, double y, double z) {
            super(GrassyKnollEntityTypes.APPLE_PROJECTILE.get(), x, y, z, world);
        }

        @Override
        protected Item getDefaultItem() {
            return Items.APPLE;
        }

        @OnlyIn(Dist.CLIENT)
        private IParticleData getParticle() {
            ItemStack item = this.getDefaultItem().getDefaultInstance();
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
        protected void onHitBlock(BlockRayTraceResult result) {
            super.onHitBlock(result);
            if (!level.isClientSide) {
                Entity shooter = this.getOwner();
                if (shooter instanceof AngryTreantEntity) {
                    if (((AngryTreantEntity) shooter).dropApplesauce()) {
                        this.playSound(((AngryTreantEntity) shooter).getEatingSound(Items.APPLE.getDefaultInstance()), 1.0F, 1.0F);
                        this.spawnAtLocation(GrassyKnollItems.APPLESAUCE.get());
                    }
                }
            }
        }

        @Override
        public IPacket<?> getAddEntityPacket() {
            return NetworkHooks.getEntitySpawningPacket(this);
        }
    }

    public static class DistanceRangedAttackGoal extends RangedAttackGoal {
        private final MobEntity mob;
        private final float maxDistance;
        private final float minDistance;
        public DistanceRangedAttackGoal(IRangedAttackMob mob, double p_i1649_2_, int p_i1649_4_, float maxDistance, float minDistance) {
            super(mob, p_i1649_2_, p_i1649_4_, maxDistance);
            this.mob = (MobEntity) mob;
            this.maxDistance = maxDistance;
            this.minDistance = minDistance;
        }

        @Override
        public boolean canUse() {
            if (!super.canUse()) {
                return false;
            }

            LivingEntity target = this.mob.getTarget();
            if (target == null) {
                return false;
            }

            double distanceSquared = this.mob.distanceToSqr(target);
            return distanceSquared >= (minDistance * minDistance) && distanceSquared <= (maxDistance * maxDistance);
        }

        @Override
        public boolean canContinueToUse() {
            LivingEntity target = this.mob.getTarget();
            if (target == null) {
                return false;
            }

            double distanceSquared = this.mob.distanceToSqr(target);
            return target.isAlive() && (distanceSquared >= (minDistance * minDistance) && distanceSquared <= (maxDistance * maxDistance));
        }
    }
}
