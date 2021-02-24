package com.example.examplemod.world.biomes;

import com.example.examplemod.setup.ModBlocks;
import com.example.examplemod.setup.ModEntityTypes;
import net.minecraft.entity.EntityClassification;
import net.minecraft.world.biome.*;
import net.minecraft.world.gen.blockstateprovider.WeightedBlockStateProvider;
import net.minecraft.world.gen.feature.BlockStateProvidingFeatureConfig;
import net.minecraft.world.gen.feature.Features;
import net.minecraft.world.gen.surfacebuilders.ConfiguredSurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.DefaultSurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;

public class Phoesis {

    public Biome biome;

    public Phoesis() {

        biome = new Biome.Builder()
            .precipitation(Biome.RainType.RAIN)
            .category(Biome.Category.PLAINS)
            .depth(0.1F)
            .scale(0.2F)
            .temperature(0.7F)
            .downfall(0.8F)
            .setEffects((new BiomeAmbience.Builder())
                .setWaterColor(7098023)
                .setWaterFogColor(14733798)
                .setFogColor(16627961)
                .setMoodSound(MoodSoundAmbience.DEFAULT_CAVE)
                .withSkyColor(123123)
                .build())
            .withMobSpawnSettings(new MobSpawnInfo.Builder()
                    .withSpawner(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(ModEntityTypes.MUTZEN_SHEEP.get(), 1,5,10)).copy())
            .withGenerationSettings(new BiomeGenerationSettings.Builder()
                    .withSurfaceBuilder(() -> new ConfiguredSurfaceBuilder(DefaultSurfaceBuilder.DEFAULT,
                            new SurfaceBuilderConfig(
                                    ModBlocks.PHOESIS_GRASS_BLOCK.get().getDefaultState(),
                                    ModBlocks.PHOESIS_STONE.get().getDefaultState(),
                                    ModBlocks.PHOESIS_STONE.get().getDefaultState())))
                    .build())
        .build();
    }

   // public static final BlockStateProvidingFeatureConfig WARPED_FOREST_VEGETATION_CONFIG = new BlockStateProvidingFeatureConfig((new WeightedBlockStateProvider()).addWeightedBlockstate(Features.States.WARPED_ROOTS, 85).addWeightedBlockstate(Features.States.CRIMSON_ROOTS, 1).addWeightedBlockstate(Features.States.WARPED_FUNGUS, 13).addWeightedBlockstate(Features.States.CRIMSON_FUNGUS, 1));

}
