package com.bladecoldsteel.invigorateddimensions.world.gen.structure;

import com.bladecoldsteel.invigorateddimensions.InvigoratedDimensions;
import com.mojang.serialization.Codec;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.util.registry.DynamicRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.feature.jigsaw.JigsawManager;
import net.minecraft.world.gen.feature.structure.AbstractVillagePiece;
import net.minecraft.world.gen.feature.structure.Structure;
import net.minecraft.world.gen.feature.structure.StructureStart;
import net.minecraft.world.gen.feature.structure.VillageConfig;
import net.minecraft.world.gen.feature.template.TemplateManager;

public class FairyPortalStructure extends AbstractSurfaceStructure {

    public FairyPortalStructure(Codec<NoFeatureConfig> codec) {
        super(codec);
    }

    @Override
    public IStartFactory<NoFeatureConfig> getStartFactory() {
        return FairyPortalStructure.Start::new;
    }

    public static class Start extends StructureStart<NoFeatureConfig> {
        public Start(Structure<NoFeatureConfig> structureIn, int chunkX, int chunkZ, MutableBoundingBox mutableBoundingBox, int referenceIn, long seedIn) {
            super(structureIn, chunkX, chunkZ, mutableBoundingBox, referenceIn, seedIn);

        }

        @Override
        public void generatePieces(DynamicRegistries dynamicRegistries, ChunkGenerator chunkGenerator, TemplateManager templateManager, int chunkX, int chunkZ, Biome biome, NoFeatureConfig featureConfig) {
            int x = (chunkX << 4) + 7;
            int z = (chunkZ << 4) + 7;

            int terrainHeight = chunkGenerator.getBaseHeight(x, z, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES);
            BlockPos blockPos = new BlockPos(x, terrainHeight, z);

            JigsawManager.addPieces(
                    dynamicRegistries,
                    new VillageConfig(() -> dynamicRegistries.registryOrThrow(Registry.TEMPLATE_POOL_REGISTRY).get(new ResourceLocation(InvigoratedDimensions.MOD_ID, "fairy_portal/start_pool")), 10),
                    AbstractVillagePiece::new,
                    chunkGenerator,
                    templateManager,
                    blockPos,
                    this.pieces,
                    this.random,
                    false,
                    true);

            int minPieceY = this.pieces.stream()
                    .mapToInt(p -> p.getBoundingBox().y0)
                    .min()
                    .orElse(terrainHeight);

            final int GROUND_OFFSET = 1;

            int dy = (terrainHeight + GROUND_OFFSET) - minPieceY;
            if (dy != 0) this.pieces.forEach(p -> p.move(0, dy, 0));

            this.calculateBoundingBox();

        }


    }
}
