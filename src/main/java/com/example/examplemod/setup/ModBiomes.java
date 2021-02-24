package com.example.examplemod.setup;

import com.example.examplemod.world.biomes.Phoesis;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.fml.RegistryObject;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ModBiomes {
    private static final Logger LOGGER = LogManager.getLogger();

    public static final RegistryObject<Biome> PHOESIS = RegistryHandler.BIOMES.register("phoesis", () ->
            new Phoesis().biome);

    static void register() { };

}
