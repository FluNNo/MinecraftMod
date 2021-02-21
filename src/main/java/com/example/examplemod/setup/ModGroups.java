package com.example.examplemod.setup;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class ModGroups extends ItemGroup {

    public ModGroups(String label) {
        super(label);
    }

    @Override
    public ItemStack createIcon() {
        return ModItems.MUTZEN.get().getDefaultInstance();
    }
}

