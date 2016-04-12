import java.util.Arrays;

/**
 * Created by Lx on 2016/4/12.
 */
/*
* LL今天心情特别好,因为他去买了一副扑克牌,
* 发现里面居然有2个大王,2个小王(一副牌原本
* 是54张^_^)...他随机从中抽出了5张牌,想测
* 测自己的手气,看看能不能抽到顺子,如果抽到
* 的话,他决定去买体育彩票,嘿嘿！！“红心A,黑
* 桃3,小王,大王,方片5”,“Oh My God!”不是顺
* 子.....LL不高兴了,他想了想,决定大\小 王
* 可以看成任何数字,并且A看作1,J为11,Q为12,
* K为13。上面的5张牌就可以变成“1,2,3,4,5”
* (大小王分别看作2和4),“So Lucky!”。LL决
* 定去买体育彩票啦。 现在,要求你使用这幅牌
* 模拟上面的过程,然后告诉我们LL的运气如何。
* 为了方便起见,你可以认为大小王是0。
* */
public class IsContinuous {
    public class Solution {
        /*
        * 思想：先给数组排序，然后分别统计出0的个数和非零数字的间隔，若0的数目大于等于总间隔则为顺子，注意防范出现对子的情况
        * */
        public boolean isContinuous(int [] numbers) {
            if(numbers.length != 5){
                return false;
            }
            Arrays.sort(numbers);
            int zeroNum = numbers[0] == 0?1 : 0;
            int totalDiff = 0;
            for(int i = 1;i < numbers.length;i++){
                if(numbers[i] == 0){
                    zeroNum++;
                }else if(i > 1){
                    int diff = Math.abs(numbers[i] - numbers[i - 1]);
                    if(diff > 1){
                        totalDiff+=(diff-1);
                    }else if(diff == 0){
                        //出现对子
                        return false;
                    }
                }
            }

            if(zeroNum >= totalDiff){
                return true;
            }

            return false;
        }
    }
}
