import java.util.HashMap;

/**
 * Created by Lx on 2016/3/23.
 */
public class MoreThanHalfNum_Solution {
    public class Solution {
        public int MoreThanHalfNum_Solution(int [] array) {
            HashMap<Integer,Integer> map = new HashMap<>();
            for (int i:array){
                if(map.get(i) != null){
                    map.put(i,map.get(i) + 1);
                }else{
                    map.put(i,1);
                }
            }

            for(Integer i :map.keySet()){
                if(map.get(i) > array.length / 2){
                    return i;
                }
            }
            return 0;
        }
    }
}
