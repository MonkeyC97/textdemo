package Review.Test.reflect;

class Person1{
    String name;
    int age;
    public Person1(String name,int age){
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person1{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

}

public class Test4 {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        Class<?> cls = Person1.class;
        System.out.println(cls.newInstance());//弱类型，只能调用无参构造
    }
}
