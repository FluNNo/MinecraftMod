package com.example.examplemod.setup;

import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.fml.RegistryObject;

public class ModItems {

    /*public static final RegistryObject<Item> CHAMELEON_BLOCK = RegistryHandler.ITEMS.register("chameleon_block", () ->
        new Item(new Item.Properties().group(ItemGroup.MATERIALS)));*/

    public static final  RegistryObject<Item> CHAMELEON_INGOT = RegistryHandler.ITEMS.register("chameleon_ingot", () ->
            new Item((new Item.Properties().group(ItemGroup.MATERIALS))));

    /*public static final  RegistryObject<Item> CHAMELEON_ORE = RegistryHandler.ITEMS.register("chameleon_ore", () ->
            new Item((new Item.Properties().group(ItemGroup.MATERIALS))));*/

    public static final  RegistryObject<Item> CONTAINED_MATTER = RegistryHandler.ITEMS.register("contained_matter", () ->
            new Item((new Item.Properties().group(ItemGroup.MATERIALS))));

    public static final  RegistryObject<Item> CONTAINED_MATTER_UNSTABLE = RegistryHandler.ITEMS.register("contained_matter_unstable", () ->
            new Item((new Item.Properties().group(ItemGroup.MATERIALS))));

    /*public static final  RegistryObject<Item> CRAFTING_STATION_V1 = RegistryHandler.ITEMS.register("crafting_station_v1", () ->
            new Item((new Item.Properties().group(ItemGroup.MATERIALS))));*/

    public static final  RegistryObject<Item> MATTER = RegistryHandler.ITEMS.register("matter", () ->
            new Item((new Item.Properties().group(ItemGroup.MATERIALS))));

    static void register() {}
}
