import java.util.ArrayList;

/**
 * Created by Lx on 2016/3/24.
 */
public class FindGreatestSumOfSubArray {
    public static class Solution {
        /*
        * 自己的思想：将原数组相同符号的数字组合，最后压缩数组得到list，再在list中求最大和
        * */
        /*public int FindGreatestSumOfSubArray(int[] array) {
            if(array.length == 0){
                return 0;
            }
            ArrayList<Integer> list = new ArrayList<>();
            int sum = array[0];
            for(int i = 1;i < array.length;i++){
                if(array[i - 1] * array[i] > 0){
                    sum+=array[i];
                }else{
                    list.add(sum);
                    sum=0;
                    sum+=array[i];
                }
            }
            list.add(sum);
            if(list.size() == 1){
                if(list.get(0) < 0){
                    int smallest = Integer.MIN_VALUE;
                    for(int a : array){
                        if(a > smallest){
                            smallest = a;
                        }
                    }
                    return smallest;
                }else{
                    return list.get(0);
                }
            }

            int max = 0;
            int sum1 = 0;
            for(int i = 0;i < list.size();i++){
                for(int j = i + 1;j < list.size();j++){
                    for(int k = i;k <= j;k++){
                        sum1+=list.get(k);
                    }
                    if(sum1 > max){
                        max = sum1;
                    }
                    sum1 = 0;
                }
            }
            return max;
        }*/

        public int FindGreatestSumOfSubArray(int[] array) {
            if(array.length == 0){
                return 0;
            }

            int max = 0x80000000;//MIN_VALUE
            int sum = 0;
            for(int a:array){
                if(sum < 0){
                    sum = a;
                }else{
                    sum+=a;
                }

                if(sum > max){
                    max = sum;
                }
            }
            return max;
        }
    }

    public static void main(String[] args){
        int greatestSum=0x80000000;
        System.out.println(greatestSum);
        System.out.println(Integer.MIN_VALUE);
        Solution solution = new FindGreatestSumOfSubArray.Solution();
//        solution.FindGreatestSumOfSubArray(new int[]{-2,-8,-1,-5,-9});
    }
}
