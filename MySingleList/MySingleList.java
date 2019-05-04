package git.com.MySingleList;

public class MySingleList implements ILinked {

    class Node {
        private int data;
        public Node next;

        public Node(int data) {
            this.data = data;
        }

        public Node getNext() {
            return next;
        }

        public int getData() {
            return data;
        }
    }


    private Node head;

    public Node getHead() {
        return head;
    }

    private int size;

    public MySingleList() {
        this.head = null;
        this.size = 0;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public void addFirst(int data) {
        Node node = new Node(data);
        if (this.head == null) {
            this.head = node;
            size++;
        } else {
            node.next = this.head;
            this.head = node;
            size++;
        }

    }


    @Override
    public void addLast(int data) {
        Node node = new Node(data);
        Node cur = this.head;
        if (this.head == null) {
            cur = node;
        }
        while (cur.next != null) {
            cur = cur.next;
        }
        cur.next = node;
        size++;
    }

    private void checkIndex(int index) {
        if (index < 0 || index > size) {
            throw new UnsupportedOperationException("Index不合法");
        }

    }

    //找到index-1 的位置，函数返回该位置的节点引用
    private Node searchIndex(int index) {
        Node cur = this.head;
        while (index - 1 > 0) {
            cur = cur.next;
            index--;
        }
        return cur;
    }

    @Override
    public boolean addIndex(int index, int data) {
        checkIndex(index);
        if (index == 0) {
            addFirst(data);
            size++;
            return true;
        }
        Node cur = searchIndex(index);//找到了index所在节点的前一个节点
        Node node = new Node(data);


        if (index > 0 && index < size) {
            node.next = cur.next;
            cur.next = node;
        }
        size++;
        return true;
    }

    @Override
    public boolean contains(int key) {
        Node cur = this.head;
        while (cur != null) {
            if (cur.data == key) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    //查找关键字key的前驱
    //如果找不到返回null
    private Node searchPre(int key) {
        Node pre = this.head;
        if (pre.data == key) {
            return this.head;
        }
        while (pre.next != null) {
            if (pre.next.data == key) {
                return pre;
            }
            pre = pre.next;
        }
        return null;
    }

    @Override
    public int remove(int key) {
        Node pre = searchIndex(key);
        int oldData = 0;
        if (pre == null) {
            throw new UnsupportedOperationException("key节点不存在");
        }
        //是头节点的时候
        if (pre == this.head && pre.data == key) {
            oldData = this.head.data;
            this.head = this.head.next;
            return oldData;
        } else {
            Node del = pre.next;
            oldData = del.data;
            pre.next = del.next;
            return oldData;
        }
    }

    @Override
    public void removeAllKey(int key) {
        if (isEmpty()) {
            return;
        }
        Node pre = this.head;
        Node cur = pre.next;
        while (cur != null) {
            if (cur.data == key) {
                pre.next = cur.next;
                cur = cur.next;
            } else {
                pre = pre.next;
                cur = cur.next;
            }
        }
        if (pre.data == key) {
            this.head = this.head.next;

        }

    }

    @Override
    public int getLength() {
        int count = 0;
        Node cur = this.head;
        while (cur != null) {
            cur = cur.next;
            count++;
        }

        return this.size = count;
    }

    @Override
    public void display() {
        Node cur = this.head;
        {
            while (cur != null) {
                cur = cur.next;
                System.out.print(cur.data + " ");
            }
        }
        System.out.println();
    }

    @Override
    public void clear() {
        Node cur = this.head;
        while (cur != null) {
            this.head = null;
            cur = cur.next;
            this.head = cur;
        }

    }

    //反转一个单链表
    public Node reverseList() {
       Node cur = this.head;
       Node pre = null;
       Node reverseHead = null;
       while(cur != null){
           Node curNext = cur.next;
           cur.next = null;
           if(curNext == null){
               reverseHead = cur;
           }else{
               cur.next = pre;
               pre = cur;
               cur = curNext;
           }
       }
       return reverseHead;
    }


    public void show(Node reverseHead) {
        Node cur = reverseHead;
        while (cur != null) {
            System.out.println(cur.data + " ");
        }
        System.out.println();
    }

    //找到一个单链表中间的中间节点，如果有两个，返回后者。
    public Node middleNode(Node head) {
        Node cur = this.head;
        int count = 0;
        while(cur != null){
            cur = cur.next;
            count++;
        }
        Node pre = this.head;
        for (int i = 0; i < count/2 ; i++) {
            pre = pre.next;
        }
        return pre;
    }

    //返回倒数第k个节点
    public Node countBackwadrs(int k) {
        Node cur = this.head;
        if (cur == null) {
            return cur;
        }
        int count = 0;
        while (cur != null) {
            cur = cur.next;
            count++;
        }
        if (count < k) {
            return null;
        }
        Node pre = this.head;
        for (int i = 0; i < count - k; i++) {
            pre = pre.next;
        }
        return pre;
    }

    public Node middleNode() {
        int len = getLength() / 2;
        Node cur = this.head;
        for (int i = 0; i < len; i++) {
            cur = cur.next;
        }
        return cur;
    }

    public Node findKthToTail(int k) {
        Node fast = this.head;
        Node slow = this.head;
        if (k <= 0 || k > getLength()) {
            return null;
        }
        //fast走k-1步;
        for (int i = 0; i < k - 1; i++) {
            fast = fast.next;
            k--;
        }

        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

    //编写代码，以给定值x为基准将链表分割成两部分，所有小于x的结点排在大于或等于x的结点之前
    public Node partition(int x) {
        Node beforeStart = null;
        Node beforeEnd = null;
        Node afterStart = null;
        Node afterEnd = null;
        Node pHead = this.head;
        Node node = new Node(x);
        while (pHead != null) {
            Node pHeadNext = pHead.next;
            pHead.next = null;
            if (pHead.data < x) {
                if (beforeStart == null) {
                    beforeStart.next = pHead;
                    beforeEnd = beforeStart;
                } else {
                    beforeEnd.next = pHead;
                    beforeEnd = pHead;
                }
            } else {
                if (afterStart == null) {
                    afterStart.next = pHead;
                    afterEnd = afterStart;
                } else {
                    afterEnd.next = pHead;
                    afterEnd = pHead;
                }

            }
            pHead = pHeadNext;
        }
        return null;
    }


    //创造一个环
    public void createCycle() {
       Node cur = this.head;
       while(cur != null){
           cur = cur.next;
       }
       cur = cur.next.next.next;
    }

    //判断是否有环
    public boolean hasCycle() {
       Node fast = this.head;
       Node slow = this.head;
       while(fast != null && fast.next != null){
           fast = fast.next.next;
           slow = slow.next;
           if(slow == fast){
               return true;
          }
       }
       return false;
    }

    //给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 NULL
    public Node detectCycle(Node node) {
       Node fast = this.head;
       Node slow = this.head;
       while(fast != null && fast.next != null){
           fast = fast.next.next;
           slow = slow.next;
           if(fast == slow){
               return null;
           }
           slow = this.head;
           while(slow != fast){
               slow = slow.next;
               fast = fast.next;
           }
       }
       return slow;
    }

    //在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针
    public Node deleteDuplication() {
       Node cur = this.head;
       Node newHead = new Node(-1);
       Node tmpHead = newHead;
       while(cur != null){
           if(cur.next != null && cur.next.data == cur.data){
               while(cur.next != null && cur.next.data == cur.data){
                   cur = cur.next;
               }
               cur = cur.next;
               newHead.next = cur;
           }else{
               newHead.next = cur;
               newHead = cur;
               cur = cur.next;
           }
       }
       return tmpHead;
    }


    //回文结构
    public boolean chkPalindrome() {
        if(this.head == null){
            return false;
        }
        if(this.head.next == null){
            return true;
        }
        Node fast = this.head;
        Node slow = this.head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        Node p = slow.next;
        Node pNext = p.next;
        while(p != null){
            p.next = slow;
            slow = p;
            p = p.next;
            if(p != null){
                pNext = p.next;
            }
            while(head != slow){
                if(head.data != slow.data){
                    return false;
                }
                if(head.next == slow){
                    return true;
                }
            }
        }
        return true;
    }
}

