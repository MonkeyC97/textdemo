package localTest;

import java.util.Scanner;
class Person{
    String name;
    int age;
    String sex;
    public Person(){
        this.name = "houchang";
        this.age = 27;
        this.sex = "男";
    }
    public Person(String name,int age,String sex){
        this.name = name;
        this.age = age;
        this.sex = sex;
    }
}

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

    public static void main16(String[] args) {
        for(int a = 0; a < 10; a++){
            System.out.print(a);
            if(a % 2 == 0){
                continue;
            }
            System.out.println("$");
        }
    }


    public static void main17(String[] args) {
        int i = 8;
        int j = 3;
        int k = max(i,j);
        System.out.println("i和j中"+k+"是较大值");
    }
    public static void main18(String[] args) {
        int num1 = 6;
        int num2 = 8;
        System.out.println("在调用swap之前，num1 ="+num1+"  num2="+num2);
        swap(num1,num2);
        System.out.println();
        System.out.println("在调用swap之后，num1 ="+num1+"  num2="+num2);
    }
    public static void main19(String[] args) {
        System.out.println(max(3,4));
        System.out.println(max(3.0,4.0));
        System.out.println(max(3.5,4.7,5.9));
    }

    public static int max(int num1,int num2){
        if(num1 > num2){
            return num1;
        }else{
            return num2;
        }
    }
    public static double max(double num1,double num2){
        if(num1 > num2){
            return num1;
        }else{
            return num2;
        }
    }
    public static double max(double num1,double num2,double num3){
         return max(max(num1,num2),num3);
    }

    public static void swap(int n1,int n2){
        System.out.println("在调用swap之前n1 = " + n1 + "  n2=" + n2);
        //下面是交换变量n1，n2的实现过程
        int temp = n1;
        n1 = n2;
        n2 = temp;
        System.out.println("在调用swap之后n1 = "+n1+"  n2="+n2);
    }


    //例：计算十个随机数的平均值及十个随机数的平方和。
    public static void main20(String[] args) {
        int num = 0;//保存一个随机数
        double sum = 0;//保存随机数的和
        double squresum = 0;//保存随机数的平方和
        for(int i = 0; i <= 10;i++){
            num = (int) Math.round(Math.random()*1000);//生成随机数num
            System.out.println(num);

            //对随机数进行求和
            sum = sum + num;
            //对随机数的和求平方和
            squresum = squresum + Math.pow(num,2);
        }
        //对随机数的和求平均值
        double mean = sum / 10;
        System.out.println("随机数的平均值为："+ mean);
        System.out.println("随机数的平方和为："+ squresum);
    }

    public static void main21(String[] args) {
        System.out.println("请输入一个正整数：");//提示用户输入一个正整数
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println("n的阶乘为："+factorial(n));
    }
    static long factorial(int n){
        if(n == 0){
            return 1;
        }else{
            return n * factorial(n - 1);
        }
    }

    public static void main22(String[] args) {
        System.out.println("请输入一个正整数：");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println("第n个斐波那契数对应的值是："+ fib(n));
    }

    public static long fib(int n){
        if(n == 1 || n ==0){
            return 1;//停止递归调用
        }else{
            return fib(n - 1) + fib(n - 2);
        }
    }



    enum Color{
        RED,GREEN,BlUE;
    }

    public static void main23(String[] args) {
        System.out.println(Color.BlUE.name() + Color.BlUE.ordinal());
    }

    public static void main24(String[] args) {
        Person person = new Person("monkeyc",22,"男");
        System.out.println(person.sex);
        System.out.println(person.name);
        System.out.println(person.age);
    }

    public static void main25(String[] args) {
        {
            int x = 10;
            System.out.println(x);
        }
        int x =100;
        System.out.println(x);
    }
    static class Houchang{
        {
            System.out.println("构造代码块");
        }
        public Houchang(){
            System.out.println("构造方法");
        }
    }

    public static void main(String[] args) {
        new Houchang();
        new Houchang();
    }





}

