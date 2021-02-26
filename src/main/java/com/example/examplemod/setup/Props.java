package com.example.examplemod.setup;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;

public class Props {

    //Blocks
    public static final AbstractBlock.Properties DEFAULT_STONE_BLOCK = AbstractBlock.Properties.create(Material.ROCK).hardnessAndResistance(10,3).sound(SoundType.STONE);
    public static final AbstractBlock.Properties DEFAULT_IRON_BLOCK = AbstractBlock.Properties.create(Material.IRON).hardnessAndResistance(10, 3).sound(SoundType.METAL);

    //Misc Blocks
    public static final AbstractBlock.Properties DEFAULT_PORTAL = AbstractBlock.Properties.create(Material.PORTAL).doesNotBlockMovement().hardnessAndResistance(-1.0F).sound(SoundType.GLASS).setLightLevel(value -> 10);

    //Items
    public static final Item.Properties DEFAULT_ITEM = new Item.Properties().group(RegistryHandler.EXAMPLE_GROUP);

}
