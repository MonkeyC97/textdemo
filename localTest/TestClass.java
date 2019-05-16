package localTest;
/*
static静态内部类
 */



//class Outer{
//    private static String msg = "hehe";
//    static class Inner{//静态内部类的创建
//        public void print(){//定义一个普通方法
//            System.out.println(msg);
//        }
//    }
//    //在外部类中定义一个方法，该方法产生内部类对象，并且调用print方法
//    public void fun(){
//        Inner inner = new Inner();
//        inner.print();
//    }
//}
//
//public class TestClass {
//    public static void main(String[] args) {
//        Outer.Inner inner = new Outer.Inner();
//        inner.print();
//    }
//}

/*
方法内部类
 */
//定义在构造方法中的方法内部类
//class Outer{
//    private int num;
//    public Outer(int test){
//        class Inner{
//            public void fun(){
//                num++;
//                System.out.println(num);
//                System.out.println(test);
//            }
//        }
//        new Inner().fun();
//    }
//}
//
//public class TestClass{
//    public static void main(String[] args) {
//        Outer outer = new Outer(20);
//        System.out.println(outer);
//    }
//}


/*
匿名内部类
 */
class Outer{
    private int num;
    public void display(int test){
        new IMyInterface() {
            @Override
            public void test() {
                System.out.println("匿名内部类"+test);
            }
        }.test();
    }
}

public class TestClass{
    public static void main(String[] args) {
        Outer outer = new Outer();
        outer.display(20);
    }
}


