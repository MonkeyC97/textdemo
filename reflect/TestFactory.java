package com.monkeyc.reflect;
interface IFruit{
    void eat();
}

public class TestFactory{


    public static void main(String[] args) {
        IFruit fruit = FruitFactory.getFruitInstance("com.monkeyc.reflect");
        fruit.eat();
    }
}

class FruitFactory{
    private FruitFactory(){}
    public static IFruit getFruitInstance(String className){
        try {
            Class classz = Class.forName(className);
            return (IFruit) classz.newInstance();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        throw new RuntimeException("无法生产");
    }
    class Apple implements IFruit{

        @Override
        public void eat() {
            System.out.println("吃苹果");
        }
    }
    class Orange implements IFruit{

        @Override
        public void eat() {
            System.out.println("吃橘子");
        }
    }
}