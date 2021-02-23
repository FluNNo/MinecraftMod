package com.example.examplemod.client.item.render;

import com.example.examplemod.client.item.model.MatterGloveModel;
import com.example.examplemod.item.MatterGloveItem;
import net.minecraft.item.Item;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.renderers.geo.GeoItemRenderer;

public class MatterGloveRenderer extends GeoItemRenderer<MatterGloveItem> {

    public MatterGloveRenderer() {
        super(new MatterGloveModel());
    }
}

