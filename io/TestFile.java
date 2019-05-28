package com.monkeyc.io;

//1.windows中 文件夹和文件名称不区分大小写
//文件路径分隔符"\"反斜杠
//路径分割符：   ;分号


//2.Linux中，文件夹和文件名称区分大小写
//文件路径分隔符：/ 正斜杠
//路径分割符：  ：冒号
//建议：

/*
   1 文件名建议小写，主观上不要用大小写区分不同的文件
   2 文件名不要出现特殊字符，空格
   3 尽量不要中文路径
*/

import java.io.File;
import java.io.IOException;

public class TestFile {
    public static void main(String[] args) {

        File file = new File("/Users/houchang/Documents/Test/Hello.java");
        try{
            boolean effect = file.createNewFile();
            if(effect){
                System.out.println("文件创建成功");
            }else{
                System.out.println("文件创建失败");
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
