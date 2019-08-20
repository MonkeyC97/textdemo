package Review.Test.reflect;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.InputStream;

//自定义类加载器
class MyClassLoader extends ClassLoader{
    /**
     * 实现一个自定义的类加载器、传入类名称、通过指定路径加载
     * @param className 类名称
     * @return 返回的Class对象
     * @throws Exception
     */
    public Class<?> loadData(String className) throws Exception{
        byte[] classData = this.loadClassData();
        return super.defineClass(className,classData,0,classData.length);
    }
    /**
     * 通过指定的文件路径进行类的文件加载，实际上就是进行二进制文件读取
     * @return 类文件数据
     * @throws Exception
     */
    private byte[] loadClassData() throws Exception{
        InputStream input = new FileInputStream("/Users/houchang/Desktop/Member.class");
        //取得所有字节内容，放到内存中
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        //读取缓冲区
        byte[] data = new byte[20];
        int temp = 0;
        while((temp = input.read(data))!= -1){
            bos.write(data,0,temp);
        }
        byte[] result = bos.toByteArray();
        input.close();
        bos.close();
        return result;
    }
}

public class Test14{
    public static void main(String[] args) throws Exception {
        Class<?> cls = new MyClassLoader().loadData("Member");
        System.out.println(cls.getClassLoader());
        System.out.println(cls.getClassLoader().getParent());
        System.out.println(cls.getClassLoader().getParent().getParent());
        System.out.println(cls.newInstance());
    }
}
