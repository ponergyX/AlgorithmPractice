import java.util.Stack;

/**
 * Created by Lx on 2016/3/19.
 */
public class FindKthToTail {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    /*
    * 思想：开两个指针，第一个指向头，第二个开始指向头然后让其往后走k - 1个位置，之后两者一起往后走知道第二个指针到末尾，则此时
    * 的第一个指针指向的结点即为结果
    * */
    public class Solution {
        public ListNode FindKthToTail(ListNode head,int k) {
            ListNode first,sec;
            if(head == null){
                return null;
            }

            first = head;
            sec = head;

            int i = 1;
            while (i < k && sec.next != null){
                sec = sec.next;
                i++;
            }

            if(i != k){
                return null;
            }

            while (sec.next != null){
                sec = sec.next;
                first = first.next;
            }

            return first;
        }
    }
}
