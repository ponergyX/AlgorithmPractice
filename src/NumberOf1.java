/**
 * Created by Lx on 2016/3/19.
 */
public class NumberOf1 {
    public class Solution {
        /*
        * 思想：用1与n去做与运算，若运算结果不等于0则将1做左移一位继续与运算
        * */
        public int NumberOf1(int n) {
            int flag = 1;
            int count = 0;
            while (flag != 0){
                if((n & flag) != 0){
                    count++;
                }
                flag = flag << 1;
            }
            return count;
        }
    }
}
