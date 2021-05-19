package me.toaddev.mods.ccperipheraltest.peripherals;

import dan200.computercraft.api.peripheral.IPeripheral;
import dan200.computercraft.api.peripheral.IPeripheralProvider;
import me.toaddev.mods.ccperipheraltest.CCPeripheralTest;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;

public class TestPeripheralProvider implements IPeripheralProvider {
    @Override
    public IPeripheral getPeripheral(World world, BlockPos blockPos, Direction direction) {
        BlockState blockState = world.getBlockState(blockPos);

        if(blockState.getBlock().is(CCPeripheralTest.TEST_PERIPHERAL_BLOCK)) {
            return new TestPeripheral();
        }

        return null;
    }
}
