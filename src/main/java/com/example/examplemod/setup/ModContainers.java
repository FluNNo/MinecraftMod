package com.example.examplemod.setup;

import com.example.examplemod.container.CraftingStationContainer;
import net.minecraft.inventory.container.ContainerType;
import net.minecraftforge.common.extensions.IForgeContainerType;
import net.minecraftforge.fml.RegistryObject;

public class ModContainers {

    public static final RegistryObject<ContainerType<CraftingStationContainer>> CRAFTING_STATION_CONTAINER = RegistryHandler.CONTAINER_TYPES
            .register("crafting_station_container", () -> IForgeContainerType.create(CraftingStationContainer::new));

    static void register() {}
}
