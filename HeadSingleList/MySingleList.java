package git.com.test1;

import java.sql.SQLOutput;

public class MySingleList implements ILinked {
//    class Node{
//        private int data;
//        private Node next;
//        public Node(){
//            this.data = -1;
//        }
//        public Node(int data){
//            this.data = data;
//        }
//    }
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
//    private Node head;
//
//    public MySingleList(){
//        this.head = new Node();
//        this.head.next = this.head;
//    }
     private Node head;
     public MySingleList(){
        this.head = new Node();//实例化一个头节点
        this.head.next = this.head;//头的下一个节点就是它自己所以是循环的
    }



//    @Override
//    public void addFirst(int data) {
//        Node node = new Node(data);
//        node.next = this.head.next;
//        this.head.next = node;
//    }
    public void addFirst(int data){
         Node node = new Node(data);
         this.head.next = node;
         node.next = this.head.next;
    }

//    @Override
//    public void addLast(int data) {
//        Node node = new Node();
//        Node cur  = this.head;
//        while(cur.next != this.head) {
//            cur = cur.next;
//        }
//                cur.next = node;
//                node.next = this.head;
//        }


    @Override
    public void addLast(int data){
         Node node = new Node();
         Node cur = this.head;
         while(cur.next != this.head){
             cur = cur.next;
         }
          cur.next = node;
          node.next = this.head;
    }




//    private void checkIndex(int index){
//        if(index < 0 || index > getLength()){
//            throw new UnsupportedOperationException("index不合法");
//        }
//    }






    private void checkIndex(int index){
         if(index < 0 && index >getLength()){
             throw new UnsupportedOperationException("index不合法");
         }
    }

//    private Node searchIndex(int index){
//        checkIndex(index);
//        Node cur = this.head;
//        for(int i = 0;i < index;i++){
//            cur = cur.next;
//        }return cur;
//    }

    private Node searchIndex(int index){
         checkIndex(index);
         Node cur = this.head;
         for(int i = 0;i < index;i++){
             cur = cur.next;
         }
         return cur;
    }

//    private Node searchPre(int key){
//        Node pre = this.head;
//        while(pre.next != this.head){
//            if(pre.next.data == key) {
//
//                return pre;
//            }
//            pre = pre.next;
//        }
//        return pre;
//    }
    private Node searchPre(int key){
         Node pre = this.head;
         while(pre.next != this.head){
             if(pre.next.data == key){
                 return pre;
             }
             pre = pre.next;
         }
         return pre;
    }

//    @Override
//    public int remove(int key) {
//        Node pre = searchPre(key);
//        if(pre == null) {
//            throw new UnsupportedOperationException("有误");
//        }
//        Node del = pre.next;
//        int oldData =  del.data;
//        pre.next = del.next;
//        return oldData;
//    }
    public int remove(int key){
         Node pre = searchPre(key);
         if(pre == null){
             throw new UnsupportedOperationException("pre不存在");
         }
         Node del = pre.next;
         int oldData = del.data;
         pre.next = del.next;
         return oldData;
    }


//
//    @Override
//    public void removeAllKey(int key) {
//        Node pre = this.head;
//        Node cur = this.head.next;
//        while(cur != this.head){
//            if(cur.data == key){
//                pre.next = cur.next;
//                cur = cur.next;
//            }
//            pre = cur;
//            cur = cur.next;
//        }
//        return;
//    }
    public void removeAllKey(int key){
         Node pre = this.head;
         Node cur = this.head.next;
         while(cur != this.head){
             if(cur.data == key){
                 pre.next = cur.next;
             }
             pre = pre.next;
             cur = cur.next;
         }
    }
    @Override
    public int getLength() {
        int count = 0;
        Node cur = this.head.next;
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
    while(this.head.next !=this.head){
        Node cur = this.head.next;
        this.head.next = cur.next;
    }


        this.head = null;
    }


    public boolean addIndex(int index,int data){
        if(index == 0){
            addFirst(data);
        }
        Node cur = searchIndex(index);
        Node node = new Node();
        while(cur != this.head){
                node.next = cur.next;
                cur.next = node;
        }

    return true;
    }
    public boolean contains(int key){
        if(getLength() == 0){
            return false;
        }
        Node cur = this.head.next;
        while(cur != head){

            if(key == cur.data){
                return true;
            }
            cur = cur.next;
        }
        return false;
    }
}
