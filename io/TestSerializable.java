package com.monkeyc.io;

import java.io.*;
import java.util.Date;
//序列化
public class TestSerializable {
    public static void main1(String[] args) {
        Person person = new Person();
        person.setAge(23);
        person.setName("monkey");
        person.setGetSkills(new String[]{"c++", "Java"});
        person.setBirthday(new Date());
        try {
            ObjectOutputStream oout = new ObjectOutputStream(new FileOutputStream("/Users" + File.separator + "houchang" + File.separator + "Desktop" + File.separator + "祝好" + File.separator + "Person.data"));
            oout.writeObject(person);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //反序列化（实例化对象第三种方法）
    public static void main(String[] args) {
        File file = new File("/Users" + File.separator + "houchang" + File.separator + "Desktop" + File.separator + "祝好" + File.separator + "Person.data");
        try(ObjectInputStream oin = new ObjectInputStream(new FileInputStream(file))){
            try{
                Object object = oin.readObject();
                Person person = (Person) object;
                System.out.println(person);
            }catch (ClassNotFoundException e)
            {
                e.printStackTrace();
            }

        }catch (IOException e){
            e.printStackTrace();
        }

    }
}

