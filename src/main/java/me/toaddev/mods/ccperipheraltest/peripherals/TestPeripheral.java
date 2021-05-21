package me.toaddev.mods.ccperipheraltest.peripherals;

import dan200.computercraft.api.lua.LuaFunction;
import dan200.computercraft.api.peripheral.IPeripheral;

public class TestPeripheral implements IPeripheral {

    // Computer Craft uses reflection to auto-magically find methods annotated with @LuaFunction within an IPeripheral
    // class. See the javadoc for @LuaFunction for info on what is expected of a lua function.
    @LuaFunction
    public final String test() {
        return "Hello World!";
    }

    @Override
    public String getType() {
        return "test_peripheral";
    }

    // Every TestPeripheral instance is equivalent to every other test peripheral instance, since there is no state
    // held in this peripheral.
    @Override
    public boolean equals(IPeripheral other) {
        if(other instanceof TestPeripheral) {
            return true;
        }
        return false;
    }
}
