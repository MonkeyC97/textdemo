package com.monkeyc.factoryMethod;

public class MicroSoftFactory implements ComputerFactory {
    @Override
    public Computer createComputer() {
        return new SurfacebookComputer();
    }
}
