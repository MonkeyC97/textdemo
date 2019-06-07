package com.monkeyc.DataStructure.HeadSingleList;

public class TestHeadSingleList {
    public static void main(String[] args) {
        HeadSinglelist headSinglelist = new HeadSinglelist();
        headSinglelist.addFirst(2);
        headSinglelist.addFirst(3);
        headSinglelist.addFirst(4);
        headSinglelist.addLast(1);
        headSinglelist.addLast(0);
        headSinglelist.addLast(0);
        headSinglelist.addLast(0);

//        headSinglelist.display();
        System.out.println(headSinglelist.isEmpty());
        System.out.println(headSinglelist.getLength());
        System.out.println(headSinglelist.contains(2));
        headSinglelist.remove(2);//有问题
        headSinglelist.removeAllKey(0);
        headSinglelist.display();
//        headSinglelist.clear();
//        headSinglelist.display();




    }
}
