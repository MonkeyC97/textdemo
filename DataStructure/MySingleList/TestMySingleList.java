package com.monkeyc.DataStructure.MySingleList;

public class TestMySingleList {
    public static void main(String[] args) {
        MySingleList singleList = new MySingleList();
        singleList.addFirst(3);
        singleList.addFirst(2);
        singleList.addFirst(1);
        singleList.addLast(4);
        singleList.addLast(5);
        singleList.addLast(6);
//        singleList.display();
        singleList.addIndex(4,10);
        singleList.addIndex(4,20);
        singleList.addIndex(4,20);
        singleList.addIndex(4,20);
        singleList.addIndex(4,20);
//        singleList.display();
        singleList.remove(1);
        System.out.println(singleList.contains(7));
        System.out.println(singleList.contains(20));
//        singleList.removeAllKey(20);
        System.out.println(singleList.getLength());
//        singleList.clear();
        singleList.display();
    }
}
