package com.example.examplemod.setup;

import com.example.examplemod.block.*;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.item.BlockItem;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.RegistryObject;

import java.util.function.Supplier;


public class ModBlocks {

    //Normal Blocks
    public static final RegistryObject<Block> CHAMELEON_ORE = register("chameleon_ore", () -> new Block(Props.DEFAULT_STONE_BLOCK));
    public static final RegistryObject<Block> CHAMELEON_BLOCK = register("chameleon_block", () -> new Block(Props.DEFAULT_STONE_BLOCK));
    public static final RegistryObject<Block> TECH_CASING = register("tech_casing", () -> new Block(Props.DEFAULT_IRON_BLOCK));
    public static final RegistryObject<Block> TECH_PILLAR = register("tech_pillar", () -> new Block(Props.DEFAULT_IRON_BLOCK));
    public static final RegistryObject<Block> TECH_ENERGY = register("tech_energy_block", () -> new Block(Props.DEFAULT_IRON_BLOCK));
    public static final RegistryObject<Block> PHOESIS_STONE = register("phoesis_stone", () -> new Block(Props.DEFAULT_STONE_BLOCK));
    public static final RegistryObject<Block> PHOESIS_BIG_MUSHROOM = register("phoesis_big_mushroom", () -> new Block(Props.DEFAULT_STONE_BLOCK));
    public static final RegistryObject<Block> PHOESIS_MUSHROOM_STEM = register("phoesis_mushroom_stem", () -> new Block(Props.DEFAULT_STONE_BLOCK));

    //Abnormal Blocks
    public static final RegistryObject<Block> MATTER_STABILIZER = register("matter_stabilizer", () -> new MatterStabilizerBlock());

    //Advanced Blocks
    public static final RegistryObject<Block> CRAFTING_STATION = register("crafting_station_v1", () -> new CraftingStationBlock(Props.DEFAULT_IRON_BLOCK));

    //Growable Blocks
    public static final RegistryObject<Block> PHOESIS_GRASS_BLOCK = register("phoesis_grass_block", () -> new PhoesisGrassBlock());

    //Plants
    public static final RegistryObject<Block> PHOESIS_MUSHROOM = register("phoesis_mushroom", () -> new PhoesisMushroom());
    public static final RegistryObject<Block> PHOESIS_BLOOMLIGHT = register("phoesis_bloomlight", () -> new PhoesisBloomlight());
    public static final RegistryObject<Block> PHOESIS_GRASS = register("phoesis_grass", () -> new PhoesisGrass());

    //Misc
    public static final RegistryObject<Block> PHOESIS_PORTAL = register("phoesis_portal", () -> new PhoesisPortalBlock(Props.DEFAULT_PORTAL));



    static void register() {}

    private static <T extends Block> RegistryObject<T> registerNoItem(String name, Supplier<T> block) {
        return RegistryHandler.BLOCKS.register(name, block);
    }

    private static <T extends Block> RegistryObject<T> register(String name, Supplier<T> block) {
        RegistryObject<T> ret = registerNoItem(name, block);
        RegistryHandler.ITEMS.register(name, () -> new BlockItem(ret.get(), Props.DEFAULT_ITEM));
        return ret;
    }

    @OnlyIn(Dist.CLIENT)
    public static void setRenderTypes() {
        RenderTypeLookup.setRenderLayer(PHOESIS_BLOOMLIGHT.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(PHOESIS_MUSHROOM.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(PHOESIS_GRASS.get(), RenderType.getCutout());
    }

}
