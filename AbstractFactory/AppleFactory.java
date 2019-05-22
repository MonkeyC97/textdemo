package com.monkeyc.AbstractFactory;

import javax.crypto.Mac;

public class AppleFactory implements ProductionFactory {
    @Override
    public Computer createComputer() {
        return new Macbook();
    }

    @Override
    public OperatingSystem createSystem() {
        return new MacOSMojave();
    }
}
