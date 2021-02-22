package com.example.examplemod.setup;

import com.example.examplemod.recipes.CustomRecipe;
import com.example.examplemod.recipes.CustomRecipeSerializer;
import com.example.examplemod.recipes.ICustomRecipe;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraftforge.fml.RegistryObject;

public class ModRecipes {

    public static final IRecipeSerializer<CustomRecipe> CUSTOM_RECIPE_SERIALIZER = new CustomRecipeSerializer();
    public static final IRecipeType<ICustomRecipe> CUSTOM_TYPE = registerType(ICustomRecipe.RECIPE_TYPE_ID);

    public static final RegistryObject<IRecipeSerializer<?>> CUSTOM_SERIALIZER = RegistryHandler.RECIPE_SERIALIZERS.register("custom",
            () -> CUSTOM_RECIPE_SERIALIZER);

    static void register() {};

    private static class RecipeType<T extends IRecipe<?>> implements IRecipeType<T> {
        @Override
        public String toString() {
            return Registry.RECIPE_TYPE.getKey(this).toString();
        }
    }

    private static <T extends IRecipeType> T registerType(ResourceLocation recipeTypeId) {
        return (T) Registry.register(Registry.RECIPE_TYPE, recipeTypeId, new RecipeType<>());
    }
}
