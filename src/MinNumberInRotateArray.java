/**
 * Created by Lx on 2016/3/19.
 */
public class MinNumberInRotateArray {
    public class Solution {
        public int minNumberInRotateArray(int [] array) {
            if(array.length == 0){
                return 0;
            }

            for(int i = array.length - 1;i > 0;i--){
                if(array[i] < array[i - 1]){
                    return array[i];
                }
            }
            return array[0];
        }
    }
}
