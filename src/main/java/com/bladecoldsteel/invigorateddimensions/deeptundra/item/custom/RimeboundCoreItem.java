package com.bladecoldsteel.invigorateddimensions.deeptundra.item.custom;

import com.bladecoldsteel.invigorateddimensions.deeptundra.entity.boss.custom.RimeboundEntity;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.SnowBlock;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.item.UseAction;
import net.minecraft.particles.IParticleData;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.stats.Stats;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

import javax.annotation.Nullable;
import java.util.List;

public class RimeboundCoreItem extends Item {
    private final IParticleData breathParticle;
    private final double breathRange;
    private final double coneAngle;
    private final int particleDensity;
    private final double particleSpeed;
    private final float damage;
    private final int hitInterval;

    public RimeboundCoreItem(Properties properties) {
        super(properties);
        this.breathParticle = ParticleTypes.END_ROD;
        this.breathRange = 10.0D;
        this.coneAngle = 30.0D;
        this.particleDensity = 30;
        this.particleSpeed = 0.05D;
        this.damage = 3.0F;
        this.hitInterval = 5;
    }

    @Override
    public ActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand) {
        ItemStack item = player.getItemInHand(hand);
        player.startUsingItem(hand);
        player.awardStat(Stats.ITEM_USED.get(this));

        return ActionResult.consume(item);
    }

    @Override
    public ActionResultType useOn(ItemUseContext context) {
        World world = context.getLevel();
        BlockPos blockpos = context.getClickedPos();
        BlockState blockstate = world.getBlockState(blockpos);
        int itemDamage = 0;
        if (!blockstate.is(Blocks.SNOW)) {
            return ActionResultType.PASS;
        }
        int snowLayer = blockstate.getValue(SnowBlock.LAYERS);
        BlockPos targetPos;
        BlockState targetState;
        if (snowLayer < 8) {
            targetPos = blockpos;
            targetState = blockstate.setValue(SnowBlock.LAYERS, snowLayer + 1);
            itemDamage = 1;
        } else {
            BlockPos abovePos = blockpos.above();
            BlockState aboveState = world.getBlockState(abovePos);
            if (!aboveState.is(Blocks.AIR)) {
                return ActionResultType.PASS;
            }
            targetPos = abovePos;
            targetState = Blocks.SNOW.defaultBlockState();
            itemDamage = 2;
        }
        if (!world.isClientSide) {
            world.setBlock(targetPos, targetState, 11);
            world.playSound(null, targetPos, SoundEvents.SNOW_PLACE, SoundCategory.BLOCKS, 1.0F, 1.0F);
            PlayerEntity player = context.getPlayer();
            if (player != null) {
                context.getItemInHand().hurtAndBreak(itemDamage, player, brokenPlayer -> {
                    brokenPlayer.broadcastBreakEvent(context.getHand());
                });
            } else {
                context.getItemInHand().hurt(itemDamage, world.random, null);
            }
        }
        return ActionResultType.sidedSuccess(world.isClientSide);
    }

    @Override
    public void onUseTick(World world, LivingEntity entity, ItemStack stack, int remainingUseDuration) {
        if (!(entity instanceof PlayerEntity)) return;
        PlayerEntity player = (PlayerEntity) entity;
        int breathTime = this.getUseDuration(stack) - remainingUseDuration;
        if (!world.isClientSide) {
            if (this.hitInterval > 0 && breathTime % this.hitInterval == 0) {
                world.playSound(null, player.getX(), player.getY(), player.getZ(), SoundEvents.SNOW_FALL, SoundCategory.PLAYERS, 0.5F, 0.4F / (random.nextFloat() * 0.4F + 0.8F));
                damageEntitiesInCone(world, player);
                spawnBreathParticles(world, player, breathTime);
                stack.hurtAndBreak(1, player, brokenPlayer -> {
                    brokenPlayer.broadcastBreakEvent(player.getUsedItemHand());
                });
            }
        }
    }

    @Override
    public int getUseDuration(ItemStack p_77626_1_) {
        return 72000;
    }

    @Override
    public UseAction getUseAnimation(ItemStack p_77661_1_) {
        return UseAction.BLOCK;
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable World world, List<ITextComponent> tooltip, ITooltipFlag flag) {
        tooltip.add(new StringTextComponent("Relic").withStyle(TextFormatting.GOLD));
        super.appendHoverText(stack, world, tooltip, flag);
    }

    private void damageEntitiesInCone(World world, PlayerEntity player) {
        Vector3d mouthPos = new Vector3d(player.getX(), player.getEyeY(), player.getZ());
        Vector3d look = player.getLookAngle().normalize();

        double coneDotThreshold = Math.cos(Math.toRadians(this.coneAngle / 2.0D));

        for (LivingEntity entity : world.getEntitiesOfClass(LivingEntity.class, player.getBoundingBox().inflate(this.breathRange))) {
            if (entity == player || !entity.isAlive()) continue;

            Vector3d fromMouthToEntity = entity.position().add(0, entity.getBbHeight() * 0.5D, 0).subtract(mouthPos);
            double distance = fromMouthToEntity.length();

            if (distance > this.breathRange || distance <= 0.0D) continue;

            Vector3d directionToEntity = fromMouthToEntity.normalize();
            double dot = look.dot(directionToEntity);

            if (dot >= coneDotThreshold) {
                if (entity instanceof RimeboundEntity) {
                    entity.heal(this.damage / 2.0F);
                } else {
                    entity.hurt(DamageSource.mobAttack(player), this.damage);
                    int amplifier = 0;
                    EffectInstance currentSlowness = entity.getEffect(Effects.MOVEMENT_SLOWDOWN);
                    if (currentSlowness != null) {
                        amplifier = currentSlowness.getAmplifier() + 1;
                    }
                    entity.addEffect(new EffectInstance(
                            Effects.MOVEMENT_SLOWDOWN,
                            30,
                            amplifier,
                            false,
                            true,
                            true
                    ));
                }
            }
        }
    }

    private void spawnBreathParticles(World world, PlayerEntity player, int breathTime) {
        Vector3d mouthPos = new Vector3d(player.getX(), player.getEyeY(), player.getZ());
        Vector3d look = player.getLookAngle().normalize();

        Vector3d right = new Vector3d(-look.z, 0, look.x).normalize();
        Vector3d up = right.cross(look).normalize();

        double progress = Math.min(1.0D, breathTime / 20.0D);
        double maxDistanceThisTick = this.breathRange * progress;

        for (int i = 0; i < particleDensity; i++) {
            double distance = player.getRandom().nextDouble() * maxDistanceThisTick;
            double radius = distance * Math.tan(Math.toRadians(this.coneAngle / 2.0D));

            double angle = player.getRandom().nextDouble() * Math.PI * 2.0D;
            double spread = player.getRandom().nextDouble() * radius;

            Vector3d offset = look.scale(distance)
                    .add(right.scale(Math.cos(angle) * spread))
                    .add(up.scale(Math.sin(angle) * spread));

            Vector3d particlePos = mouthPos.add(offset);
            if (!world.isClientSide && world instanceof ServerWorld) {
                ((ServerWorld) world).sendParticles(
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
}
