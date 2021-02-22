package com.example.examplemod.setup;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.entities.ExampleEntity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.RegistryObject;

import static com.example.examplemod.setup.RegistryHandler.ENTITY_TYPES;

public class ModEntityTypes {


    public static final RegistryObject<EntityType<ExampleEntity>> EXAMPLE_ENTITY = ENTITY_TYPES.register("example_entity", () ->
            EntityType.Builder.<ExampleEntity>create(ExampleEntity::new, EntityClassification.CREATURE)
                    .size(0.9f, 1.3f).build(new ResourceLocation(ExampleMod.MODID, "example_entity").toString()));

    public static void register() { }
}
