import java.util.ArrayList;

/**
 * Created by Lx on 2016/3/19.
 */
public class PrintListFromTailToHead {

     public class ListNode {
         int val;
         ListNode next = null;

         ListNode(int val) {
             this.val = val;
         }
     }

    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList<>();
        if(listNode != null){
            if(listNode.next != null){
                list = printListFromTailToHead(listNode.next);
            }
            list.add(listNode.val);
        }
        return list;
    }
}
