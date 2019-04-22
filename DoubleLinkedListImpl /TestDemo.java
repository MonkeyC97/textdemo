package git.com.DoubleLinkedListImpl;

public class TestDemo {
    public static void main(String[] args) {
        MySingleList mySingleList = new MySingleList();
        mySingleList.addIndex(0, 1994);
        mySingleList.addFirst(10);
        mySingleList.addFirst(40);
        mySingleList.addFirst(30);
        mySingleList.addFirst(40);

        mySingleList.addLast(50);
        mySingleList.addLast(60);
        //40 30 20 10 99 50 60
        mySingleList.display();
        mySingleList.addIndex(3, 40);
        mySingleList.display();
        mySingleList.addIndex(9, 40);
        mySingleList.display();
        System.out.println("=====================");
        mySingleList.clear();
    }
}
