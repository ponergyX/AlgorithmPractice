/**
 * Created by Lx on 2016/3/20.
 */
public class RandomListNode1 {

    public class RandomListNode {
        int label;
        RandomListNode next = null;
        RandomListNode random = null;

        RandomListNode(int label) {
            this.label = label;
        }
    }

    public class Solution {
        public RandomListNode Clone(RandomListNode pHead)
        {
            if(pHead == null){
                return null;
            }
            RandomListNode cHead = new RandomListNode(pHead.label);
            RandomListNode p;
            RandomListNode c;
            cHead.next = pHead.next;
            pHead.next = cHead;
            p = cHead;
            c = cHead;
            while (c.next != null){
                c = new RandomListNode(c.next.label);
                c.next = p.next.next;
                p.next.next = c;
                p = c;
            }

            p = pHead;
            c = cHead;
            while (c.next != null){
                c.random = p.random == null? null : p.random.next;
                c = c.next.next;
                p = p.next.next;
            }
            c.random = p.random == null? null : p.random.next;

            p = pHead;
            c = cHead;
            while (c.next != null){
                p.next = c.next;
                c.next = p.next.next;
                p = p.next;
                c = c.next;
            }
            return cHead;
        }
    }
}
