package Review.Test.JVM;

class Father{
    public int hehe(int a){
        return 1;
    }
}
class Son extends Father{
    public int hehe(int a){
        return 0;
    }
}

public class Test{
    public static void main(String[] args) {
        Son son = new Son();
        System.out.println(son.hehe(1));

    }

}
