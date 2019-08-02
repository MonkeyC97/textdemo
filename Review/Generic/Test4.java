package Review.Test.Generic;

/**
 * java.lang.ClassCastException异常
 * 指在两个不同类型对象在强转的时候发生错误
 */
class Point{
    private Object x;
    private Object y;

    public Object getX() {
        return x;
    }

    public void setX(Object x) {
        this.x = x;
    }

    public Object getY() {
        return y;
    }

    public void setY(Object y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}

public class Test4 {
    public static void main(String[] args) {
        Point point = new Point();
        point.setX(123);
        point.setY(456);
        String x = (String) point.getX();
        String y = (String) point.getY();
        System.out.println(x+y);
    }
}
