package com.monkeyc.DataStructure.HeadSingleList;
/**
 *带头循环单链表
 */

public class HeadSinglelist implements IHeadLinked {

    class Node{
        private Node next;
        private int data;
        public Node(){
            this.data = -1;
        }
        public Node(int data){
            this.data = data;
        }

    }

    private Node head;

    public HeadSinglelist(){
        this.head = new Node();//带头所以实例化一个头节点
        this.head.next = this.head;//头节点的下一个节点就是自己所以是循环的
    }


    @Override
    public void addFirst(int data) {
        Node node = new Node(data);
        node.next = this.head.next;
        this.head.next = node;
    }

    @Override
    public void addLast(int data) {
//        Node cur = this.head;
//        Node node = new Node(data);
//        while(cur != this.head){
//            cur = cur.next;
//        }
//        cur.next = node;
//        node.next = this.head;
        Node node = new Node(data);
        Node cur = this.head;
        while(cur.next!= this.head){
            cur = cur.next;
        }
        cur.next = node;
        node.next = this.head;

    }

    public void checkIndex(int index){
        if(index < 0 || index > getLength()){
            throw new UnsupportedOperationException("index不合法");
        }
    }

    public Node searchIndex(int index){
        Node cur = this.head;
        for(int i = 0;i < index;i++){
            cur = cur.next;
        }
        return cur;
    }

    @Override
    public boolean addindex(int index, int data) {
        checkIndex(index);
        if(isEmpty()){
            addFirst(data);
        }
        Node cur  = searchIndex(index);
        Node node = new Node();

        while(cur != this.head){
            node.next = cur.next;
            cur.next = node;
        }
        return true;
    }

    @Override
    public boolean contains(int key) {
        if(isEmpty()){
            return false;
        }
        Node cur = this.head.next;//值得注意
        while(cur != null){
            if(cur.data == key){
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    public Node searchPre(int key){
        Node pre = this.head;
        while(pre.next != this.head){
            if(pre.next.data == key){
                return pre;
            }else{
                pre = pre.next;
            }
        }
        return pre;
    }
    @Override
    public int remove(int key) {
        Node pre = searchPre(key);
        Node del = pre.next;
        if(pre == null){
            throw new UnsupportedOperationException("key不存在");
        }
        int oldData = del.data;
        pre.next = del.next;
        return oldData;
    }

    @Override
    public void removeAllKey(int key) {

        Node pre = this.head;
        Node cur = pre.next;
        while(cur != this.head){
            if(cur.data == key){
                pre.next = cur.next;
                cur = cur.next;
            }else{
                pre = pre.next;
                cur = cur.next;
            }
        }
    }

    @Override
    public int getLength() {
        Node cur = this.head.next;
        int count = 0;
        while(cur != this.head){
            cur = cur.next;
            count++;
        }
        return count;
    }

    @Override
    public void display() {
        Node cur = this.head.next;
        while(cur != this.head){
            System.out.println(cur.data+" ");
            cur = cur.next;
        }
    }

    @Override
    public void clear() {
        Node cur = this.head.next;
        while(cur != this.head){
            this.head.next = cur.next;
        }
        this.head = null;
    }

    public boolean isEmpty(){
        return this.head == null;
    }
}
