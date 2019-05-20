
package com.monkeyc.midTest;
//早期实现任意整数的加和只能通过整数来完成
//public class MidTest {
//    public static void main(String[] args) {
//        System.out.println(add(new int[]{1,2,3}));
//        System.out.println(add(new int[]{1,2,3,4,5,6,7,8,9,10}));
//    }
//    public static int add(int[] data){
//        int result = 0;
//        for(int i = 0; i < data.length;i++){
//            result = data[i] + result;
//        }
//        return result;
//    }
//}


//可变参数实现上面的代码
// public class MidTest{
//    public static void main(String[] args) {
//        System.out.println(add(1,2,3,4));
//        System.out.println(add(new int[]{1,2,3,4,5}));
//    }
//    public static int add(int...data){//可变参数其实还是一个数组
//        int result = 0;
//        for(int i = 0;i < data.length;i++){//data有长度
//            result = result+data[i];
//        }
//        return result;
//    }
//}



/*
多类参数的传递，如果有多类参数，但是只能有一个可变参数，而且要放在参数顺序的最后
 */

//public class MidTest{
//    public static void main(String[] args) {
//        System.out.println(add("hello"));
//        System.out.println(add("hello",1,2,3,4));
//        System.out.println(add("hello",new int[]{1,2,3,4}));
//    }
//    public static int add(String msg,int ... data){
//        int result = 0;
//        for(int i = 0; i < data.length; i++){
//            result = result + data[i];
//        }
//        return  result;
//    }
//}




/*
for each 循环
 */
//public class MidTest{
//    public static void main(String[] args) {
//        int[] data = new int[]{1,2,3,4,5,6,7,8,9,10};
//         for (int tmp : data) {//把data的每个值都赋给了临时变量tmp
//            System.out.println(tmp);
//        }
//    }
//}

/*
泛型问题引出
 */

//class Point{
//    private Object x;
//    private Object y;
//
//    public Object getX() {
//        return x;
//    }
//
//    public void setX(Object x) {
//        this.x = x;
//    }
//
//    public Object getY() {
//        return y;
//    }
//
//    public void setY(Object y) {
//        this.y = y;
//    }
//}

//public class MidTest{
//    public static void main(String[] args) {
//        Point point = new Point();
//        point.setX(20);//自动装箱并向上转型为Object类
//        int y = (Integer) point.getX();//向下转型并且拆箱
//        point.setY(10);
//        int x = (Integer) point.getY();
//        System.out.println(x);
//        System.out.println(y);
//
//        //设置字符串
//        Point point1 = new Point();
//        point1.setX("东纬10度");
//        point1.setY("西经20度");//自动装箱并且向上转型为Object类
//        String x1 = (String)point1.getX();//强转拆箱
//        String y1 = (String)point1.getY();
//        System.out.println(x1);
//        System.out.println(y1);
//
//        //问题的出现
//        Point point2 = new Point();
//        point2.setX(10.0);//double型
//        point2.setY("西经20度");//String型
//        String x2 = (String) point2.getX();//接收方并不知道x已经被设置为了double型，依旧将get强转为String型会出现ClasscastException错误
//        String y2 = (String)point2.getY();
//        System.out.println(x2);
//        System.out.println(y2);
//        System.out.println(x1);
//    }
//}

/*
泛型方法与泛型类并存
 */

//class MyTest<T>{
//    public void test1(T t){
//        System.out.println(t);
//    }
//    public <T> T test2(T t){
//        return t;
//    }
//}
//public class MidTest{
//    public static void main(String[] args) {
//        MyTest<Integer> myTest = new MyTest<>();
//        myTest.test1(12);
//        Integer i = myTest.test2(10);
//        System.out.println(i);
//    }
//}

/*

泛型方法与泛型类并存

 */
//class Myclass<T>{
//
//    public  void testMethod(T t){
//        System.out.println(t);
//    }
//
//    public <E> E testMesthod1(E e){
//        return e;
//    }//泛型方法始终以自己定义的类型参数为准
//}
//public class MidTest{
//    public static void main(String[] args) {
//        Myclass<String> myclass = new Myclass<>();
//        myclass.testMethod("hello "+"world");
//        Integer integer = myclass.testMesthod1(20);
//        System.out.println(integer);
//    }
//}
//
//class Message <T>{
//
//    private T message;
//
//    public T getMessage() {
//        return message;
//    }
//    public void setMessage(T message) {
//        this.message = message;
//    }
//}
//public class MidTest{
//    public static void main(String[] args) {
//        Message<String> message  = new Message<>();
//        message.setMessage("hello");
//        fun(message);
//    }
//    public static void fun(Message<String> temp){
//
//        System.out.println(temp.getMessage());
//
//    }
//}



//class OilFish{
//    //水煮鱼做法
//    void OilMake(){
//        prepared();
//        boilWater();
//        boilFish();
//        putGreen();
//    }
//    public void prepared(){//准备食材
//        System.out.println("准备鱼和青菜");
//    }
//    public void boilWater(){
//        System.out.println("把水烧开");
//    }
//    public void boilFish(){
//        System.out.println("煮鱼");
//    }
//    public void putGreen(){
//        System.out.println("放青菜");
//    }
//}
//public class MidTest{
//    public static void main(String[] args) {
//       OilFish oilFish =  new OilFish();
//       oilFish.OilMake();
//    }
//}





/*
模版设计模式（做鱼）
*/

//
//import java.util.Scanner;
//
//abstract class FishMake{//抽象类"做鱼"
//
//    final void fishmake(){ //用final修饰的方法，子类不能覆盖
//
//        prepare();
//        boilWater();
//        boilFish();
//        if(customerWantsCondiments()){
//            addCondiments();
//        }
//    }
//    public void prepare(){
//        System.out.println("准备食材");
//    }
//    public void boilWater(){
//        System.out.println("烧水");
//    }
//    public void boilFish(){
//        System.out.println("煮鱼");
//    }
//    abstract void addCondiments();
//
//    boolean customerWantsCondiments(){//钩子方法
//        return true;
//    }
//}
//
//class SourFish extends FishMake{
//
//    @Override
//    void addCondiments() {
//        System.out.println("加酸菜");
//    }
//}
//class OilFish extends FishMake{
//
//    @Override
//    void addCondiments() {
//        System.out.println("加青菜");
//    }
//
//    public boolean customerWantsCondiments(){//覆盖父类中的钩子方法
//       String answer = getUserInput();
//       if(answer.equals("y")){
//           return true;
//       }else{
//           return false;
//       }
//   }
//   private String getUserInput(){
//       String answer = null;
//       System.out.println("您想要在水煮鱼中加青菜吗(y/n)");
//       Scanner scanner = new Scanner(System.in);
//       answer = scanner.nextLine();
//       return answer;
//   }
//}
//
//public class MidTest{
//    public static void main(String[] args) {
//       FishMake sourFish = new SourFish();
//       FishMake oilFish = new OilFish();
//        System.out.println("sourfish Making...");
//        sourFish.fishmake();
//        System.out.println("oilfish Making...");
//        oilFish.fishmake();
//    }
//}

import java.util.Scanner;

//import java.util.Scanner;
//
////抽象父类
//abstract  class FishMake{
//    final void Makefish(){
//        prepareRecipe();
//        boilWater();
//        boilFish();
//        if(customerWantsAddRecipe()){
//            addCondiments();
//        }
//    }
//    void prepareRecipe(){
//        System.out.println("准备食材");
//    }
//    void boilWater(){
//        System.out.println("把水烧开");
//    }
//    void boilFish(){
//        System.out.println("煮鱼");
//    }
//
//    abstract void addCondiments();
//    boolean customerWantsAddRecipe(){
//        return true;
//    }
//}
//class SourFish extends FishMake{
//
//    @Override
//    void addCondiments() {
//        System.out.println("加酸菜");
//    }
//}
//class OilFish extends FishMake{
//
//    @Override
//    void addCondiments() {
//        System.out.println("加青菜或者雪菜");
//    }
//    public boolean customerWantsAddRecipe(){
//        String answer = getInput();
//        if(answer.equals("y")){
//            return true;
//        }else{
//            return false;
//        }
//    }
//    private String getInput(){
//        String answer = null;
//        System.out.println("您要在水煮鱼中加青菜吗y/n");
//        Scanner scanner = new Scanner(System.in);
//        answer = scanner.nextLine();
//        return answer;
//    }
//}
//
//public class MidTest{
//    public static void main(String[] args) {
//        FishMake sourfish = new SourFish();
//        FishMake oilfish = new OilFish();
//        System.out.println("酸菜鱼Making");
//        sourfish.Makefish();
//        System.out.println("水煮鱼Making");
//        oilfish.Makefish();
//    }
//
//}
//abstract class FishMake{
//    void MakeFish(){
//        prepared();
//        boilWater();
//        boilFish();
//        if(customerWantToAddCondiment()){
//            addcondiment();
//        }
//    }
//    public void prepared(){
//        System.out.println("准备食材");
//    }
//    public void boilWater(){
//        System.out.println("把水煮开");
//    }
//    public void boilFish(){
//        System.out.println("把鱼煮熟");
//    }
//    abstract void addcondiment();
//
//    boolean customerWantToAddCondiment(){
//        return true;
//    }
//}
//class SourFish extends FishMake{
//    @Override
//    void addcondiment() {
//        System.out.println("加酸菜");
//    }
//}
//class OilFish extends FishMake{
//
//
//    @Override
//    void addcondiment() {
//        System.out.println("加青菜");
//    }
//
//    private String getInput(){
//        String answer = null;
//        System.out.println("您要在水煮鱼中加青菜吗y/n");
//        Scanner scanner = new Scanner(System.in);
//        answer = scanner.nextLine();
//        return answer;
//    }
//
//    @Override
//    boolean customerWantToAddCondiment() {
//        String answer = getInput();
//        if (answer.equals("y")){
//            return true;
//        }else{
//            return false;
//        }
//    }
//}
//public class MidTest{
//    public static void main(String[] args) {
//       FishMake sourFish = new SourFish();
//       FishMake oilFish = new OilFish();
//       sourFish.MakeFish();
//       oilFish.MakeFish();
//    }
//}

//先写一个模版设计模式

//抽象类  鱼的做法
abstract class FishMake{

        void MakeFish(){
            prepare();
            oilWater();
            oilFish();
            if (customerWantToAddRecipe()){
                addCondiment();
            }
        }

    public void prepare(){
        System.out.println("准备食材");
    }
    public void oilWater(){
        System.out.println("把水煮开");
    }
    public void oilFish(){
        System.out.println("把鱼煮熟");
    }
    abstract void addCondiment();
    boolean customerWantToAddRecipe(){
        return true;
    }
}
class SourFish extends FishMake{

    @Override
    void addCondiment() {
        System.out.println("加酸菜");
    }


}
class OilFish extends FishMake{

    @Override
    void addCondiment() {
        System.out.println("加青菜");
    }

    @Override
    boolean customerWantToAddRecipe() {
       String answer = getInput();
       if(answer.equals("y")){
           return true;
       }else{
           return false;
       }
    }

    private String getInput(){
        String answer = null;
        System.out.println("您要在水煮鱼中加青菜吗？y/n");
        Scanner scanner = new Scanner(System.in);
        answer = scanner.nextLine();
        return answer;
    }
}

public class MidTest{
    public static void main(String[] args) {
        FishMake fishMake = new SourFish();
        fishMake.MakeFish();
        FishMake fishMake1 = new OilFish();
        fishMake1.MakeFish();
    }
}

