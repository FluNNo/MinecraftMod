package com.example.examplemod.setup;

import com.example.examplemod.client.item.render.MatterGloveRenderer;
import com.example.examplemod.item.MatterGloveItem;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraftforge.fml.RegistryObject;

import java.util.function.Supplier;

public class ModItems {

    //Items
    public static final  RegistryObject<Item> CHAMELEON_INGOT = register("chameleon_ingot", () -> new Item(Props.DEFAULT_ITEM));
    public static final  RegistryObject<Item> CONTAINED_MATTER = register("contained_matter", () -> new Item(Props.DEFAULT_ITEM));
    public static final  RegistryObject<Item> CONTAINED_MATTER_UNSTABLE = register("contained_matter_unstable", () -> new Item(Props.DEFAULT_ITEM));
    public static final  RegistryObject<Item> MATTER = register("matter", () -> new Item(Props.DEFAULT_ITEM));

    //Animated Items
    public static final RegistryObject<MatterGloveItem> MATTER_GLOVE = register("matter_glove", () -> new MatterGloveItem(Props.DEFAULT_ITEM.setISTER(() -> MatterGloveRenderer::new)));

    //Food
    public static final  RegistryObject<Item> MUTZEN = register("mutzen", () -> new Item(Props.DEFAULT_ITEM.food(new Food.Builder().effect(() -> new EffectInstance(Effects.SPEED, 200, 1),1.0f).fastToEat().hunger(2).saturation(0.6f).build())));
    public static final  RegistryObject<Item> MUTZEN_XL = register("mutzen_xl", () -> new Item(Props.DEFAULT_ITEM.food(new Food.Builder().effect(() -> new EffectInstance(Effects.SPEED, 200, 2),1.0f).hunger(18).saturation(3.0f).build())));



    static void register() {}

    private static <T extends Item> RegistryObject<T> register(String name, Supplier<T> item) {
        RegistryObject<T> ret = RegistryHandler.ITEMS.register(name, item);
        return ret;
    }
}
