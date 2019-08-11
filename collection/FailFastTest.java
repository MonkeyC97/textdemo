package Review.Test.collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * fail-fast问题
 */
public class FailFastTest {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        //1
        list.add("helo");
        //2
        list.add("wrd");
        //3
        list.add("hello");
        //4
        list.add("Java");
        //迭代器模式
        //expectedModCount = modCount = 4
        Iterator<String> iterator = list.iterator();
        while(iterator.hasNext()){
            //thr fail-fast
            String str = iterator.next();
            if(str.equals("wrd")){
                //修改了list的结构
                //产生ConcurrentModificationException异常说明这个集合已经有人改过，其实不允许改
                //modCount = 5
                list.remove("wrd");
            }
            System.out.println(str);
        }
    }
}
