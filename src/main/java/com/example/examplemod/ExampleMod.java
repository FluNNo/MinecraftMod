package com.example.examplemod;

import com.example.examplemod.entities.MutzenSheep;
import com.example.examplemod.setup.ModBiomes;
import com.example.examplemod.setup.ModEntityTypes;
import com.example.examplemod.setup.RegistryHandler;
import com.example.examplemod.world.OreGeneration;
import net.minecraft.entity.ai.attributes.GlobalEntityTypeAttributes;
import net.minecraft.util.RegistryKey;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.fml.DeferredWorkQueue;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.ForgeRegistries;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import software.bernie.geckolib3.GeckoLib;

import java.util.Objects;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(ExampleMod.MODID)
public class ExampleMod {
    public static final String MODID = "examplemod";

    private static final Logger LOGGER = LogManager.getLogger();

    public ExampleMod() {

        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        GeckoLib.initialize();

        // brauch man das?
        RegistryHandler.register();

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.addListener(EventPriority.HIGH, OreGeneration::generateOres);
        MinecraftForge.EVENT_BUS.register(this);
    }

    //add Line for each Mod Entity!
    private void setup(final FMLClientSetupEvent event) {
        DeferredWorkQueue.runLater(() -> {
            GlobalEntityTypeAttributes.put(ModEntityTypes.MUTZEN_SHEEP.get(), MutzenSheep.setCustomAttributes().create());

            BiomeManager.addBiome(BiomeManager.BiomeType.WARM, new BiomeManager.BiomeEntry(key(ModBiomes.TECH_BIOME.get()), 10));
            BiomeDictionary.addTypes(key(ModBiomes.TECH_BIOME.get()), BiomeDictionary.Type.PLAINS, BiomeDictionary.Type.OVERWORLD);
        });
    }

    private static RegistryKey<Biome> key(final Biome biome) {
        return RegistryKey.getOrCreateKey(ForgeRegistries.Keys.BIOMES, Objects.requireNonNull(ForgeRegistries.BIOMES.getKey(biome), "Biome registry name was null"));
    }

}
// GlobalEntityTypeAttributes
//EntityAttributeCreationEvent