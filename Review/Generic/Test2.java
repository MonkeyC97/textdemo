package Review.Test.Generic;

import com.monkeyc.generic.Point;

/**
 * 使用泛型定义point类
 */
class Point1<T>{
    private T x;
    private T y;
    public Point1(){

    }
    public T getX(){
        return x;
    }
    public void setX(T x){
        this.x = x;
    }
    public T getY(){
        return y;
    }
    public void setY(T y){
        this.y = y;
    }

}

public class Test2 {
    public static void main(String[] args) {
        Point1 point1 = new Point1<>();
        point1.setX("hehe");
        point1.setY("haha");
        System.out.println("X坐标为："+point1.getX()+" "+"Y坐标为："+point1.getY());
    }
}
