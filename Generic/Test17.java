package Review.Test.Generic;

@FunctionalInterface
interface IMath{
     int add(int a,int b);
}

public class Test17 {
    public static void main(String[] args) {
        IMath math = (p1,p2) ->(p1+p2);
        System.out.println(math.add(20,30));
    }

}
