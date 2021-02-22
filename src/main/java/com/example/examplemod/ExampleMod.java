package com.example.examplemod;

import com.example.examplemod.entities.ExampleEntity;
import com.example.examplemod.setup.ModEntityTypes;
import com.example.examplemod.setup.RegistryHandler;
import com.example.examplemod.world.OreGeneration;
import net.minecraft.entity.ai.attributes.GlobalEntityTypeAttributes;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.fml.DeferredWorkQueue;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(ExampleMod.MODID)
public class ExampleMod {
    public static final String MODID = "examplemod";

    private static final Logger LOGGER = LogManager.getLogger();

    public ExampleMod() {

        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);

        RegistryHandler.register();

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.addListener(EventPriority.HIGH, OreGeneration::generateOres);
        MinecraftForge.EVENT_BUS.register(this);
    }

    //add Line for each Mod Entity!
    private void setup(final FMLClientSetupEvent event) {
        DeferredWorkQueue.runLater(() -> {
            GlobalEntityTypeAttributes.put(ModEntityTypes.EXAMPLE_ENTITY.get(), ExampleEntity.setCustomAttributes().create());
        });
    }

}