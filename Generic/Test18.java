package Review.Test.Generic;

/**
 * 方法引用
 * @param <P>
 * @param <R>
 */
@FunctionalInterface
interface IMyMessage4<P,R>{
    R switchPara(P p);
}

public class Test18 {
    public static void main(String[] args) {
        IMyMessage4<Integer,String> message4 = String::valueOf;//进行方法引用
        String str = message4.switchPara(100);//相当于调用了String.valueOf
        System.out.println(str.length());
    }
}
