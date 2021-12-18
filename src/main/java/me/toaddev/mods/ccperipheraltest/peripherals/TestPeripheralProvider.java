package me.toaddev.mods.ccperipheraltest.peripherals;

import dan200.computercraft.api.peripheral.IPeripheral;
import dan200.computercraft.api.peripheral.IPeripheralProvider;
import me.toaddev.mods.ccperipheraltest.CCPeripheralTest;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

public class TestPeripheralProvider implements IPeripheralProvider {
    // In this simple case the peripheral has no state, so only one instance is needed.
    private static final IPeripheral TEST_PERIPHERAL = new TestPeripheral();

    // Computer Craft will call this method for blocks placed next to a computer or modem to find a peripheral.
    // If whatever is at blockPos is something we want to provide a peripheral for, we return the peripheral.
    // If not, return null and Computer Craft will go on to check other registered providers.
    @Override
    public IPeripheral getPeripheral(Level world, BlockPos blockPos, Direction direction) {
        BlockState blockState = world.getBlockState(blockPos);

        if(blockState.getBlock().equals(CCPeripheralTest.TEST_PERIPHERAL_BLOCK)) {
            return TEST_PERIPHERAL;
        }

        return null;
    }
}
