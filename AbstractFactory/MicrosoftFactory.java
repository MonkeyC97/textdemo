package com.monkeyc.AbstractFactory;

public class MicrosoftFactory implements ProductionFactory {
    @Override
    public Computer createComputer() {
        return new Surfacebook();
    }

    @Override
    public OperatingSystem createSystem() {
        return new  Windows10();
    }
}
