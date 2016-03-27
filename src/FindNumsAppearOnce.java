import java.util.HashMap;

/**
 * Created by Lx on 2016/3/27.
 */
public class FindNumsAppearOnce {
    //num1,num2分别为长度为1的数组。传出参数
    //将num1[0],num2[0]设置为返回结果
    public class Solution {
       /* public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
            if (array.length == 1){
                num1[0] = 0;
                num2[0] = 0;
                return;
            }
            HashMap<Integer,Integer> map = new HashMap<>();
            for(int a:array){
                if(map.get(a) != null){
                    map.put(a,map.get(a) + 1);
                }else{
                    map.put(a,1);
                }
            }

            boolean num1Used = false;
            for(int a:map.keySet()){
                if(map.get(a) == 1 && !num1Used){
                    num1[0] = a;
                    num1Used = true;
                }else if(map.get(a) == 1 && num1Used){
                    num2[0] = a;
                }
            }
        }*/


        /*
        * 剑指offer思想：时间复杂度O（n），利用异或的交换性，若一个数组中只有一个数字出现一次，其他的数字均出现两次，则数组中
        * 所有数字的异或结果等于只出现一次的那个数字。当有两个数字只出现一次时，异或所有数字的结果肯定不为0，用该结果第一位为1
        * 的那一位来将整个数组分成两部分，所有该位为1的数字为一部分，不为1的为另一部分。然后分别异或这两部分数组，就可得到两个
        * 只出现一次的数字。
        * */
        public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
            if(array.length < 2){
                return;
            }

            int xorResult = 0;//所有数异或的结果
            for(int a : array){
                xorResult ^= a;
            }

            int first1Index = first1Index(xorResult);

            num1[0] = num2[0] = 0;
            for(int a:array){
                if(is1Bit(a,first1Index)){
                    num1[0] ^= a;
                }else{
                    num2[0] ^= a;
                }
            }
        }

        public int first1Index(int xorResult){
            int index = 0;
            while ((1 & xorResult) == 0 && index < 32){
                xorResult = xorResult >> 1;
                index++;
            }
            return index;
        }

        public boolean is1Bit(int a,int index){
            a = a >> index;
            if((a & 1) == 0){
                return false;
            }
            return true;
        }
    }
}
