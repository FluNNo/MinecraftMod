package com.example.examplemod.gui;

import net.minecraft.client.gui.screen.inventory.CraftingScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.WorkbenchContainer;
import net.minecraft.util.text.ITextComponent;

public class CraftingTableGUI extends CraftingScreen {

    public CraftingTableGUI(WorkbenchContainer screenContainer, PlayerInventory inv, ITextComponent titleIn) {
        super(screenContainer, inv, titleIn);
    }
}
