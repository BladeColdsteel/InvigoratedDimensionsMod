package com.bladecoldsteel.invigorateddimensions.electrichighlands.item.custom;

import com.bladecoldsteel.invigorateddimensions.electrichighlands.entity.custom.projectiles.LightningItemProjectileEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.Stats;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.world.World;

public class LightningBoltItem extends Item {
    public LightningBoltItem(Properties properties) {
        super(properties);
    }

    @Override
    public void releaseUsing(ItemStack p_77615_1_, World p_77615_2_, LivingEntity p_77615_3_, int p_77615_4_) {
        super.releaseUsing(p_77615_1_, p_77615_2_, p_77615_3_, p_77615_4_);
    }

    @Override
    public ActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand) {
        ItemStack item = player.getItemInHand(hand);
        player.getCooldowns().addCooldown(this, 20);
        world.playSound(null, player.getX(), player.getY(), player.getZ(), SoundEvents.TRIDENT_THROW, SoundCategory.PLAYERS, 0.5F, 0.4F / (random.nextFloat() * 0.4F + 0.8F));
        if (!world.isClientSide) {
            LightningItemProjectileEntity lightningBolt = new LightningItemProjectileEntity(world, player);
            lightningBolt.setItem(item);
            lightningBolt.shootFromRotation(player, player.xRot, player.yRot, 0.0F, 1.5F, 1.0F);
            world.addFreshEntity(lightningBolt);
        }

        player.awardStat(Stats.ITEM_USED.get(this));
        if (!player.abilities.instabuild) {
            item.shrink(1);
        }

        return ActionResult.success(item);
    }
}
