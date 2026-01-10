package com.bladecoldsteel.invigorateddimensions.emberwilds.entity.custom.boss;

import com.bladecoldsteel.invigorateddimensions.config.InvigoratedDimensionsConfig;
import com.bladecoldsteel.invigorateddimensions.emberwilds.item.EmberwildsItems;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.*;
import net.minecraft.world.server.ServerBossInfo;

import javax.annotation.Nullable;

public class FireLordEntity extends MonsterEntity{
    private final ServerBossInfo bossEvent;

    public FireLordEntity(EntityType<? extends MonsterEntity> type, World worldIn) {
        super(type, worldIn);
        this.bossEvent = (ServerBossInfo) (new ServerBossInfo(this.getDisplayName(), BossInfo.Color.RED, BossInfo.Overlay.PROGRESS)).setDarkenScreen(true);
        this.setHealth(this.getMaxHealth());
    }

    public static AttributeModifierMap.MutableAttribute setCustomAttributes() {
        if (InvigoratedDimensionsConfig.DIFFICULTY_MODE.get().equalsIgnoreCase("progressive")) {
            return MonsterEntity.createMobAttributes()
                    .add(Attributes.MAX_HEALTH, 325.0D)
                    .add(Attributes.ARMOR, 3.0D)
                    .add(Attributes.ARMOR_TOUGHNESS, 1.0D)
                    .add(Attributes.KNOCKBACK_RESISTANCE, 0.5D)
                    .add(Attributes.MOVEMENT_SPEED, 0.4D)
                    .add(Attributes.FOLLOW_RANGE, 50.0D)
                    .add(Attributes.ATTACK_DAMAGE, 8.0D);
        } else if (InvigoratedDimensionsConfig.DIFFICULTY_MODE.get().equalsIgnoreCase("linear")) {
            return MonsterEntity.createMobAttributes()
                    .add(Attributes.MAX_HEALTH, 275.0D)
                    .add(Attributes.ARMOR, 4.0D)
                    .add(Attributes.ARMOR_TOUGHNESS, 1.5D)
                    .add(Attributes.KNOCKBACK_RESISTANCE, 0.5D)
                    .add(Attributes.MOVEMENT_SPEED, 0.4D)
                    .add(Attributes.FOLLOW_RANGE, 45.0D)
                    .add(Attributes.ATTACK_DAMAGE, 7.0D);
        } else {
            return MonsterEntity.createMobAttributes()
                    .add(Attributes.MAX_HEALTH, 275.0D)
                    .add(Attributes.ARMOR, 4.0D)
                    .add(Attributes.ARMOR_TOUGHNESS, 1.5D)
                    .add(Attributes.KNOCKBACK_RESISTANCE, 0.5D)
                    .add(Attributes.MOVEMENT_SPEED, 0.4D)
                    .add(Attributes.FOLLOW_RANGE, 45.0D)
                    .add(Attributes.ATTACK_DAMAGE, 7.0D);
        }
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(0, new SwimGoal(this));
        this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 1.0, true));
        this.goalSelector.addGoal(2, new LookAtGoal(this, PlayerEntity.class, 8.0F));

        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, PlayerEntity.class, false, false));
        this.targetSelector.addGoal(2, new HurtByTargetGoal(this));
    }

    @Override
    public boolean canChangeDimensions() {
        return false;
    }

    @Override
    protected int getExperienceReward(PlayerEntity player) {
        return this.random.nextInt(40) + 5;
    }

    @Override
    protected SoundEvent getAmbientSound() {
        this.playSound(SoundEvents.LAVA_AMBIENT, 0.2F, 1.0F);
        return null;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource damageSource) {
        this.playSound(SoundEvents.BLAZE_HURT, 1.0F, 1.7F);
        return null;
    }

    @Override
    protected SoundEvent getDeathSound() {
        this.playSound(SoundEvents.LAVA_EXTINGUISH, 0.7F, 2.0F);
        return null;
    }

    @Override
    protected void playStepSound(BlockPos pos, BlockState blockState) {
        this.playSound(SoundEvents.BUCKET_FILL_LAVA, 0.2F, 1.0F);
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
        BlockPos underneath = this.blockPosition().below();
        if (!this.level.isClientSide()) {
            if (this.getNavigation().isInProgress()) {
                if (this.tickCount % 40 != 0) {
                    if (!this.level.isEmptyBlock(underneath)) {
                        this.level.setBlock(underneath, Blocks.NETHERRACK.defaultBlockState(), 3);
                        if (this.level.isEmptyBlock(this.blockPosition())) {
                            this.level.setBlock(this.blockPosition(), Blocks.FIRE.defaultBlockState(), 3);
                        }
                    }
                }
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

    @Nullable
    @Override
    public ILivingEntityData finalizeSpawn(IServerWorld p_213386_1_, DifficultyInstance p_213386_2_, SpawnReason p_213386_3_, @Nullable ILivingEntityData p_213386_4_, @Nullable CompoundNBT p_213386_5_) {
        ILivingEntityData result = super.finalizeSpawn(p_213386_1_, p_213386_2_, p_213386_3_, p_213386_4_, p_213386_5_);
        this.setItemSlot(EquipmentSlotType.HEAD, new ItemStack(EmberwildsItems.FIRE_LORD_CROWN.get()));
        this.setDropChance(EquipmentSlotType.HEAD, 1.0F);
        this.setCanPickUpLoot(false);
        return result;
    }

    @Override
    public boolean isSensitiveToWater() {
        return true;
    }
}
