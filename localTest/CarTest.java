package localTest;

class Car {
    public void print(){
        System.out.println("我是汽车");
    }
}
class Suv extends Car{
    public void print(){
        super. print();
        System.out.println("我是路虎揽胜");
    }
}
public class CarTest{
    public static void main(String[] args) {
      new Suv().print();
    }
}