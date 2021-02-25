package com.example.examplemod.block;

import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.Features;
import net.minecraft.world.gen.feature.NetherVegetationFeature;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.ToolType;

import java.util.Random;

public class PhoesisGrassBlock extends Block implements IGrowable {

    public PhoesisGrassBlock() {
        super(AbstractBlock.Properties.create(Material.IRON)
                .hardnessAndResistance(3.5f, 4.0f)
                .sound(SoundType.ANVIL)
                .harvestLevel(0)
                .harvestTool(ToolType.PICKAXE)
                .setRequiresTool());
    }

    @Override
    public boolean canGrow(IBlockReader worldIn, BlockPos pos, BlockState state, boolean isClient) {
        return worldIn.getBlockState(pos.up()).isAir();
    }

    @Override
    public boolean canUseBonemeal(World worldIn, Random rand, BlockPos pos, BlockState state) {
        return true;
    }

    @Override
    public void grow(ServerWorld worldIn, Random rand, BlockPos pos, BlockState state) {
        BlockPos blockpos = pos.up();
        NetherVegetationFeature.func_236325_a_(worldIn, rand, blockpos, Features.Configs.WARPED_FOREST_VEGETATION_CONFIG, 3, 1);
    }
}
