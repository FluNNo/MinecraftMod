package com.example.examplemod.setup;

import com.example.examplemod.ExampleMod;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraftforge.fml.RegistryObject;

public class ModItems {

    public static final  RegistryObject<Item> CHAMELEON_INGOT = RegistryHandler.ITEMS.register("chameleon_ingot", () ->
            new Item((new Item.Properties().group(RegistryHandler.EXAMPLE_GROUP))));

    public static final  RegistryObject<Item> CONTAINED_MATTER = RegistryHandler.ITEMS.register("contained_matter", () ->
            new Item((new Item.Properties().group(RegistryHandler.EXAMPLE_GROUP))));

    public static final  RegistryObject<Item> CONTAINED_MATTER_UNSTABLE = RegistryHandler.ITEMS.register("contained_matter_unstable", () ->
            new Item((new Item.Properties().group(RegistryHandler.EXAMPLE_GROUP))));

    public static final  RegistryObject<Item> MATTER = RegistryHandler.ITEMS.register("matter", () ->
            new Item((new Item.Properties().group(RegistryHandler.EXAMPLE_GROUP))));

    public static final  RegistryObject<Item> MUTZEN = RegistryHandler.ITEMS.register("mutzen", () ->
            new Item((new Item.Properties().group(RegistryHandler.EXAMPLE_GROUP).food(new Food.Builder().effect(() -> new EffectInstance(Effects.SPEED, 200, 1),1.0f).fastToEat().hunger(2).saturation(0.6f).build()))));

    public static final  RegistryObject<Item> MUTZEN_XL = RegistryHandler.ITEMS.register("mutzen_xl", () ->
            new Item((new Item.Properties().group(RegistryHandler.EXAMPLE_GROUP).food(new Food.Builder().effect(() -> new EffectInstance(Effects.SPEED, 200, 2),1.0f).hunger(18).saturation(3.0f).build()))));

    static void register() {}
}
