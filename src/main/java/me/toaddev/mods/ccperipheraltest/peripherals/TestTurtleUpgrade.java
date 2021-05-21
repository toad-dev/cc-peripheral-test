package me.toaddev.mods.ccperipheraltest.peripherals;

import dan200.computercraft.api.client.TransformedModel;
import dan200.computercraft.api.peripheral.IPeripheral;
import dan200.computercraft.api.turtle.ITurtleAccess;
import dan200.computercraft.api.turtle.ITurtleUpgrade;
import dan200.computercraft.api.turtle.TurtleSide;
import dan200.computercraft.api.turtle.TurtleUpgradeType;
import me.toaddev.mods.ccperipheraltest.CCPeripheralTest;
import net.minecraft.client.util.math.AffineTransformation;
import net.minecraft.client.util.math.Vector3f;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Quaternion;

public class TestTurtleUpgrade implements ITurtleUpgrade {
    private static final Identifier ID = new Identifier(CCPeripheralTest.MOD_NAMESPACE, "test_upgrade");
    private static final ItemStack CRAFTING_ITEM = new ItemStack(CCPeripheralTest.TEST_PERIPHERAL_ITEM);

    @Override
    public TurtleUpgradeType getType() {
        return TurtleUpgradeType.PERIPHERAL;
    }

    @Override
    public IPeripheral createPeripheral(ITurtleAccess turtle, TurtleSide side) {
        return new TestPeripheral();
    }

    @Override
    public TransformedModel getModel(ITurtleAccess iTurtleAccess, TurtleSide turtleSide) {
        float offset = turtleSide == TurtleSide.RIGHT ? 0.23f : -0.23f;

        AffineTransformation affine = new AffineTransformation(
                new Vector3f(offset + 0.3125f, 0.3125f, 0.28125f),
                Quaternion.IDENTITY,
                new Vector3f(0.375f, 0.375f, 0.375f),
                Quaternion.IDENTITY);
        return TransformedModel.of(CRAFTING_ITEM, affine);
    }

    @Override
    public Identifier getUpgradeID() {
        return ID;
    }

    @Override
    public String getUnlocalisedAdjective() {
        return "turtle-adjective.testy";
    }

    @Override
    public ItemStack getCraftingItem() {
        return CRAFTING_ITEM;
    }
}
