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

    public static void main9(String[] args) {
        int i = 10;
        int j = -1;
        if(i > 0){
            if(j > 0){
                System.out.println(j);
            }
            System.out.println(i);
        }
    }

    public static void main10(String[] args) {
        int moneyType;
        System.out.println("请输入币种：1人民币 2美元 3越南盾");
        Scanner scanner = new Scanner(System.in);
        moneyType = scanner.nextInt();
        switch (moneyType){
            case 1:
                System.out.println("人民币");

            case 2:
                System.out.println("美元");

            case 3:
                System.out.println("越南盾");


                default: //默认值
                     System.out.println("人民币");
                 break;
        }
    }
    //10的阶乘
    public static void main11(String[] args) {
        int i = 1;
        int result = 1;
        for(;i < 11;i++){
            result *= i;
        }
        System.out.println("10的阶乘是："+result);
    }

    //乘法口诀
    public static void main12(String[] args) {

        for(int i = 1;i <= 9;i++){

            for(int j = 1;j <= i; j++){
                System.out.print( j+"x"+i+ "="+ i * j+"\t");
            }
            System.out.println();
        }
    }
    //10个斐波那契数
    public static void main13(String[] args) {
        int[] str = new int[10];

        int i = 2;
        System.out.println(str[0] = 1);
        System.out.println(str[1] = 1);
        for(; i < str.length;i++){

            str[i] = str[i - 1] + str[i - 2];
            System.out.println(str[i]);
        }
    }
        //求 1-100之间所有整数的和
    public static void main14(String[] args) {
        int result = 0;
        int i = 1;
        while(i <= 100){
            result += i;
            i++;
        }
        System.out.println(result);
    }

    public static void main15(String[] args) {
        for(int i = 0; i < 5 ;i++){
            for(int j = i; j < 5;j++){
                System.out.print("$");
            }
            System.out.print("&");
        }
    }

    public static void main(String[] args) {
        for(int a = 0; a < 10; a++){
            System.out.print(a);
            if(a % 2 == 0){
                continue;
            }
            System.out.println("$");
        }
    }
}

