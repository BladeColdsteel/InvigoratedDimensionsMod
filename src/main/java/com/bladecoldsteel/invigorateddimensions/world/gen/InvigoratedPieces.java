package com.bladecoldsteel.invigorateddimensions.world.gen;

import com.bladecoldsteel.invigorateddimensions.world.gen.structure.ShrinePiece;
import net.minecraft.world.gen.feature.structure.IStructurePieceType;

public class InvigoratedPieces {
    public static final IStructurePieceType SHRINE_PIECE =
            IStructurePieceType.setPieceId(ShrinePiece::new, "invigorated_dimensions:shrine_piece");

    public static void init() {

    }
}
