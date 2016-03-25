import java.util.Stack;

/**
 * Created by Lx on 2016/3/19.
 */
public class TwoStackQueue {
    public class Solution {
        Stack<Integer> stack1 = new Stack<Integer>();
        Stack<Integer> stack2 = new Stack<Integer>();

        public void push(int node) {
            while (stack2.size() > 0){
                stack1.push(stack2.pop());
            }
            stack1.push(node);
        }

        public int pop() {
            while (stack1.size() > 0){
                stack2.push(stack1.pop());
            }
            return stack2.pop();
        }

//        better solution
//        public void push(int node) {
//            stack1.push(new Integer(node));
//        }
//
//        public int pop() {
//            if(stack2.isEmpty()){
//                while(!stack1.isEmpty()){
//                    stack2.push(stack1.pop());
//                }
//            }
//            return stack2.pop().intValue();
//        }
    }
}
