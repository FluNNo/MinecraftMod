package com.example.examplemod.client.entity.render;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.client.entity.model.ExampleEntityModel;
import com.example.examplemod.entities.ExampleEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class ExampleEntityRender extends MobRenderer<ExampleEntity, ExampleEntityModel<ExampleEntity>>{

    protected static final ResourceLocation TEXTURE = new ResourceLocation(ExampleMod.MODID, "textures/entities/example_entity.png");

    public ExampleEntityRender(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new ExampleEntityModel<ExampleEntity>(), 0.5f);
    }

    @Override
    public ResourceLocation getEntityTexture(ExampleEntity entity) {
        return TEXTURE;
    }
}