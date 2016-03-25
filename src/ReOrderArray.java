/**
 * Created by Lx on 2016/3/19.
 */
public class ReOrderArray {
    public class Solution {
        /*
        * 思想：类似于插入排序，从第一个数字开始扫描，若其为奇数则将其全面的所有偶数与之挨个换位置。
        * */
        public void reOrderArray(int [] array) {
            for(int i = 0;i < array.length;i++){
                if(array[i] % 2 == 1){
                    int k = i;
                    int j = i - 1;
                    while (j >= 0){
                        if(array[j] % 2 == 0){
                            int temp = array[k];
                            array[k] = array[j];
                            array[j] = temp;
                            k = j;
                        }
                        j--;
                    }
                }
            }
        }
    }
}
