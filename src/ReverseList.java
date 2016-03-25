import java.util.Stack;

/**
 * Created by Lx on 2016/3/20.
 */
public class ReverseList {

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    /*
    * 思想：current表示当前遍历的结点，prev表示当前结点的前一个节点，currentNext表示当前结点的后一个结点
    * */
    public class Solution {
        public ListNode ReverseList(ListNode head) {
            if(head == null){
                return null;
            }
            ListNode reverseHead = null;
            ListNode current = head,currentNext = null,prev = null;
            while (current != null){
                currentNext = current.next;
                current.next = prev;
                if(currentNext == null){
                    reverseHead = current;
                }
                prev = current;
                current = currentNext;
            }
            return reverseHead;
        }
    }
}
