package localTest;

class Circle1{
    private double radius;
    private static int numOfObject;
    public Circle1(){
        this.radius = 1;
    }
    public Circle1(double radius){
        this.radius = radius;
    }
    public void setRadius(double radius){
        this.radius = radius;
    }
    public double getRadius(){
        return radius;
    }
    public static int getNumOfObjects(){
        return numOfObject;
    }

}

public class TestVariable {

    public static void printCircle(Circle1 circle1){
        System.out.println("半径("+circle1.getRadius()+")和对象数("+circle1.getNumOfObjects()+")");
    }

    public static void main(String[] args) {
        Circle1 circle1 = new Circle1();
        System.out.println("c1是：");
        printCircle(circle1);//在创建circle2之前显示circle1
        Circle1 circle2 = new Circle1(5);
        circle1.setRadius(10);
        //在c2创建之后，显示c1 和 c2
        System.out.println("\n在创建了c2并将c1的半径改为10之后");
        System.out.println("c1是 ： ");
        printCircle(circle1);
        System.out.println("c2是 ： ");
        printCircle(circle2);
    }



}
