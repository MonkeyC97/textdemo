package com.monkeyc.DataStructure.MySingleList;

public class MySingleList implements ILinked {
    class Node{
        private int data;
        private Node next;
        public Node(){
            this.data = -1;
        }

        public Node(int data){
            this.data = data;
        }
        public Node getNext(){
            return next;
        }

    }
    private Node head;
    int size;
    public MySingleList(Node head,int size){
        this.head = null;
        this.size = 0;
    }
    public MySingleList(){

    }



    @Override
    public void addFirst(int data) {
        Node node = new Node(data);
        if(this.head == null){
            this.head = node;
            size++;
        }else{
            node.next = this.head;
            this.head = node;
            size++;
        }
    }

    @Override
    public void addLast(int data) {
        Node node = new Node(data);
        Node cur = this.head;
        if(this.head == null){
           this.head = node;
           this.size++;
        }
        while(cur.next != null){
            cur = cur.next;
        }
        cur.next = node;
        size++;
    }

    public boolean checkIndex(int index){
        if(index < 0 || index > this.size){
            throw new UnsupportedOperationException("index有误");
        }else{
            return true;
        }
    }

    public Node searchIndex(int index){
        Node cur = this.head;
        while (index - 1 > 0){
            cur = cur.next;
            index--;
        }
        return cur;
    }

    @Override
    public boolean addIndex(int index, int data) {
        checkIndex(index);
        Node node = new Node(data);
        if(index==0){
            addFirst(data);
            this.size++;
            return true;
        }
        Node cur = searchIndex(index);

            node.next = cur.next;
            cur.next = node;
            /**
             * 如果上述程序顺序相反，则会出现死循环
             */

        return true;
    }

    @Override
    public boolean contains(int key) {
        Node cur = this.head;
        while(cur != null){
            if(cur.data==key){
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    public Node searchPre(int key){
        Node pre = this.head;
        if(pre.data == key){
            return this.head;
        }else{
            while(pre.next != null){
                if(pre.next.data == key){
                    return pre;
                }
                pre = pre.next;
            }
        }
        return null;
    }
    @Override
    public int remove(int key) {
        Node pre = searchIndex(key);
        int oldData = 0;
        if(pre == null){
            throw new UnsupportedOperationException("key前驱不存在");
        }
        if(pre==this.head&&pre.data==key){
            oldData = this.head.data;
            this.head = this.head.next;
            return oldData;
        }else{
            Node del = pre.next;
            oldData = del.data;
            pre.next = del.next;
            return oldData;
        }
    }

    @Override
    public void removeAllKey(int key) {
        if(this.head.data == key){
            this.head = this.head.next;
        }
        Node pre = this.head;
        Node cur = pre.next;
        while(cur != null){
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
        int count = 0;
        Node cur = this.head;
        while(cur != null){
            cur = cur.next;
            count++;
        }
        return count;
    }

    @Override
    public void display() {
        Node cur = this.head;
        while(cur != null){
            System.out.println(cur.data);
            cur = cur.next;
        }
    }

    @Override
    public void clear() {
        this.head = null;
    }
}
