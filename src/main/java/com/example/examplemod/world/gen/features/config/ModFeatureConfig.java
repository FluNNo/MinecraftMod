package com.example.examplemod.world.gen.features.config;

import com.example.examplemod.setup.ModBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.world.gen.blockplacer.SimpleBlockPlacer;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.BlockClusterFeatureConfig;

public class ModFeatureConfig {
    private static final BlockState PHOESIS_MUSHROOM = ModBlocks.PHOESIS_MUSHROOM.get().getDefaultState();
    private static final BlockState PHOESIS_BLOOMLIGHT = ModBlocks.PHOESIS_BLOOMLIGHT.get().getDefaultState();

    public static final BlockClusterFeatureConfig PHOESIS_MUSHROOM_CONFIG = new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(PHOESIS_MUSHROOM), new SimpleBlockPlacer()).tries(8).build();
    public static final BlockClusterFeatureConfig PHOESIS_BLOOMLIGHT_CONFIG = new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(PHOESIS_BLOOMLIGHT), new SimpleBlockPlacer()).tries(8).build();

}
