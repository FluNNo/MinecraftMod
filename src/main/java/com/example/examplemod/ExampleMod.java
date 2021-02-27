package com.example.examplemod;

import com.example.examplemod.entities.MutzenSheep;
import com.example.examplemod.setup.*;
import com.example.examplemod.world.gen.OreGeneration;
import com.example.examplemod.world.gen.WorldGenFeatures;
import net.minecraft.entity.ai.attributes.GlobalEntityTypeAttributes;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.fml.DeferredWorkQueue;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import software.bernie.geckolib3.GeckoLib;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(ExampleMod.MODID)
public class ExampleMod {
    public static final String MODID = "examplemod";

    private static final Logger LOGGER = LogManager.getLogger();

    public ExampleMod() {

        GeckoLib.initialize();

        //Register all Mod Objects
        RegistryHandler.register();

        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::clientSetup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::commonSetup);

        MinecraftForge.EVENT_BUS.addListener(EventPriority.HIGH, OreGeneration::generateOres);
        MinecraftForge.EVENT_BUS.addListener(EventPriority.HIGH, WorldGenFeatures::addFeaturesToBiomes);
        MinecraftForge.EVENT_BUS.register(this);
    }
    private void commonSetup(FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {

        });

        DeferredWorkQueue.runLater(() -> {
            ModBiomes.registerBiomesToDictionary();
        });
    }

    private void clientSetup(final FMLClientSetupEvent event) {
        DeferredWorkQueue.runLater(() -> {
            ModBlocks.setRenderTypes();
            GlobalEntityTypeAttributes.put(ModEntityTypes.MUTZEN_SHEEP.get(), MutzenSheep.setCustomAttributes().create());

        });
    }
}
// GlobalEntityTypeAttributes
//EntityAttributeCreationEvent