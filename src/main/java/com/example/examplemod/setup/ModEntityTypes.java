package com.example.examplemod.setup;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.entities.MutzenSheep;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.RegistryObject;

import static com.example.examplemod.setup.RegistryHandler.ENTITY_TYPES;

public class ModEntityTypes {


    public static final RegistryObject<EntityType<MutzenSheep>> MUTZEN_SHEEP = ENTITY_TYPES.register("mutzen_sheep", () ->
            EntityType.Builder.<MutzenSheep>create(MutzenSheep::new, EntityClassification.CREATURE)
                    .size(0.9f, 1.3f).build(new ResourceLocation(ExampleMod.MODID, "mutzen_sheep").toString()));

    public static void register() { }
}
