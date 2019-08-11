package Review.Test.Generic;

@FunctionalInterface
interface IMyMessage6<R,P>{
    R compare(P p1,P p2);
}

public class Test20 {
    public static void main(String[] args) {
        IMyMessage6<Integer,String>   message6 = String::compareTo;
        System.out.println(message6.compare("侯","姚"));
    }
}
