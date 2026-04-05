package com.bladecoldsteel.invigorateddimensions.dreamland.item.custom;

import com.bladecoldsteel.invigorateddimensions.dreamland.effects.DreamlandEffects;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.UseAction;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;

public class PocketWatchItem extends Item {
    private final int itemLockOnPeriod;

    public PocketWatchItem(Properties properties, int itemLockOnPeriod) {
        super(properties.defaultDurability(128));
        this.itemLockOnPeriod = itemLockOnPeriod;
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable World world, List<ITextComponent> tooltip, ITooltipFlag flag) {
        tooltip.add(new StringTextComponent("Relic").withStyle(TextFormatting.GOLD));
        super.appendHoverText(stack, world, tooltip, flag);
    }

    @Override
    public void releaseUsing(ItemStack item, World world, LivingEntity entity, int remainingUseTicks) {
        super.releaseUsing(item, world, entity, remainingUseTicks);
    }

    @Override
    public ActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand) {
        ItemStack item = player.getItemInHand(hand);
        if (item.getDamageValue() >= item.getMaxDamage() - 1) {
            return ActionResult.fail(item);
        }

        player.startUsingItem(hand);
        return ActionResult.consume(item);
    }

    @Override
    public void onUseTick(World world, LivingEntity entity, ItemStack stack, int remainingUseTicks) {
        if (!(entity instanceof PlayerEntity)) return;

        PlayerEntity player = (PlayerEntity) entity;
        int heldTicks = this.getUseDuration(stack) - remainingUseTicks;

        if (heldTicks < itemLockOnPeriod) return;

        if (!world.isClientSide) {
            LivingEntity target = findClosestTarget(world, player);
            if (target != null && target.isAlive()) {
                performMentalPrison(world, target);
                player.getCooldowns().addCooldown(this, 300);
                stack.hurtAndBreak(1, player, broken ->
                        broken.broadcastBreakEvent(player.getUsedItemHand()));
            }
        }
        player.stopUsingItem();
    }

    @Override
    public int getUseDuration(ItemStack p_77626_1_) {
        return 72000;
    }

    @Override
    public UseAction getUseAnimation(ItemStack p_77661_1_) {
        return UseAction.BOW;
    }

    @Override
    public boolean canApplyAtEnchantingTable(ItemStack stack, Enchantment enchantment) {
        return enchantment == Enchantments.UNBREAKING || enchantment == Enchantments.MENDING;
    }

    @Override
    public boolean isEnchantable(ItemStack p_77616_1_) {
        return true;
    }

    private LivingEntity findClosestTarget(World world, PlayerEntity player) {
        double watchRange = 10.0D;
        LivingEntity closestEntity = null;

        if (!world.isClientSide) {
            List<LivingEntity> nearby = world.getEntitiesOfClass(
                    LivingEntity.class,
                    player.getBoundingBox().inflate(watchRange),
                    entity -> entity != player && entity.isAlive()
            );
            Vector3d playerLook = player.getViewVector(1.0F).normalize();
            Vector3d playerEyes = new Vector3d(player.getX(), player.getEyeY(), player.getZ());

            double closestDot = -10.0D;
            for (int i = 0; i < nearby.size(); i++ ) {
                LivingEntity current = nearby.get(i);
                Vector3d entityEyes = new Vector3d(current.getX(), current.getEyeY(), current.getZ());

                Vector3d comparedVector = entityEyes.subtract(playerEyes).normalize();
                if (playerLook.dot(comparedVector) >= 0.75D) {
                    double storedVector = playerLook.dot(comparedVector);
                    if (storedVector > closestDot) {
                        closestDot = storedVector;
                        closestEntity = current;
                    }
                }
            }
        }

        return closestEntity;
    }

    private void performMentalPrison(World world, LivingEntity target) {
        int tickAmount = 20;
        int confusionSeconds = 35 + world.getRandom().nextInt(6);
        if (!world.isClientSide) {
            if (target != null && target.isAlive()) {
                if (target instanceof PlayerEntity) {
                    target.addEffect(new EffectInstance(Effects.CONFUSION, confusionSeconds * tickAmount));
                    target.addEffect(new EffectInstance(DreamlandEffects.MENTAL_PRISON.get(), 30 * tickAmount));
                } else {
                    target.addEffect(new EffectInstance(DreamlandEffects.MENTAL_PRISON.get(), 30 * tickAmount));
                }
            }
        }
    }
}
