package com.example.examplemod.setup;

import com.example.examplemod.world.biomes.Phoesis;
import net.minecraft.util.RegistryKey;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Objects;

public class ModBiomes {

    public static final RegistryObject<Biome> PHOESIS = RegistryHandler.BIOMES.register("phoesis", () -> new Phoesis().biome);

    static void register() { };

    private static RegistryKey<Biome> key(final Biome biome) {
        return RegistryKey.getOrCreateKey(ForgeRegistries.Keys.BIOMES, Objects.requireNonNull(ForgeRegistries.BIOMES.getKey(biome), "Biome registry name was null"));
    }

    public static void registerBiomesToDictionary() {
        BiomeManager.addBiome(BiomeManager.BiomeType.WARM, new BiomeManager.BiomeEntry(key(ModBiomes.PHOESIS.get()), 0));
        BiomeDictionary.addTypes(key(ModBiomes.PHOESIS.get()), BiomeDictionary.Type.PLAINS, BiomeDictionary.Type.OVERWORLD);

    }

}
