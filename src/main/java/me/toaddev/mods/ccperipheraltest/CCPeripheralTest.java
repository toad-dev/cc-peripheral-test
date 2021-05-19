package me.toaddev.mods.ccperipheraltest;

import dan200.computercraft.api.ComputerCraftAPI;
import me.toaddev.mods.ccperipheraltest.peripherals.TestPeripheralProvider;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class CCPeripheralTest implements ModInitializer {
    public static final Block TEST_PERIPHERAL_BLOCK = new Block(FabricBlockSettings.of(Material.STONE));
    public static final Identifier TEST_PERIPHERAL_ID = new Identifier("cc_test", "test_peripheral");

    @Override
    public void onInitialize() {
        Registry.register(Registry.BLOCK, TEST_PERIPHERAL_ID, TEST_PERIPHERAL_BLOCK);
        Registry.register(Registry.ITEM, TEST_PERIPHERAL_ID, new BlockItem(TEST_PERIPHERAL_BLOCK, new FabricItemSettings().group(ItemGroup.MISC)));

        ComputerCraftAPI.registerPeripheralProvider(new TestPeripheralProvider());
    }
}
