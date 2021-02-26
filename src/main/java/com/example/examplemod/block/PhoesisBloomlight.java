package com.example.examplemod.block;

import com.example.examplemod.setup.ModBlocks;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.BushBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;

public class PhoesisBloomlight extends BushBlock {

    public PhoesisBloomlight() {
        super(AbstractBlock.Properties.create(Material.PLANTS)
                .zeroHardnessAndResistance()
                .doesNotBlockMovement()
                .setLightLevel(value -> 10)
                .sound(SoundType.PLANT));
    }

    @Override
    public float getAmbientOcclusionLightValue(BlockState state, IBlockReader worldIn, BlockPos pos) {
        return 0.5f;
    }

    public AbstractBlock.OffsetType getOffsetType() {
        return AbstractBlock.OffsetType.XYZ;
    }

    @Override
    protected boolean isValidGround(BlockState state, IBlockReader worldIn, BlockPos pos) {
        return state.isIn(ModBlocks.PHOESIS_GRASS.get());
    }
}
