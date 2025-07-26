package com.bladecoldsteel.invigorateddimensions.universal.datageneration.provider;

import com.bladecoldsteel.invigorateddimensions.InvigoratedDimensions;
import net.minecraft.block.*;
import net.minecraft.data.DataGenerator;
import net.minecraft.state.properties.AttachFace;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.Direction;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;

import java.util.function.Supplier;

public abstract class IDBlockstateProvider extends BlockStateProvider {
    public IDBlockstateProvider(DataGenerator generator, ExistingFileHelper fileHelper) {
        super(generator, InvigoratedDimensions.MOD_ID, fileHelper);
    }

    public void block(Supplier<? extends Block> block) {
        simpleBlock(block.get());
    }

    public void log(Supplier<? extends RotatedPillarBlock> block, String name) {
        axisBlock(block.get(), texture(name));
    }

    public void uniformLog(Supplier<? extends RotatedPillarBlock> block, String textureName) {
        axisBlock(block.get(), texture(textureName), texture(textureName));
    }

    public void torchBlock(Supplier<? extends Block> block, Supplier<? extends Block> wall) {
        ModelFile torch = models().torch(name(block), texture(name(block)));
        ModelFile torchWall = models().torchWall(name(wall), texture(name(block)));
        simpleBlock(block.get(), torch);
        getVariantBuilder(wall.get()).forAllStates(state ->
                ConfiguredModel.builder()
                        .modelFile(torchWall)
                        .rotationY(((int) state.getValue(BlockStateProperties.HORIZONTAL_FACING).toYRot() + 90) % 360)
                        .build());
    }

    public void crossBlock(Supplier<? extends Block> block) {
        crossBlock(block, models().cross(name(block), texture(name(block))));
    }

    public void stairs(Supplier<? extends StairsBlock> block, Supplier<? extends Block> fullBlock) {
        stairsBlock(block.get(), texture(name(fullBlock)));
    }

    public void slab(Supplier<? extends SlabBlock> block, Supplier<? extends Block> fullBlock) {
        slabBlock(block.get(), texture(name(fullBlock)), texture(name(fullBlock)));
    }

    public void fence(Supplier<? extends FenceBlock> block, Supplier<? extends Block> fullBlock) {
        fenceBlock(block.get(), texture(name(fullBlock)));
        fenceColumn(block, name(fullBlock));
    }

    public void door(Supplier<? extends DoorBlock> block, String name) {
        doorBlock(block.get(), texture(name + "_door_bottom"), texture(name + "_door_top"));
    }

    public void trapDoor(Supplier<? extends TrapDoorBlock> block, String name) {
        trapdoorBlock(block.get(), texture(name + "_trapdoor"), true);
    }

    public void carpet(Supplier<? extends CarpetBlock> block) {
        simpleBlock(block.get(), models().carpet(name(block), texture(name(block))));
    }

    public void button(Supplier<? extends AbstractButtonBlock> block, Supplier<? extends Block> baseBlock) {
        buttonBlock(block, texture(name(baseBlock)));
    }

    public void pressurePlate(Supplier<? extends PressurePlateBlock> block, Supplier<? extends Block> baseBlock) {
        pressurePlateBlock(block, texture(name(baseBlock)));
    }

    public void minecraftButton(Supplier<? extends AbstractButtonBlock> block, Block baseBlock) {
        buttonBlock(block, new ResourceLocation(baseBlock.getDescriptionId()));
    }

    public void minecraftPressurePlate(Supplier<? extends PressurePlateBlock> block, Block baseBlock) {
        pressurePlateBlock(block, new ResourceLocation(baseBlock.getDescriptionId()));
    }

    protected ResourceLocation texture(String name) {
        return modLoc("block/" + name);
    }

    protected String name(Supplier<? extends Block> block) {
        return block.get().getRegistryName().getPath();
    }

    private void crossBlock(Supplier<? extends Block> block, ModelFile model) {
        getVariantBuilder(block.get()).forAllStates(state ->
                ConfiguredModel.builder()
                        .modelFile(model)
                        .build());
    }

    private void fenceColumn(Supplier<? extends FenceBlock> block, String side) {
        String baseName = block.get().getRegistryName().toString();
        fourWayBlock(block.get(),
                models().fencePost(baseName + "_post", texture(side)),
                models().fenceSide(baseName + "_side", texture(side)));
    }

    private void buttonBlock(Supplier<? extends AbstractButtonBlock> block, ResourceLocation texture) {
        ModelFile unpressed = models().withExistingParent(name(block), mcLoc("button"))
                .texture("texture", texture);
        ModelFile pressed = models().withExistingParent(name(block) + "_pressed", mcLoc("button_pressed"))
                .texture("texture", texture);
        ModelFile inventory = models().withExistingParent(name(block) + "_inventory", mcLoc("button_inventory"))
                .texture("texture", texture);

        getVariantBuilder(block.get()).forAllStates(state -> {
            Direction facing = state.getValue(BlockStateProperties.HORIZONTAL_FACING);
            AttachFace face = state.getValue(BlockStateProperties.ATTACH_FACE);
            boolean powered = state.getValue(BlockStateProperties.POWERED);

            ModelFile model = powered ? pressed : unpressed;

            int xRot = 0;
            switch (face) {
                case FLOOR: xRot = 0; break;
                case CEILING: xRot = 180; break;
                case WALL: xRot = 90; break;
            }

            int yRot = facing.get2DDataValue() * 90;
            if (face == AttachFace.CEILING) {
                yRot = (yRot + 180) % 360;
            }

            return ConfiguredModel.builder()
                    .modelFile(model)
                    .rotationX(xRot)
                    .rotationY(yRot)
                    .build();
        });

        itemModels().withExistingParent(name(block), inventory.getLocation());
    }

    private void pressurePlateBlock(Supplier<? extends PressurePlateBlock> block, ResourceLocation texture) {
        ModelFile up = models().withExistingParent(name(block), mcLoc("pressure_plate_up"))
                .texture("texture", texture);
        ModelFile down = models().withExistingParent(name(block) + "_down", mcLoc("pressure_plate_down"))
                .texture("texture", texture);

        getVariantBuilder(block.get()).forAllStates(state ->
                ConfiguredModel.builder()
                        .modelFile(state.getValue(BlockStateProperties.POWERED) ? down : up)
                        .build());

        itemModels().withExistingParent(name(block), up.getLocation());
    }
}
