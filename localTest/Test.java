package localTest;

import java.util.Scanner;

public class Test {
    public static void main1(String[] args) {
        char c = 'A';
        int num = c;
        System.out.println(num);
    }

    public static void main2(String[] args) {
        char c = 'A';
        int num = 32 + c;
        char x = (char) num;
        System.out.println(x);
    }

    public static void main3(String[] args) {
        int x;
        double y;
        y = 2019.04;
        x = (int)y;//强制类型转换
        y = x;    //自动类型转换
        System.out.println("转换后x的值是"+x);
        System.out.println("转换后y的值是"+y);
    }

    public static void main4(String[] args) {
        byte a;
        int c;
         c = 129;
         a = (byte)c;
        System.out.println(a);
    }

    public static void main5(String[] args) {
        double x = 3.141592654;
        float y = 0.0f;
        System.out.println("转换之前的值"+x);
        y = (float)x;
        System.out.println("转换之后的值"+y);
    }

    public static void main6(String[] args) {
        int i = 10,j = 3,b = 3,c = 3,d = 3;
        if(j >= i && b++ > 3){
            i++;
        }
        if(j >= i & d++ > 3){
            j++;
        }
        System.out.println("b的值为："+b);
        System.out.println("d的值为："+d);
    }

    public static void main7(String[] args) {
        double stuGrade;
        System.out.println("请输入学生的成绩：");
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        stuGrade = Double.parseDouble(line);
        if(stuGrade >= 0 && stuGrade < 60){
            System.out.println("不及格");
        }else if(stuGrade >= 60){
            System.out.println("及格");
        }else{
            System.out.println("输入有误");
        }
    }

    public static void main8(String[] args) {
        int i = 10;
        int j = 5;
        if(i > 0){
            if(j > 0){
                System.out.println(j);
            }
            System.out.println(i);
        }
    }

    public static void main(String[] args) {
        int i = 10;
        int j = -1;
        if(i > 0){
            if(j > 0){
                System.out.println(j);
            }
            System.out.println(i);
        }
    }
}
