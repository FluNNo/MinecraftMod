package com.example.examplemod.block;

import com.example.examplemod.setup.ModBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.block.BushBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;

public class PhoesisGrass extends BushBlock {

    public PhoesisGrass() {
        super(Properties.create(Material.PLANTS)
                .zeroHardnessAndResistance()
                .doesNotBlockMovement()
                .sound(SoundType.PLANT));
    }

    @Override
    public float getAmbientOcclusionLightValue(BlockState state, IBlockReader worldIn, BlockPos pos) {
        return 0.5f;
    }

    public OffsetType getOffsetType() {
        return OffsetType.XYZ;
    }

    @Override
    protected boolean isValidGround(BlockState state, IBlockReader worldIn, BlockPos pos) {
        return state.isIn(ModBlocks.PHOESIS_GRASS_BLOCK.get());
    }
}
