import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Lx on 2016/3/24.
 */
public class GetLeastNumbers_Solution {
    public class Solution {
        public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
            ArrayList<Integer> list = new ArrayList<>();
            ArrayList<Integer> result = new ArrayList<>();
            if(k > input.length){
                return result;
            }
            for(int a:input){
                list.add(a);
            }
            Collections.sort(list);
            for(int i = 0;i < k;i++){
                result.add(list.get(i));
            }
            return result;
        }
    }
}
