package com.example.examplemod.client.item.model;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.item.MatterGloveItem;
import net.minecraft.util.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class MatterGloveModel extends AnimatedGeoModel<MatterGloveItem> {

    @Override
    public ResourceLocation getModelLocation(MatterGloveItem matterGloveItem) {
        return new ResourceLocation(ExampleMod.MODID, "geo/matter_glove.geo.json");
    }

    @Override
    public ResourceLocation getTextureLocation(MatterGloveItem matterGloveItem) {
        return new ResourceLocation(ExampleMod.MODID, "textures/items/matter_glove.png");
    }

    @Override
    public ResourceLocation getAnimationFileLocation(MatterGloveItem matterGloveItem) {
        return new ResourceLocation(ExampleMod.MODID, "animations/matter_glove.animation.json");
    }

}
