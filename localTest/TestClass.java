package localTest;

class Outer{
    private static String msg = "hehe";
    static class Inner{//内部类
        public void print(){//定义一个普通方法
            System.out.println(msg);
        }
    }
    //在外部类中定义一个方法，该方法产生内部类对象，并且调用print方法
    public void fun(){
        Inner inner = new Inner();
        inner.print();
    }
}

public class TestClass {
    public static void main(String[] args) {
        Outer.Inner outer = new Outer.Inner();
        outer.print();
    }
}
