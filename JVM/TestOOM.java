package com.monkeyc.JVM;

import java.util.ArrayList;
import java.util.List;

public class TestOOM {
    static class OOMObject{

    }
    public static void main(String[] args) {
        List<OOMObject> list = new ArrayList<>();
        while(true){
            list.add(new OOMObject());
        }
    }
}
