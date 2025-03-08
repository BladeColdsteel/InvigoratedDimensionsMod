package com.bladecoldsteel.invigorateddimensions.universal.block.custom;

import com.bladecoldsteel.invigorateddimensions.draconicrift.block.DraconicRiftBlocks;
import com.bladecoldsteel.invigorateddimensions.electrichighlands.block.ElectricHighlandsBlocks;
import com.bladecoldsteel.invigorateddimensions.emberwilds.block.EmberwildsBlocks;
import com.bladecoldsteel.invigorateddimensions.grassyknoll.block.GrassyKnollBlocks;
import com.bladecoldsteel.invigorateddimensions.insectoidparadisio.block.InsectoidParadisioBlocks;
import com.bladecoldsteel.invigorateddimensions.waterydepths.block.WateryDepthsBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.block.LeavesBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.loot.LootContext;
import net.minecraft.loot.LootParameters;
import net.minecraft.util.Direction;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.server.ServerWorld;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CrystallizedLeavesBlock extends LeavesBlock {
    public CrystallizedLeavesBlock() {
        super(Properties.of(Material.LEAVES)
                .strength(0.2f)
                .randomTicks()
                .sound(SoundType.GLASS)
                .noOcclusion());
    }

    @Override
    public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
        List<ItemStack> drops = new ArrayList<>();
        ServerWorld world = builder.getLevel();
        BlockPos pos = new BlockPos(builder.getParameter(LootParameters.ORIGIN));
        Biome biome = world.getBiome(pos);
        ResourceLocation biomeKey = world.registryAccess()
                .registryOrThrow(Registry.BIOME_REGISTRY)
                .getKey(biome);

        int fortuneLevel = 0;
        ItemStack tool = builder.getParameter(LootParameters.TOOL);
        boolean hasSilk = false;
        if (tool != null) {
            fortuneLevel = EnchantmentHelper.getItemEnchantmentLevel(Enchantments.BLOCK_FORTUNE, tool);
            hasSilk = EnchantmentHelper.getItemEnchantmentLevel(Enchantments.SILK_TOUCH, tool) > 0;
        }

        if (hasSilk) {
            drops.add(new ItemStack(this));
            return drops;
        }

        if (biomeKey != null) {
            ItemStack sapling = saplingPerBiome(biomeKey);

            if (shouldDropSapling(world.random, fortuneLevel)) {
                drops.add(sapling);
            }
        }

        if (world.random.nextFloat() < 0.05f) {
            drops.add(new ItemStack(Items.STICK));
        }

        return drops;
    }

    @Override
    public boolean isFlammable(BlockState state, IBlockReader world, BlockPos pos, Direction face) {
        return true;
    }

    @Override
    public int getFlammability(BlockState state, IBlockReader world, BlockPos pos, Direction face) {
        return 60;
    }

    @Override
    public int getFireSpreadSpeed(BlockState state, IBlockReader world, BlockPos pos, Direction face) {
        return 30;
    }

    private boolean shouldDropSapling(Random random, int fortuneLevel) {
        float baseChance = 0.05f;
        if (fortuneLevel > 0) {
            baseChance += fortuneLevel * 0.025f;
        }
        return random.nextFloat() < baseChance;
    }

    private boolean isElectricBiome(ResourceLocation biomeKey) {
        return biomeKey.equals(new ResourceLocation("invigorated_dimensions", "electric_rift")) ||
               biomeKey.equals(new ResourceLocation("invigorated_dimensions", "electric_highlands")) ||
               biomeKey.equals(new ResourceLocation("invigorated_dimensions", "electric_highlands_forest"));
    }
    private boolean isWaterBiome(ResourceLocation biomeKey) {
        return biomeKey.equals(new ResourceLocation("invigorated_dimensions", "watery_rift"));
    }
    private boolean isFireBiome(ResourceLocation biomeKey) {
        return biomeKey.equals(new ResourceLocation("invigorated_dimensions", "firey_rift"));
    }
    private boolean isGrassBiome(ResourceLocation biomeKey) {
        return biomeKey.equals(new ResourceLocation("invigorated_dimensions", "grassy_rift"));
    }
    private boolean isIceBiome(ResourceLocation biomeKey) {
        return biomeKey.equals(new ResourceLocation("invigorated_dimensions", "icey_rift"));
    }
    private boolean isFightingBiome(ResourceLocation biomeKey) {
        return biomeKey.equals(new ResourceLocation("invigorated_dimensions", "fighting_rift"));
    }
    private boolean isPoisonBiome(ResourceLocation biomeKey) {
        return biomeKey.equals(new ResourceLocation("invigorated_dimensions", "poison_rift"));
    }
    private boolean isGroundBiome(ResourceLocation biomeKey) {
        return biomeKey.equals(new ResourceLocation("invigorated_dimensions", "grounded_rift"));
    }
    private boolean isFlyingBiome(ResourceLocation biomeKey) {
        return biomeKey.equals(new ResourceLocation("invigorated_dimensions", "flying_rift"));
    }
    private boolean isPsychicBiome(ResourceLocation biomeKey) {
        return biomeKey.equals(new ResourceLocation("invigorated_dimensions", "psychic_rift"));
    }
    private boolean isBugBiome(ResourceLocation biomeKey) {
        return biomeKey.equals(new ResourceLocation("invigorated_dimensions", "buggy_rift"));
    }
    private boolean isRockBiome(ResourceLocation biomeKey) {
        return biomeKey.equals(new ResourceLocation("invigorated_dimensions", "rocky_rift"));
    }
    private boolean isGhostBiome(ResourceLocation biomeKey) {
        return biomeKey.equals(new ResourceLocation("invigorated_dimensions", "spooky_rift"));
    }
    private boolean isDragonBiome(ResourceLocation biomeKey) {
        return biomeKey.equals(new ResourceLocation("invigorated_dimensions", "dragon_rift"));
    }
    private boolean isDarkBiome(ResourceLocation biomeKey) {
        return biomeKey.equals(new ResourceLocation("invigorated_dimensions", "darkened_rift"));
    }
    private boolean isSteelBiome(ResourceLocation biomeKey) {
        return biomeKey.equals(new ResourceLocation("invigorated_dimensions", "steely_rift"));
    }
    private boolean isFairyBiome(ResourceLocation biomeKey) {
        return biomeKey.equals(new ResourceLocation("invigorated_dimensions", "fairy_rift"));
    }

    private ItemStack saplingPerBiome(ResourceLocation biomeKey) {
        if (isElectricBiome(biomeKey)) {
            return new ItemStack(ElectricHighlandsBlocks.ELECTRICALLY_CHARGED_SAPLING.get());
        } else if (isWaterBiome(biomeKey)) {
            return new ItemStack(WateryDepthsBlocks.WATERY_SAPLING.get());
        } else if (isFireBiome(biomeKey)) {
            return new ItemStack(EmberwildsBlocks.EMBERED_SAPLING.get());
        } else if (isGrassBiome(biomeKey)) {
            return new ItemStack(GrassyKnollBlocks.GRASSY_SAPLING.get());
        } else if (isIceBiome(biomeKey)) {
            return new ItemStack(ElectricHighlandsBlocks.ELECTRICALLY_CHARGED_SAPLING.get());
        } else if (isFightingBiome(biomeKey)) {
            return new ItemStack(ElectricHighlandsBlocks.ELECTRICALLY_CHARGED_SAPLING.get());
        } else if (isPoisonBiome(biomeKey)) {
            return new ItemStack(ElectricHighlandsBlocks.ELECTRICALLY_CHARGED_SAPLING.get());
        } else if (isGroundBiome(biomeKey)) {
            return new ItemStack(ElectricHighlandsBlocks.ELECTRICALLY_CHARGED_SAPLING.get());
        } else if (isFlyingBiome(biomeKey)) {
            return new ItemStack(ElectricHighlandsBlocks.ELECTRICALLY_CHARGED_SAPLING.get());
        } else if (isPsychicBiome(biomeKey)) {
            return new ItemStack(ElectricHighlandsBlocks.ELECTRICALLY_CHARGED_SAPLING.get());
        } else if (isBugBiome(biomeKey)) {
            return new ItemStack(InsectoidParadisioBlocks.BUGGED_SAPLING.get());
        } else if (isRockBiome(biomeKey)) {
            return new ItemStack(ElectricHighlandsBlocks.ELECTRICALLY_CHARGED_SAPLING.get());
        } else if (isGhostBiome(biomeKey)) {
            return new ItemStack(ElectricHighlandsBlocks.ELECTRICALLY_CHARGED_SAPLING.get());
        } else if (isDragonBiome(biomeKey)) {
            return new ItemStack(DraconicRiftBlocks.DRACONIC_SAPLING.get());
        } else if (isDarkBiome(biomeKey)) {
            return new ItemStack(ElectricHighlandsBlocks.ELECTRICALLY_CHARGED_SAPLING.get());
        } else if (isSteelBiome(biomeKey)) {
            return new ItemStack(ElectricHighlandsBlocks.ELECTRICALLY_CHARGED_SAPLING.get());
        } else if (isFairyBiome(biomeKey)) {
            return new ItemStack(ElectricHighlandsBlocks.ELECTRICALLY_CHARGED_SAPLING.get());
        } else {
            return randomSapling();
        }
    }

    private ItemStack randomSapling() {
        ItemStack[] saplings = {
                new ItemStack(ElectricHighlandsBlocks.ELECTRICALLY_CHARGED_SAPLING.get()),
                new ItemStack(WateryDepthsBlocks.WATERY_SAPLING.get()),
                new ItemStack(EmberwildsBlocks.EMBERED_SAPLING.get()),
                new ItemStack(DraconicRiftBlocks.DRACONIC_SAPLING.get()),
                new ItemStack(GrassyKnollBlocks.GRASSY_SAPLING.get()),
                new ItemStack(InsectoidParadisioBlocks.BUGGED_SAPLING.get())
        };

        return saplings[new Random().nextInt(saplings.length)];
    }
}
