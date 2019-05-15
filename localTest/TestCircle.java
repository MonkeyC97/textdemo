package localTest;

class Circle{
    private double radius;

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public Circle(double radius){
        this.radius = radius;
    }
    public double getArea(){//该方法用来计算圆的面积
        return radius * radius * Math.PI;
    }
    public double getPerimeter(){//计算圆的周长
        return radius * 2 * Math.PI;
    }
}

public class TestCircle {


    public static void main(String[] args) {
        Circle circle = new Circle(10);
        float r1 =(float)circle.getRadius();
        float area = (float)circle.getArea();
        float perimeter = (float)circle.getPerimeter();
        System.out.println("周长 = "+r1+"面积 = "+area+"周长"+perimeter);
    }

}