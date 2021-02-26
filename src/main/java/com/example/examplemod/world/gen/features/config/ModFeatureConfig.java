package com.example.examplemod.world.gen.features.config;

import com.example.examplemod.setup.ModBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.world.gen.blockplacer.SimpleBlockPlacer;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.BlockClusterFeatureConfig;

public class ModFeatureConfig {
    private static final BlockState MUSHROOM = ModBlocks.PHOESIS_MUSHROOM.get().getDefaultState();

    public static final BlockClusterFeatureConfig MUSHROOM_CONFIG = (new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(MUSHROOM), new SimpleBlockPlacer())).tries(8).build();

}
