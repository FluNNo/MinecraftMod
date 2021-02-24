package com.example.examplemod.setup;

import com.example.examplemod.block.CraftingStationBlock;
import com.example.examplemod.block.MatterStabilizerBlock;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final RegistryObject<Block> CHAMELEON_ORE = register("chameleon_ore", () ->
            new Block(AbstractBlock.Properties.create(Material.ROCK).hardnessAndResistance(3, 10).harvestLevel(2).sound(SoundType.STONE)));

    public static final RegistryObject<Block> CHAMELEON_BLOCK = register("chameleon_block", () ->
            new Block(AbstractBlock.Properties.create(Material.IRON).hardnessAndResistance(3, 10).sound(SoundType.METAL)));

    public static final RegistryObject<Block> TECH_CASING = register("tech_casing", () ->
            new Block(AbstractBlock.Properties.create(Material.IRON).hardnessAndResistance(3, 10).sound(SoundType.METAL)));

    public static final RegistryObject<Block> TECH_PILLAR = register("tech_pillar", () ->
            new Block(AbstractBlock.Properties.create(Material.IRON).hardnessAndResistance(3, 10).sound(SoundType.METAL)));

    public static final RegistryObject<Block> TECH_ENERGY_BLOCK = register("tech_energy_block", () ->
            new Block(AbstractBlock.Properties.create(Material.IRON).hardnessAndResistance(3, 10).sound(SoundType.METAL)));

    public static final RegistryObject<Block> MATTER_STABILIZER = register("matter_stabilizer", MatterStabilizerBlock::new);

    public static final RegistryObject<Block> CRAFTING_STATION = register("crafting_station_v1", () ->
            new CraftingStationBlock(AbstractBlock.Properties.create(Material.IRON).hardnessAndResistance(3, 10).sound(SoundType.METAL)));

    public static final RegistryObject<Block> PHOESIS_GRASS_BLOCK = register("phoesis_grass_block", () ->
            new Block(AbstractBlock.Properties.create(Material.IRON).hardnessAndResistance(3, 10).sound(SoundType.METAL)));

    public static final RegistryObject<Block> PHOESIS_STONE = register("phoesis_stone", () ->
            new Block(AbstractBlock.Properties.create(Material.IRON).hardnessAndResistance(3, 10).sound(SoundType.METAL)));



    static void register() {}

    private static <T extends Block> RegistryObject<T> registerNoItem(String name, Supplier<T> block) {
        return RegistryHandler.BLOCKS.register(name, block);
    }

    private static <T extends Block> RegistryObject<T> register(String name, Supplier<T> block) {
        RegistryObject<T> ret = registerNoItem(name, block);
        RegistryHandler.ITEMS.register(name, () -> new BlockItem(ret.get(), new Item.Properties().group(RegistryHandler.EXAMPLE_GROUP)));
        return ret;
    }
}
