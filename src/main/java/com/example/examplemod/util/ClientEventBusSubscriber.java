package com.example.examplemod.util;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.client.entity.render.ExampleEntityRenderer;
import com.example.examplemod.screen.CraftingStationScreen;
import com.example.examplemod.setup.ModContainers;
import com.example.examplemod.setup.ModEntityTypes;
import net.minecraft.client.gui.ScreenManager;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = ExampleMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientEventBusSubscriber {

    @SubscribeEvent
    public static void clientSetup(FMLClientSetupEvent event) {
        //GUI / SCREENS
        ScreenManager.registerFactory(ModContainers.CRAFTING_STATION_CONTAINER.get(), CraftingStationScreen::new);

        //MOBS / ANIMALS
        RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.EXAMPLE_ENTITY.get(), ExampleEntityRenderer::new);
    }
}
