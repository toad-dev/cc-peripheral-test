package me.toaddev.mods.ccperipheraltest;

import dan200.computercraft.api.ComputerCraftAPI;
import me.toaddev.mods.ccperipheraltest.peripherals.TestPeripheralProvider;
import me.toaddev.mods.ccperipheraltest.peripherals.TestTurtleUpgrade;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.material.Material;

public class CCPeripheralTest implements ModInitializer {
    public static final String MOD_NAMESPACE = "cc_test";


    public static final ResourceLocation TEST_PERIPHERAL_ID = new ResourceLocation(MOD_NAMESPACE, "test_peripheral");
    // Declare block singleton to be used as peripheral block, with appropriate block settings.
    public static final Block TEST_PERIPHERAL_BLOCK = new Block(FabricBlockSettings.of(Material.STONE));
    // Declare item singleton that will represent our new block.
    public static final Item TEST_PERIPHERAL_ITEM = new BlockItem(TEST_PERIPHERAL_BLOCK, new FabricItemSettings().group(CreativeModeTab.TAB_MISC));

    @Override
    public void onInitialize() {
        // For minecraft to use the new block, it must be registered with an associated ResourceLocation.
        Registry.register(Registry.BLOCK, TEST_PERIPHERAL_ID, TEST_PERIPHERAL_BLOCK);
        // Also register the item associated with our block. Without this the new block could be /setblock'd into the
        // world, but not held in an inventory.
        Registry.register(Registry.ITEM, TEST_PERIPHERAL_ID, TEST_PERIPHERAL_ITEM);
        // The model, texture, and loot table for this block are defined with .json files. see resources/assets/cc_test

        // Register the peripheral provider that will connect our block to our peripheral.
        ComputerCraftAPI.registerPeripheralProvider(new TestPeripheralProvider());
        // Register the turtle upgrade too.
        ComputerCraftAPI.registerTurtleUpgrade(new TestTurtleUpgrade());
    }
}
