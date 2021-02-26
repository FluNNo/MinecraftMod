package com.example.examplemod.world.biomes;

import com.example.examplemod.setup.ModBlocks;
import com.example.examplemod.setup.ModEntityTypes;
import com.example.examplemod.world.gen.features.config.ModFeatureConfig;
import net.minecraft.entity.EntityClassification;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.SoundEvents;
import net.minecraft.world.biome.*;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureSpreadConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.surfacebuilders.ConfiguredSurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.DefaultSurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;

public class Phoesis {

    public Biome biome;

    public Phoesis() {

        biome = new Biome.Builder()
                .precipitation(Biome.RainType.RAIN)
                .category(Biome.Category.PLAINS)
                .depth(0.4F)
                .scale(0.3F)
                .temperature(0.7F)
                .downfall(0.8F)
                .setEffects((new BiomeAmbience.Builder())
                        .setWaterColor(7098023)
                        .setWaterFogColor(7098023)
                        .setFogColor(7098023)
                        .withSkyColor(7098023)
                        .withGrassColor(7098023)
                        .withFoliageColor(7098023)
                        .setMoodSound(MoodSoundAmbience.DEFAULT_CAVE)
                        .setAmbientSound(SoundEvents.AMBIENT_WARPED_FOREST_LOOP)
                        .setParticle(new ParticleEffectAmbience(ParticleTypes.WARPED_SPORE, 0.01f))
                        .build())
                .withMobSpawnSettings(new MobSpawnInfo.Builder()
                        .withSpawner(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(ModEntityTypes.MUTZEN_SHEEP.get(), 1, 1, 1)).copy())
                .withGenerationSettings(new BiomeGenerationSettings.Builder()
                        .withSurfaceBuilder(() -> new ConfiguredSurfaceBuilder(DefaultSurfaceBuilder.DEFAULT,
                                new SurfaceBuilderConfig(
                                        ModBlocks.PHOESIS_GRASS.get().getDefaultState(),
                                        ModBlocks.PHOESIS_STONE.get().getDefaultState(),
                                        ModBlocks.PHOESIS_STONE.get().getDefaultState())))
                        .withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(ModFeatureConfig.PHOESIS_MUSHROOM_CONFIG).withPlacement(Placement.COUNT_MULTILAYER.configure(new FeatureSpreadConfig(16))))
                        .withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(ModFeatureConfig.PHOESIS_BLOOMLIGHT_CONFIG).withPlacement(Placement.COUNT_MULTILAYER.configure(new FeatureSpreadConfig(1))))
                        .build())
                .build();
    }


    // public static final BlockStateProvidingFeatureConfig WARPED_FOREST_VEGETATION_CONFIG = new BlockStateProvidingFeatureConfig((new WeightedBlockStateProvider()).addWeightedBlockstate(Features.States.WARPED_ROOTS, 85).addWeightedBlockstate(Features.States.CRIMSON_ROOTS, 1).addWeightedBlockstate(Features.States.WARPED_FUNGUS, 13).addWeightedBlockstate(Features.States.CRIMSON_FUNGUS, 1));

}

// public static Biome makeWarpedForestBiome() {
//    MobSpawnInfo mobspawninfo =
//            (new MobSpawnInfo.Builder())
//                    .withSpawner(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(EntityType.ENDERMAN, 1, 4, 4))
//                    .withSpawner(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityType.STRIDER, 60, 1, 2))
//                    .withSpawnCost(EntityType.ENDERMAN, 1.0D, 0.12D).copy();
//
//    BiomeGenerationSettings.Builder biomegenerationsettings$builder =
//             (new BiomeGenerationSettings.Builder())
//                     .withSurfaceBuilder(ConfiguredSurfaceBuilders.field_244190_v)
//                     .withStructure(StructureFeatures.FORTRESS)
//                     .withStructure(StructureFeatures.BASTION_REMNANT)
//                     .withStructure(StructureFeatures.RUINED_PORTAL_NETHER)
//                     .withCarver(GenerationStage.Carving.AIR, ConfiguredCarvers.field_243772_f)
//                     .withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Features.SPRING_LAVA);
//
//    DefaultBiomeFeatures.withNormalMushroomGeneration(biomegenerationsettings$builder);
//
//   biomegenerationsettings$builder
//           .withFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Features.SPRING_OPEN)
//           .withFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Features.PATCH_FIRE)
//           .withFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Features.PATCH_SOUL_FIRE)
//           .withFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Features.GLOWSTONE_EXTRA)
//           .withFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Features.GLOWSTONE)
//           .withFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Features.ORE_MAGMA)
//           .withFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Features.SPRING_CLOSED)
//           .withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Features.WARPED_FUNGI)
//           .withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Features.WARPED_FOREST_VEGETATION)
//           .withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Features.NETHER_SPROUTS)
//           .withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Features.TWISTING_VINES);
//
//    DefaultBiomeFeatures.withCommonNetherBlocks(biomegenerationsettings$builder);
//
//    return (new Biome.Builder()).precipitation(Biome.RainType.NONE).category(Biome.Category.NETHER).depth(0.1F).scale(0.2F).temperature(2.0F).downfall(0.0F).setEffects((new BiomeAmbience.Builder()).setWaterColor(4159204).setWaterFogColor(329011).setFogColor(1705242).withSkyColor(getSkyColorWithTemperatureModifier(2.0F)).setParticle(new ParticleEffectAmbience(ParticleTypes.WARPED_SPORE, 0.01428F)).setAmbientSound(SoundEvents.AMBIENT_WARPED_FOREST_LOOP).setMoodSound(new MoodSoundAmbience(SoundEvents.AMBIENT_WARPED_FOREST_MOOD, 6000, 8, 2.0D)).setAdditionsSound(new SoundAdditionsAmbience(SoundEvents.AMBIENT_WARPED_FOREST_ADDITIONS, 0.0111D)).setMusic(BackgroundMusicTracks.getDefaultBackgroundMusicSelector(SoundEvents.MUSIC_NETHER_WARPED_FOREST)).build()).withMobSpawnSettings(mobspawninfo).withGenerationSettings(biomegenerationsettings$builder.build()).build();
//   }
