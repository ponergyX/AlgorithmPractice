import java.util.HashMap;

/**
 * Created by Lx on 2016/3/25.
 */

/*
* 题目描述

输入两个链表，找出它们的第一个公共结点。
* */
public class FindFirstCommonNode {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }


    public class Solution {

        /*
        * 思想：借助hashmap，每次将链表的头节点顺序放入，若map中已有该结点则返回该结点
        * */
        /*public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
            HashMap<ListNode,Boolean> map = new HashMap<>();
            if(pHead1 == null || pHead2 == null){
                return null;
            }
            while (pHead1 != null && pHead2 != null){
                if(map.get(pHead1) != null){
                    return pHead1;
                }else{
                    map.put(pHead1,true);
                }

                if(map.get(pHead2) != null){
                    return pHead2;
                }else{
                    map.put(pHead2,true);
                }
                pHead1 = pHead1.next;
                pHead2 = pHead2.next;
            }

            while (pHead1 != null){
                if(map.get(pHead1) != null){
                    return pHead1;
                }else{
                    map.put(pHead1,true);
                }
                pHead1 = pHead1.next;
            }

            while (pHead2 != null){
                if(map.get(pHead2) != null){
                    return pHead2;
                }else{
                    map.put(pHead2,true);
                }
                pHead2 = pHead2.next;
            }
            return null;
        }*/


        /*
        * 思想：若有公共节点，则从公共节点开始的后部分两链表一样，及成一个Y形，
        * 比较两链表长度，让长的先走他俩的长度差个位置，然后两个链表一起走
       * */
        public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
            int len1 = getLength(pHead1);
            int len2 = getLength(pHead2);


            if(len1 > len2){
                pHead1 = walkNstep(len1 - len2,pHead1);
            }else{
                pHead2 = walkNstep(len2 - len1,pHead2);
            }

            while (pHead1 != null){
                if(pHead1 == pHead2){
                    return pHead1;
                }
                pHead1 = pHead1.next;
                pHead2 = pHead2.next;
            }

            return null;
        }

        public int getLength(ListNode head){
            int length = 0;
            while (head != null){
                length++;
                head = head.next;
            }
            return length;
        }

        public ListNode walkNstep(int n,ListNode head){
            int i = 0;
            while (i < n){
                head = head.next;
                i++;
            }
            return head;
        }
    }
}
