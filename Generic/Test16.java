package Review.Test.Generic;

interface IMymessage3{
    void print();
}
public class Test16 {

    static IMymessage3 mymessage3 =()-> System.out.println("MyMessage");
    public static void main(String[] args) {
        mymessage3.print();
    }
}
