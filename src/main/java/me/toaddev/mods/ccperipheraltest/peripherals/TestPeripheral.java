package me.toaddev.mods.ccperipheraltest.peripherals;

import dan200.computercraft.api.lua.LuaFunction;
import dan200.computercraft.api.peripheral.IPeripheral;

public class TestPeripheral implements IPeripheral {

    @LuaFunction
    public final String test() {
        return "Hello World!";
    }

    @Override
    public String getType() {
        return "test_peripheral";
    }

    @Override
    public boolean equals(IPeripheral other) {
        if(other instanceof TestPeripheral) {
            return true;
        }
        return false;
    }
}
