package com.example.examplemod.setup;

import com.example.examplemod.world.biomes.TechBiome;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.fml.RegistryObject;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ModBiomes {
    private static final Logger LOGGER = LogManager.getLogger();

    public static final RegistryObject<Biome> TECH_BIOME = RegistryHandler.BIOMES.register("tech_biome", () ->
            new TechBiome().biome);

    static void register() { };


}
