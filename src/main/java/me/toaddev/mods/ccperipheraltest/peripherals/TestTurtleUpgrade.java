package me.toaddev.mods.ccperipheraltest.peripherals;

import com.mojang.math.Quaternion;
import com.mojang.math.Transformation;
import com.mojang.math.Vector3f;
import dan200.computercraft.api.client.TransformedModel;
import dan200.computercraft.api.peripheral.IPeripheral;
import dan200.computercraft.api.turtle.ITurtleAccess;
import dan200.computercraft.api.turtle.ITurtleUpgrade;
import dan200.computercraft.api.turtle.TurtleSide;
import dan200.computercraft.api.turtle.TurtleUpgradeType;
import me.toaddev.mods.ccperipheraltest.CCPeripheralTest;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;

public class TestTurtleUpgrade implements ITurtleUpgrade {
    private static final ResourceLocation ID = new ResourceLocation(CCPeripheralTest.MOD_NAMESPACE, "test_upgrade");
    private static final ItemStack CRAFTING_ITEM = new ItemStack(CCPeripheralTest.TEST_PERIPHERAL_ITEM);
    private static final IPeripheral PERIPHERAL = new TestPeripheral();

    // Turtle upgrades can be tools, peripherals, or both. This simple upgrade is just a peripheral.
    @Override
    public TurtleUpgradeType getType() {
        return TurtleUpgradeType.PERIPHERAL;
    }

    // Provide our peripheral. Easy.
    @Override
    public IPeripheral createPeripheral(ITurtleAccess turtle, TurtleSide side) {
        return PERIPHERAL;
    }

    // Re-use our block model with appropriate transformation to give our upgrade visuals. Could also create and load
    // a bespoke .json model.
    @Override
    public TransformedModel getModel(ITurtleAccess iTurtleAccess, TurtleSide turtleSide) {
        float offset = turtleSide == TurtleSide.RIGHT ? 0.23f : -0.23f;

        Transformation affine = new Transformation(
                new Vector3f(offset + 0.3125f, 0.3125f, 0.28125f),
                Quaternion.ONE,
                new Vector3f(0.375f, 0.375f, 0.375f),
                Quaternion.ONE);
        return TransformedModel.of(CRAFTING_ITEM, affine);
    }

    @Override
    public ResourceLocation getUpgradeID() {
        return ID;
    }

    // This translation key is defined in the lang file. see resources/assets/cc_test/lang
    @Override
    public String getUnlocalisedAdjective() {
        return "turtle-adjective.testy";
    }

    // This method is used by Computer Craft to allow crafting the upgrade item with a turtle, and allow the turtle
    // equip command to function.
    @Override
    public ItemStack getCraftingItem() {
        return CRAFTING_ITEM;
    }
}
