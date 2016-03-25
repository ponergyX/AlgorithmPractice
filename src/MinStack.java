/**
 * Created by Lx on 2016/3/20.
 */
public class MinStack {
    public class Node{
        public int val;
        public Node prev;
        public Node(int val){
            this.val = val;
        }
    }

    public class Solution {
        Node top;

        public void push(int node) {
            Node newNode = new Node(node);
            if(top != null){
                newNode.prev = top;
            }
            top = newNode;
        }

        public void pop() {
            if(top != null){
                top = top.prev;
            }
        }

        public int top() {
            return top == null? 0 : top.val;
        }

        public int min() {
            int min = 0;
            Node current = top;
            if(current != null){
                min = current.val;
                while (current.prev != null){
                    current = current.prev;
                    if(min > current.val){
                        min = current.val;
                    }
                }
            }
            return min;
        }
    }
}
