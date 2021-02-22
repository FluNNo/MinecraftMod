package com.example.examplemod.client.entity.render;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.client.entity.model.MutzenSheepModel;
import com.example.examplemod.entities.MutzenSheep;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class MutzenSheepRenderer extends MobRenderer<MutzenSheep, MutzenSheepModel<MutzenSheep>> {

    protected static final ResourceLocation TEXTURE = new ResourceLocation(ExampleMod.MODID, "textures/entity/mutzen_sheep.png");

    public MutzenSheepRenderer(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new MutzenSheepModel<>(), 0.5f);
    }

    @Override
    public ResourceLocation getEntityTexture(MutzenSheep entity) {
        return TEXTURE;
    }
}