package com.monkeyc.AbstractFactory;

public interface ProductionFactory {
    Computer createComputer();
    OperatingSystem createSystem();
}
