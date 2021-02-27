package com.example.examplemod.world.gen.features;

import com.example.examplemod.setup.ModBlocks;
import com.example.examplemod.setup.ModFeatures;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.world.gen.blockplacer.SimpleBlockPlacer;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.BlockClusterFeatureConfig;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.FeatureSpreadConfig;
import net.minecraft.world.gen.placement.Placement;

public class ModFeatureConfig {
    //Blockstates
    private static final BlockState PHOESIS_MUSHROOM = ModBlocks.PHOESIS_MUSHROOM.get().getDefaultState();
    private static final BlockState PHOESIS_BLOOMLIGHT = ModBlocks.PHOESIS_BLOOMLIGHT.get().getDefaultState();
    private static final BlockState PHOESIS_GRASS = ModBlocks.PHOESIS_GRASS.get().getDefaultState();

    //BlockCluster Configs
    public static final BlockClusterFeatureConfig PHOESIS_MUSHROOM_CONFIG = new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(PHOESIS_MUSHROOM), new SimpleBlockPlacer()).tries(8).build();
    public static final BlockClusterFeatureConfig PHOESIS_BLOOMLIGHT_CONFIG = new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(PHOESIS_BLOOMLIGHT), new SimpleBlockPlacer()).tries(8).build();
    public static final BlockClusterFeatureConfig PHOESIS_GRASS_CONFIG = new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(PHOESIS_GRASS), new SimpleBlockPlacer()).tries(8).build();

    //Custom Configs
    public static final PhoesisHugeFungusConfig FUNGUS = new PhoesisHugeFungusConfig(ModBlocks.PHOESIS_GRASS_BLOCK.get().getDefaultState(), ModBlocks.TECH_CASING.get().getDefaultState(), Blocks.WARPED_WART_BLOCK.getDefaultState(), Blocks.SHROOMLIGHT.getDefaultState(), true);

    //Configured Features
    public static final ConfiguredFeature<?, ?> PHOESIS_FUNGI = ModFeatures.PHOESIS_HUGE_FUNGUS.withConfiguration(ModFeatureConfig.FUNGUS).withPlacement(Placement.COUNT_MULTILAYER.configure(new FeatureSpreadConfig(8)));

}
