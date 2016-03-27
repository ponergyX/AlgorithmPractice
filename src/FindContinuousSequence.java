import java.util.ArrayList;

/**
 * Created by Lx on 2016/3/27.
 */
/*
*
* 题目描述

小明很喜欢数学,有一天他在做数学作业时,
要求计算出9~16的和,他马上就写出了正确答案是100。
但是他并不满足于此,他在想究竟有多少种连续的正数序列的和为100(至少包括两个数)。
没多久,他就得到另一组连续正数和为100的序列:18,19,20,21,22。现在把问题交给你,
你能不能也很快的找出所有和为S的连续正数序列? Good Luck!

输出描述:
输出所有和为S的连续正数序列。序列内按照从小至大的顺序，序列间按照开始数字从小到大的顺序
* */
public class FindContinuousSequence {
    public class Solution {

        /*
        * 剑指offer思想：small指向较小的数字，big指向较大的数字，当small到big的和小于sum时，big增加。当small到big的和
        * 大于sum时small增加，直到small到big的和等于sum。small最多增长到(sum + 1)/2（至少两个数字组成的序列）
        * */
        public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
            ArrayList<ArrayList<Integer>> result = new ArrayList<>();
            int mid = (1 + sum) / 2;
            int small = 1;
            int big = 2;
            int curSum = small + big;

            while (small < mid){
                if(curSum == sum){
                    putIntoResult(result,small,big);
                }

                while (curSum > sum && small < mid){
                    curSum-=small;
                    small++;
                    if(curSum == sum){
                        putIntoResult(result,small,big);
                    }
                }

                big++;
                curSum+=big;
            }
            return result;
        }

        public void putIntoResult(ArrayList<ArrayList<Integer>> result,int small,int big){
            ArrayList<Integer> list = new ArrayList<>();
            for(int i = small;i <= big;i++){
                list.add(i);
            }
            result.add(list);
        }
    }
}
