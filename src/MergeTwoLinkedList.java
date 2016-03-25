/**
 * Created by Lx on 2016/3/20.
 */
public class MergeTwoLinkedList {

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public class Solution {
        /*
        * 非递归，思想：和归并排序的merge函数思想一样，每次比较两个链表的头节点大小，小的一个加入新的链表。
        * */
        /*public ListNode Merge(ListNode list1,ListNode list2) {
            if(list1 == null){
                return list2;
            }else if(list2 == null){
                return list1;
            }

            ListNode head;
            ListNode current = null;
            if(list1.val > list2.val){
                head = new ListNode(list2.val);
                list2 = list2.next;
            }else{
                head = new ListNode(list1.val);
                list1 = list1.next;
            }
            current = head;

            while (list1 != null && list2 != null){
                if(list1.val > list2.val){
                    current.next = new ListNode(list2.val);
                    list2 = list2.next;
                }else{
                    current.next = new ListNode(list1.val);
                    list1 = list1.next;
                }
                current = current.next;
            }

            while (list1 != null){
                current.next = new ListNode(list1.val);
                current = current.next;
                list1 = list1.next;
            }

            while (list2 != null){
                current.next = new ListNode(list2.val);
                current = current.next;
                list2 = list2.next;
            }

            return head;
        }*/

        /*
        * 递归版本
        * */
        public ListNode Merge(ListNode list1,ListNode list2) {
            if(list1 == null){
                return list2;
            }else if(list2 == null){
                return list1;
            }

            ListNode head;
            if(list1.val > list2.val){
                head = list2;
                head.next = Merge(list1,list2.next);
            }else{
                head = list1;
                head.next = Merge(list1.next,list2);
            }

            return head;
        }
    }
}
