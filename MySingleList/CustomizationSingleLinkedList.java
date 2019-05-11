package com.monkeyc.github.textdemo.MySingleList;

    public class CustomizationSingleLinkedList<T> {
        class Node<T>{
            private Node next;
            private T data;
            public Node(T data){
                this.data = data;
            }
            public Node getNext(){
                return next;
            }
        }

        private Node head;
        int size = 0;
        public void getHead(){
            this.head = head;
        }
        public void getSize(){
            this.size = size;
        }




        //创建空链表
        public CustomizationSingleLinkedList() {
            this.head = null;
            this.size = 0;
        }

        //以指定数据元素来创建链表，该链表只有一个元素
        public CustomizationSingleLinkedList(T element) {
            //TODO
            this.head = new Node(element);
            this.size++;
        }

        /**
         * 返回链表长度
         *
         * @return
         */
        public int length() {
            //TODO
            Node cur = this.head;
            int count = 0;
            while(cur != null){
                cur = cur.next;
                count++;
            }
            return count;
        }

        /**
         * 获取链表中指定索引的元素
         *
         * @param index
         * @return
         */
        public T get(int index) {
            //TODO
          Node cur = getNodeByIndex(index);
          return  (T) cur.data;
        }

        private Node getNodeByIndex(int index) {
            //TODO
            while(index < 0 || index > this.length() - 1){
                throw new UnsupportedOperationException("index不合法");
            }
            Node cur = this.head;
            if(cur == null){
                return null;
            }
            for(int i = 0;i < index;i++){
                cur = cur.next;
            }

            return cur;
        }

        /**
         * 查找链表中指定元素的索引
         *
         * @param element
         * @return
         */
        public int locate(T element) {
            //TODO

            int index = 0;
            Node cur = this.head;
            while (cur != null) {
                if (element != null) {
                    if (element.equals(cur.data)) {
                        return index;
                    }
                } else {
                    if (element == cur.data) {
                        return index;
                    }
                } index++;
            }
            return index;
        }

        /**
         * 向线性表指定位置插入一个元素
         *
         * @param element
         * @param index
         */
        public void insert(T element, int index) {
            //TODO
            if(index < 0 || index >this.length()-1){
                throw new UnsupportedOperationException("index有误");
            }
            Node cur = getNodeByIndex(index-1);
            Node node = new Node(element);
            node.next = cur.next;
            cur.next = node;
            this.size++;

        }

        /**
         * 采用尾插入法为链表添加新节点
         *
         * @param element
         */
        public void add(T element) {
            //TODO
            this.insert(element,this.length()-1);
        }

        /**
         * 采用头插入法为链表添加新节点
         *
         * @param element
         */
        public void addAtHeader(T element) {
            //TODO
            Node node = new Node(element);
            if(this.head == null){
                this.head = node;
            }
            Node cur = this.head;
            while(cur != null){
                node.next = this.head;
                this.head = node;
                cur = cur.next;
            }
        }

        /**
         * 删除链表中指定索引处的元素
         *
         * @param index
         * @return
         */
        public T delete(int index) {
            if(index < 0 || index >this.length() - 1){
                throw new UnsupportedOperationException("有误");
            }
            if(index == 0){
                Node head =getNodeByIndex(0);
                if(head != null){
                    this.head = head.next;
                    return (T) head.data;
                }
            }else{
                Node preNode = getNodeByIndex(index-1);
                Node curNode = getNodeByIndex(index);
                preNode.next = curNode.next;
                return (T) preNode;
            }
            return null;
        }

        /**
         * 删除链表中最后一个元素
         *
         * @return
         */
        public T remove() {
            return this.delete(this.size - 1);
        }

        /**
         * 判断链表是否为空
         *
         * @return
         */
        public boolean empty() {
            //TODO
            if(this.size == 0){
                return true;
            }else{
                return false;
            }
        }

        /**
         * 清空链表
         */
        public void clear() {
            //TODO
            Node cur = this.head;
            while(cur != null){
                cur = cur.next;
                this.head = cur;
            }
        }

        @Override
        public String toString() {
            if(empty()){
                return "[]";
            }
            StringBuilder str = new StringBuilder();
            str.append("[");
            Node cur = this.head;
            while(cur != null){
                if(cur != null){
                    str.append(cur.data);
                }else{
                    return str.append(']').toString();
                }
                cur = cur.next;
            }
            return "[]";
        }

        public static void main(String[] args) {
            CustomizationSingleLinkedList<String> list = new CustomizationSingleLinkedList<>();
            list.addAtHeader("Java");
            list.addAtHeader("PHP天下第一");
            System.out.println(list.toString());
        }

    }
