package com.example.examplemod.world.biomes;

import com.example.examplemod.setup.ModBlocks;
import com.example.examplemod.setup.ModEntityTypes;
import net.minecraft.entity.EntityClassification;
import net.minecraft.world.biome.*;
import net.minecraft.world.gen.surfacebuilders.ConfiguredSurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.DefaultSurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;

public class TechBiome {

    public Biome biome;

    public TechBiome() {

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
                    .withSpawner(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(ModEntityTypes.MUTZEN_SHEEP.get(), 100,100,500)).copy())
            .withGenerationSettings(new BiomeGenerationSettings.Builder()
                    .withSurfaceBuilder(() -> new ConfiguredSurfaceBuilder(DefaultSurfaceBuilder.DEFAULT,
                            new SurfaceBuilderConfig(
                                    ModBlocks.TECH_CASING.get().getDefaultState(),
                                    ModBlocks.TECH_CASING.get().getDefaultState(),
                                    ModBlocks.TECH_CASING.get().getDefaultState())))
                    .build())
        .build();
    }

}
