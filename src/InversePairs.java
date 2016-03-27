import java.util.Arrays;

/**
 * Created by Lx on 2016/3/25.
 */

/*
* 题目描述

在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数。
* */
public class InversePairs {
    public class Solution {
        /*public int InversePairs(int [] array) {
            int resulut = 0;
            for(int i = 1;i < array.length;i++){
                for(int j = 0;j < i;j++){
                    if(array[j] > array[i]){
                        resulut++;
                    }
                }
            }
            return resulut;
        }*/


        /*
        * 剑指Offer书中的思想
        * */
        public int InversePairs(int[] array){
            return mergeSort(array,0,array.length - 1);
        }

        public int mergeSort(int[] array,int start,int end){
            if(start >= end){
                return 0;
            }

            int mid = (start + end) / 2;
            int leftNum = mergeSort(array,start,mid);
            int rightNum = mergeSort(array,mid + 1,end);

            int[] copyArray = Arrays.copyOf(array,array.length);
            int frontIndex = mid;
            int backIndex = end;
            int copyIndex = end;
            int count = 0;
            while (frontIndex >= start && backIndex > mid){
                if(array[frontIndex] > array[backIndex]){
                    copyArray[copyIndex--] = array[frontIndex--];
                    count += (backIndex - mid);
                }else{
                    copyArray[copyIndex--] = array[backIndex--];
                }
            }

            //将比较剩余的点进行处理
            while (frontIndex >= start){
                copyArray[copyIndex--] = array[frontIndex--];
            }

            //将比较剩余的点进行处理
            while (backIndex > mid){
                copyArray[copyIndex--] = array[backIndex--];
            }

            for(int i = start;i <= end;i++){
                array[i] = copyArray[i];
            }

            return leftNum + count + rightNum;
        }
    }
}
