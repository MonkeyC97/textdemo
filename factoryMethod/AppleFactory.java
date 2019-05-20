package com.monkeyc.factoryMethod;

public class AppleFactory implements ComputerFactory {
    @Override
    public Computer createComputer() {
        return new MacbookComputer();
    }
}
