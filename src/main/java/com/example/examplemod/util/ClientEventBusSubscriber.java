package com.example.examplemod.util;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.client.entity.render.ExampleEntityRender;
import com.example.examplemod.setup.ModEntityTypes;
import net.minecraft.client.gui.ScreenManager;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.ModContainer;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = ExampleMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientEventBusSubscriber {
    public static void clientSetup(FMLClientSetupEvent event) {
        // Jede Entity braucht eine eigene Zeile!
        RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.EXAMPLE_ENTITY.get(), ExampleEntityRender::new);
    }
}
