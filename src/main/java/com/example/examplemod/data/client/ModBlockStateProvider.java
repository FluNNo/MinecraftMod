package com.example.examplemod.data.client;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.setup.ModBlocks;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(DataGenerator gen, ExistingFileHelper exFileHelper) {
        super(gen, ExampleMod.MODID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        simpleBlock(ModBlocks.CHAMELEON_BLOCK.get());
        simpleBlock(ModBlocks.CHAMELEON_ORE.get());
    }
}
