package com.example.examplemod.setup;

import com.example.examplemod.world.gen.features.PhoesisHugeFungusConfig;
import com.example.examplemod.world.gen.features.PhoesisHugeFungusFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.IFeatureConfig;

import java.util.function.Supplier;

public class ModFeatures {

    //Features
    public static final Feature<PhoesisHugeFungusConfig> PHOESIS_HUGE_FUNGUS = registerFeature("phoesis_huge_fungus", () -> new PhoesisHugeFungusFeature(PhoesisHugeFungusConfig.CODEC));


    public static void register() {}

    private static <C extends IFeatureConfig, F extends Feature<C>> F registerFeature(String key, Supplier<F> value) {
        RegistryHandler.FEATURES.register(key , value);
        return value.get();
    }
}
