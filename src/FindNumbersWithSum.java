import java.util.ArrayList;

/**
 * Created by Lx on 2016/3/27.
 */
/*
* 题目描述

输入一个递增排序的数组和一个数字S，在数组中查找两个数，
使得他们的和正好是S，如果有多对数字的和等于S，输出两个
数的乘积最小的。

输出描述:
对应每个测试案例，输出两个数，小的先输出。
* */
public class FindNumbersWithSum {
    /*
    * 思想：从数组的两端开始，small指向前一个数字，big指向后一个数字，当small+big>sum时让big-1，反之让small+1，知道
    * 找到small+big=sum，在这个过程中big要始终大于small
    * */
    public ArrayList<Integer> FindNumbersWithSum(int [] array, int sum) {
        ArrayList<Integer> result = new ArrayList<>();
        if(array.length < 2){
            return result;
        }
        int small = 0;
        int big = array.length - 1;
        int currentSum;
        while (big > small){
            currentSum = array[small] + array[big];
            if(currentSum == sum){
                result.add(array[small]);
                result.add(array[big]);
            }

            if(currentSum > sum){
                big--;
            }else{
                small++;
            }
        }

        if(result.size() > 2){
            int resultIndex = 0;
            int temp = 0x40000000;//max value
            for(int i = 0;i < result.size();i+=2){
                if(result.get(i) * result.get(i + 1) < temp){
                    resultIndex = i;
                    temp = result.get(i) * result.get(i + 1);
                }
            }

            int a = result.get(resultIndex);
            int b = result.get(resultIndex+1);
            result.clear();
            result.add(a);
            result.add(b);
        }

        return result;
    }
}
