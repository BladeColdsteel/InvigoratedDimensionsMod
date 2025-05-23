package com.bladecoldsteel.invigorateddimensions.electrichighlands.entity.custom;

import com.bladecoldsteel.invigorateddimensions.electrichighlands.item.ElectricHighlandsItems;
import net.minecraft.block.BlockState;
import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Items;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.registries.ForgeRegistries;

public class ChargedCrawlerEntity extends CreatureEntity {
    public ChargedCrawlerEntity(EntityType<? extends CreatureEntity> type, World worldIn) {
        super(type, worldIn);
    }

    public static AttributeModifierMap.MutableAttribute setCustomAttributes() {
        return MobEntity.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 10.0D)
                .add(Attributes.ARMOR, 1.0D)
                .add(Attributes.MOVEMENT_SPEED, 0.5D);
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(0, new SwimGoal(this));
        this.goalSelector.addGoal(1, new MoveTowardsTargetGoal(this, 1.0D, 4.0F));
        this.goalSelector.addGoal(2, new WaterAvoidingRandomWalkingGoal(this, 1.0D));
        this.goalSelector.addGoal(3, new LookAtGoal(this, PlayerEntity.class, 8.0F));
        this.goalSelector.addGoal(4, new LookRandomlyGoal(this));

        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, PlayerEntity.class, true, false));
    }

    @Override
    protected void dropCustomDeathLoot(DamageSource source, int looting, boolean recentlyHitIn) {
        super.dropCustomDeathLoot(source, looting, recentlyHitIn);

        int amount = 1 + this.random.nextInt(2) + this.random.nextInt(looting + 1);
        for (int i = 0; i < amount; i++) {
            this.spawnAtLocation(Items.BEEF);
        }

        if (this.random.nextFloat() < 0.5F + (0.05F * looting)) {
            this.spawnAtLocation(ElectricHighlandsItems.VOLTCRYST.get());
        }

        if (this.random.nextFloat() < 0.25F + (0.05F * looting)) {
            this.spawnAtLocation(ElectricHighlandsItems.VOLTCRYST.get());
        }

        if (this.random.nextFloat() < 0.001F + (0.002F * looting)) {
            this.spawnAtLocation(ElectricHighlandsItems.ELECTRIC_HIGHLANDS_ACTIVATOR.get());
        }

        //if (ModList.get().isLoaded("")) {
            //this.spawnAtLocation(ForgeRegistries.ITEMS.getValue(new ResourceLocation("", "")));
        //} else {
            //this.spawnAtLocation();
        //}
    }

    @Override
    protected int getExperienceReward(PlayerEntity player) {
        return this.random.nextInt(4) + 3;
    }

    @Override
    protected SoundEvent getAmbientSound() {
        this.playSound(SoundEvents.SPIDER_AMBIENT, 0.2F, 1.0F);
        return null;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource damageSource) {
        this.playSound(SoundEvents.SPIDER_HURT, 1.0F, 1.7F);
        return null;
    }

    @Override
    protected SoundEvent getDeathSound() {
        this.playSound(SoundEvents.SPIDER_DEATH, 0.7F, 2.0F);
        return null;
    }

    @Override
    protected void playStepSound(BlockPos pos, BlockState blockState) {
        this.playSound(SoundEvents.SPIDER_STEP, 0.2F, 1.0F);
    }
}
