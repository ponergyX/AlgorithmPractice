/**
 * Created by Lx on 2016/3/19.
 */
public class JumpFloorII {
    public class Solution {
        /*
        * 思想：f(n) = f(n - 1) + f(n - 2) + ..... + f(n - (n - 1) + 1，最后加的1即为一次直接跳n阶只有一种跳法
        * */
        public int JumpFloorII(int target) {
            int result = 0;
            if(target == 0){
                return 0;
            }else if(target == 1){
                return 1;
            }

            for(int i = 1;i < target;i++){
                result+=JumpFloorII(i);
            }
            result += 1;

            return result;
        }
    }
}
