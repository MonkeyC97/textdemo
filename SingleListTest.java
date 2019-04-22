package git.com;

public class SingleListTest {
    class Node{
        private Node next;
        private int data;
        public Node(int data){
            this.data = data;
        }
    }
    private Node head;
    public SingleListTest(){
        this.head = head;
    }
    public void addFirst(int data){
        Node node = new Node(data);
        if(this.head == null) {
            this.head = node;
        }else{
            node.next = this.head;
            this.head = node;
        }
    }
    // 编写代码，以给定值x为基准将链表分割成两部分，所有小于x的结点排在大于或等于x的结点之前
    public Node partition(int x) {
        Node beforeStart = null;
        Node beforeEnd = null;
        Node afterStart = null;
        Node afterEnd = null;
        //pHead:用来遍历原有的单链表
        Node pHead = this.head;
        while(pHead != null) {
            Node pHeadNext = pHead.next;
            pHead.next = null;
            if(pHead.data < x) {
                if(beforeStart == null) {
                    beforeStart = pHead;
                    beforeEnd = beforeStart;
                }else {
                    beforeEnd.next = pHead;
                    beforeEnd = pHead;
                }
            }else {//>=x
                if(afterStart == null) {
                    afterStart = pHead;
                    afterEnd = afterStart;
                }else {
                    afterEnd.next = pHead;
                    afterEnd = pHead;
                }
            }
            pHead = pHeadNext;
        }
        //原来的单链表走完了
        if(beforeStart == null) {
            return afterStart;
        }
        beforeEnd.next = afterStart;
        return beforeStart;
    }
    public void display() {
        Node cur = this.head;
        while(cur != null) {
            System.out.print(cur.data+" ");
            cur = cur.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        SingleListTest singleListTest = new SingleListTest();
        singleListTest.addFirst(1);
        singleListTest.addFirst(5);
        singleListTest.addFirst(9);
        singleListTest.addFirst(100);
        singleListTest.addFirst(2);
        singleListTest.addFirst(90);
        singleListTest.addFirst(4);
        singleListTest.partition(5);
        singleListTest.display();
    }
    //打印结果为 4 2 1 90 100 9 5
}
