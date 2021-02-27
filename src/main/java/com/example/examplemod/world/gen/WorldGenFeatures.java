package com.example.examplemod.world.gen;

import com.example.examplemod.setup.ModBiomes;
import com.example.examplemod.world.gen.features.ModFeatureConfig;
import net.minecraft.world.gen.GenerationStage;
import net.minecraftforge.common.world.BiomeGenerationSettingsBuilder;
import net.minecraftforge.event.world.BiomeLoadingEvent;

public class WorldGenFeatures {

    public static void addFeaturesToBiomes(final BiomeLoadingEvent event) {
        BiomeGenerationSettingsBuilder builder = event.getGeneration();

        if (event.getCategory().equals(ModBiomes.PHOESIS.get().getCategory())) {
            builder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, ModFeatureConfig.PHOESIS_FUNGI);
        }
    }
}