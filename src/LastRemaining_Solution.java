import java.util.LinkedList;

/**
 * Created by Lx on 2016/4/12.
 */
public class LastRemaining_Solution {
    public static class Solution {
        /*public int LastRemaining_Solution(int n, int m) {
            if(n < 1){
                return -1;
            }
            LinkedList<Integer> linkedList = new LinkedList<>();
            for(int i = 0;i < n;i++){
                linkedList.add(i);
            }
            int index = 0;
            while (linkedList.size() > 1){
                for(int i = 1;i < m;i++){
                    if(++index == linkedList.size()){
                        index = 0;
                    }
                }
                linkedList.remove(index);
                if(index == linkedList.size()){
                    index = 0;
                }
            }
            return linkedList.getFirst();
        }*/

        public int LastRemaining_Solution(int n, int m) {
            if(n < 1 || m < 1){
                return -1;
            }
            int last = 0;
            for(int i = 2;i <= n;i++){
                last = (last + m) % i;
            }
            return last;
        }
    }

    public static void main(String[] args){
        LastRemaining_Solution.Solution solution = new LastRemaining_Solution.Solution();
        solution.LastRemaining_Solution(5,3);
    }
}
