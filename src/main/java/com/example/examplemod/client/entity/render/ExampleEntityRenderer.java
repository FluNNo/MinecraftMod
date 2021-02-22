package com.example.examplemod.client.entity.render;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.client.entity.model.ExampleEntityModel;
import com.example.examplemod.entities.ExampleEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class ExampleEntityRenderer extends MobRenderer<ExampleEntity, ExampleEntityModel<ExampleEntity>> {

    protected static final ResourceLocation TEXTURE = new ResourceLocation(ExampleMod.MODID, "textures/entity/example_entity.png");

    public ExampleEntityRenderer(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new ExampleEntityModel<>(), 0.5f);
    }

    @Override
    public ResourceLocation getEntityTexture(ExampleEntity entity) {
        return TEXTURE;
    }
}