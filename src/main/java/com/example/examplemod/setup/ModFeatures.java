package com.example.examplemod.setup;

import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureSpreadConfig;
import net.minecraft.world.gen.feature.HugeFungusConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.fml.RegistryObject;

public class ModFeatures {

    public static final RegistryObject<Feature<?>> WARPED_FUNGI = RegistryHandler.FEATURES.register("phoesis_mushroom_block", () -> Feature.HUGE_FUNGUS.withConfiguration(HugeFungusConfig.field_236302_e_).withPlacement(Placement.COUNT_MULTILAYER.configure(new FeatureSpreadConfig(8))));

    static void register() {}

}
