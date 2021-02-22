package com.example.examplemod.recipes;

import com.example.examplemod.ExampleMod;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.items.wrapper.RecipeWrapper;

public interface ICustomRecipe extends IRecipe<RecipeWrapper> {

    ResourceLocation RECIPE_TYPE_ID = new ResourceLocation(ExampleMod.MODID, "custom");


    @Override
    default boolean canFit(int width, int height) {
        return false;
    }

    Ingredient getInput();
}
