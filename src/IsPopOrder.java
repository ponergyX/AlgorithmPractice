import java.util.Stack;

/**
 * Created by Lx on 2016/3/20.
 */
public class IsPopOrder {
    public static class Solution {
        /*
        * 思想:先将pushA中所有到与popA[0]相等的元素入栈，若popA中的j个元素与此时栈顶元素相等就出栈，若不想等则在进行一轮检查
        * 继续入栈，知道i超过pushA.length,若此时j的大小不等于popA.length则不存在此种出栈方式
        * */
        public boolean IsPopOrder(int [] pushA,int [] popA) {
            if(pushA.length == 0 || popA.length == 0){
                return false;
            }

            Stack<Integer> stack = new Stack<>();
            int i = 0,j = 0;

            while (i < pushA.length){
                while (i < pushA.length && pushA[i] != popA[j]){
                    stack.push(pushA[i++]);
                }
                if(i < pushA.length){
                    stack.push(pushA[i++]);
                }

                while (!stack.empty() && stack.peek() == popA[j]){
                    stack.pop();
                    j++;
                }
            }

            return  j == popA.length;
        }

        //思想，每次入栈一个pushA中的元素，再判断此时栈顶元素是否与popA的第j个元素相等
        //若相等则依次出栈知道不等于popA的第j个元素，继续入栈，若最后栈是空的则说明有此种出栈方式
//        public boolean IsPopOrder(ArrayList<Integer> pushA,ArrayList<Integer> popA) {
//            Stack stack = new Stack();
//            if( pushA.size() == 0 && popA.size() == 0 ) return true;
//            for( int i=0,j=0; i < pushA.size(); i++ ){
//                stack.push( pushA.get(i) );
//                while( ( !stack.empty() )&& ( stack.peek() == popA.get(j) ) ){
//                    stack.pop();
//                    j ++;
//                }
//            }
//
//            return stack.empty() == true;
//        }
    }

    public static void main(String[] args){
        Solution solution = new IsPopOrder.Solution();
        int[] a = {1},b = {2};
        solution.IsPopOrder(a,b);
        Stack<Integer> stack = new Stack<>();
    }
}
