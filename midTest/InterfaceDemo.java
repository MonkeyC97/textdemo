package com.monkeyc.midTest;

import java.util.Date;

public class InterfaceDemo {

    public static void main(String[] args) {
        HumanBeings houchang = new HumanBeings();
        houchang.voice();
        Dogs dogs = new Dogs();
        dogs.voice();
        Cats cats = new Cats();
        cats.voice();
    }
}
