package Review.Test.JVM;

/**
 * 双重加锁懒汉单例模式
 */
public class Double_Check {
    private int age;
    private String name;

    private Double_Check(){
        age = 20;
        name = "monkeyc";
    }
    private static volatile Double_Check singleton;
    public static Double_Check getInstance(){
        //线程2
        if(singleton == null){
            //只有一个线程能够进入同步代码块
            synchronized (Singleton.class){

                if(singleton == null){
                    //线程1
                    //a.堆开空间
                    //c.栈开空间指向堆内存(single != null)
                    //b.属性初始化
                    singleton = new Double_Check();//懒汉单例模式
                }
            }
        }
        return singleton;
    }
    //可能出现single.age = 20; single.name = null;
}
