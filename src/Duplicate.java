import java.util.Arrays;

/**
 * Created by Lx on 2016/4/13.
 */
/*
* 在一个长度为n的数组里的所有数字都在0到n-1的范围内。
 * 数组中某些数字是重复的，但不知道有几个数字是重复的
 * 。也不知道每个数字重复几次。请找出数组中任意一个重
 * 复的数字。 例如，如果输入长度为7的数组{2,3,1,0,2,
 * 5,3}，那么对应的输出是重复的数字2或者3。
* */
public class Duplicate {
    public class Solution {
        // Parameters:
        //    numbers:     an array of integers
        //    length:      the length of array numbers
        //    duplication: (Output) the duplicated number in the array number,length of duplication array is 1,so using duplication[0] = ? in implementation;
        //                  Here duplication like pointor in C/C++, duplication[0] equal *duplication in C/C++
        //    这里要特别注意~返回任意重复的一个，赋值duplication[0]
        // Return value:       true if the input is valid, and there are some duplications in the array number
        //                     otherwise false
       /* public boolean duplicate(int numbers[],int length,int [] duplication) {
            if(numbers == null || numbers.length < 2 || numbers.length != length){
                return false;
            }

            Arrays.sort(numbers);
            for (int i = 1;i < numbers.length;i++){
                if(numbers[i - 1] == numbers[i]){
                    duplication[0] = numbers[i];
                    return true;
                }
            }
            return false;
        }*/

        /*
        * 思想：记m = numbers[i]，若i位置的数字不等于i则判断numbers[m]与number[i]是否相等，若相等则该数字则为重复数字，
        * 若不相等则交换这两个数字继续该循环
        * */
        public boolean duplicate(int numbers[],int length,int [] duplication) {
            if(numbers == null || numbers.length != length){
                return false;
            }

            for(int a:numbers){
                if(a < 0 || a > numbers.length - 1){
                    return false;
                }
            }

            for(int i = 0;i < numbers.length;i++){
                while (numbers[i] != i){
                    int m = numbers[i];
                    if(numbers[m] == numbers[i]){
                        duplication[0] = numbers[m];
                        return true;
                    }
                    numbers[i] = numbers[m];
                    numbers[m] = m;
                }
            }

            return false;
        }
    }
}
