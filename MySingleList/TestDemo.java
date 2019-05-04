package git.com.MySingleList;

public class TestDemo {

    public static void createCut(MySingleList.Node headA, MySingleList.Node headB) {
        headA.next.next = headB.next.next;
    }

   public static MySingleList.Node getIntersectionNode(MySingleList.Node headA,MySingleList.Node headB){
       MySingleList.Node pLong = headA;
       MySingleList.Node pShort = headB;
       int lenA = 0;
       while(pLong != null){
           pLong = pLong.next;
           lenA++;
       }
       int lenB = 0;
       while(pShort != null){
           pShort = pShort.next;
           lenB++;
       }
       pLong = headA;
       pShort = headB;
       int myLen = lenA - lenB;
       if(myLen < 0){
           pLong = headB;
           pShort = headA;
           myLen = lenB - lenA;
       }
       for(int i = 0;i < myLen;i++){
           pLong = pLong.next;
       }
       while(pLong != null && pShort != null && pLong != pShort){
           pLong = pLong.next;
           pShort = pShort.next;

       }
       if(pLong == pShort && pLong != null && pShort != null){
           return pLong;
       }
       return null;
   }


   public static MySingleList.Node mergeTwoLists (MySingleList.Node headA,MySingleList.Node headB){
        MySingleList mySingleList = new MySingleList();
        MySingleList.Node newHead = mySingleList.new Node(-1);
        MySingleList.Node tmpHead = newHead;
        while(headA != null && headB != null){
            if(headA.getData() >= headB.getData()){
                newHead.next = headB;
                newHead = headB;
                headB = headB.next;
            }else{
                newHead.next = headA;
                newHead = headA;
                headA = headA.next;
            }
        }
        if(headA != null){
            newHead.next = headA;
        }
        if(headB != null){
            newHead.next = headB;
        }
        return tmpHead.next;
   }


    public static void main(String[] args) {
    MySingleList mySingleList = new MySingleList();
    mySingleList.addIndex(0,12);
    mySingleList.addIndex(1,22);
    mySingleList.addIndex(2,32);
    mySingleList.addFirst(2);
    mySingleList.addLast(42);
    mySingleList.display();
    }
}
