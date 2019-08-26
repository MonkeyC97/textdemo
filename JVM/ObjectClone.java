package Review.Test.JVM;

/**
 * 浅拷贝

class Techer {
    private Integer age;
    private String name;
}
class Student implements  Cloneable{//搭上标记可以支持克隆
    private Integer age;
    private String name;
    private Techer techer;

    public Student clone(){
       Student stu = null;
        try {
            stu = (Student) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return stu;
    }
}

public class ObjectClone {
    public static void main(String[] args) {

    }
}

 */

import java.io.Serializable;

/**
 * 深拷贝
 */
class Techer implements Serializable {
    private Integer age;
    private String name;
}
class Student implements Serializable{//搭上标记可以支持克隆
    private Integer age;
    private String name;
    private Techer techer;

}

public class ObjectClone {
    public static void main(String[] args) {

    }
}

