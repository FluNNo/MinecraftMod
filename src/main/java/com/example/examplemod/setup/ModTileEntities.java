package com.example.examplemod.setup;

import com.example.examplemod.tileentities.CraftingStationTileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.fml.RegistryObject;

public class ModTileEntities {

    public static final RegistryObject<TileEntityType<CraftingStationTileEntity>> CRAFTING_STATION_TILE_ENTITY_TYPE =
            RegistryHandler.TILE_ENTITY_TYPES.register("crafting_station_tile_entity", () ->
                    TileEntityType.Builder.create(CraftingStationTileEntity::new, ModBlocks.CRAFTING_STATION.get()).build(null));

    public static void register() {}

}
