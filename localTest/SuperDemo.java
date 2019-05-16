package localTest;
//调用父类成员
class Circlee{
     float r = 5;
     public Circlee(float r){
         this.r = r;
     }
     public double getArea(float r){//圆面积
         return r * r * Math.PI;
     }
     public double getLong(){//圆周长
         return 2 * r * Math.PI;
     }
}
class Cylinder extends Circlee{//子类Cylinder(圆柱)
    float h = 8;

    public Cylinder(float r,float h){
        super(r);//调用父类构造方法，初始化父类成员变量r
        this.h = h;
    }
    public double getArea(){
        double d_area;//保存两个圆的面积
        double c_area;//保存圆柱侧面积
        d_area = 2 * super.getArea(r);//俩低圆面积
        c_area = super.getLong() * h;//圆柱侧面面积
        return d_area+c_area;
    }

    @Override
    public double getLong() {
        return 2 * 2 * r * Math.PI;
    }
}
public class SuperDemo{
    public static void main(String[] args) {
        Cylinder cylinder = new Cylinder(5,20);
        System.out.println((int)cylinder.getArea());
        System.out.println((int)cylinder.getLong());
    }
}




