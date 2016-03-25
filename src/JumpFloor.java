/**
 * Created by Lx on 2016/3/19.
 */
public class JumpFloor {
    public class Solution {
        /*
        * 思想:一次可以跳两阶也可以跳一阶，及f(n) = f(n - 1) + f(n - 2)，剩两阶时有两种跳法，剩一阶时有一种跳法
        * */
        public int JumpFloor(int target) {
            if(target <= 0){
                return 0;
            }else if(target == 1){
                return 1;
            }else if(target == 2){
                return 2;
            }else{
                return JumpFloor(target - 1) + JumpFloor(target - 2);
            }
        }
    }
}
