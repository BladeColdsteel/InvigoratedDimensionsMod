package com.bladecoldsteel.invigorateddimensions.world.gen.structure;

import com.bladecoldsteel.invigorateddimensions.InvigoratedDimensions;
import com.mojang.serialization.Codec;
import net.minecraft.block.BlockState;
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

public class FlyingPortalStructure extends AbstractSurfaceStructure {

    public FlyingPortalStructure(Codec<NoFeatureConfig> codec) {
        super(codec);
    }

    @Override
    public IStartFactory<NoFeatureConfig> getStartFactory() {
        return FlyingPortalStructure.Start::new;
    }

    public static class Start extends StructureStart<NoFeatureConfig> {
        public Start(Structure<NoFeatureConfig> structureIn, int chunkX, int chunkZ, MutableBoundingBox mutableBoundingBox, int referenceIn, long seedIn) {
            super(structureIn, chunkX, chunkZ, mutableBoundingBox, referenceIn, seedIn);

        }

        @Override
        public void generatePieces(DynamicRegistries dynamicRegistries, ChunkGenerator chunkGenerator, TemplateManager templateManager, int chunkX, int chunkZ, Biome biome, NoFeatureConfig featureConfig) {
            int cx = (chunkX << 4) + 7;
            int cz = (chunkZ << 4) + 7;

            java.util.function.BiFunction<Integer, Integer, Integer> getSurfaceY =
                    (x,z_) -> chunkGenerator.getBaseHeight(x, z_, Heightmap.Type.WORLD_SURFACE_WG);

            int x1 = cx,     z1 = cz;
            int x2 = cx + 5, z2 = cz;
            int x3 = cx,     z3 = cz + 5;
            int x4 = cx + 5, z4 = cz + 5;

            int y1 = getSurfaceY.apply(x1,z1);
            int y2 = getSurfaceY.apply(x2,z2);
            int y3 = getSurfaceY.apply(x3,z3);
            int y4 = getSurfaceY.apply(x4,z4);
            int y  = Math.min(Math.min(y1, y2), Math.min(y3, y4));

            if (y < 60) return;

            BlockPos anchor = new BlockPos(cx, y, cz);

            JigsawManager.addPieces(
                    dynamicRegistries,
                    new VillageConfig(() -> dynamicRegistries.registryOrThrow(Registry.TEMPLATE_POOL_REGISTRY).get(new ResourceLocation(InvigoratedDimensions.MOD_ID, "flying_portal/start_pool")), 10),
                    AbstractVillagePiece::new,
                    chunkGenerator,
                    templateManager,
                    anchor,
                    this.pieces,
                    this.random,
                    false,
                    true);

            if (this.pieces.isEmpty()) return;

            int minPieceY = this.pieces.stream().mapToInt(p -> p.getBoundingBox().y0).min().orElse(y);
            int dy = y - minPieceY;
            if (dy != 0) this.pieces.forEach(p -> p.move(0, dy, 0));

            this.calculateBoundingBox();

        }
    }
}
