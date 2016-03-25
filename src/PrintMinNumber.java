import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by Lx on 2016/3/24.
 */

/*
* 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
* 例如输入数组{3，32，321}，
* 则打印出这三个数字能排成的最小数字为321323。
* */
public class PrintMinNumber {
    public class Solution {

        /*
        * 思想：将整型数值大小的比较转换为string大小的比较
        * */
        public String PrintMinNumber(int [] numbers) {
            ArrayList<Integer> list = new ArrayList<>();
            for(int a:numbers){
                list.add(a);
            }
            Collections.sort(list, new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    String s1 = o1 + "" + o2;
                    String s2 = o2 + "" + o1;
                    return s1.compareTo(s2);
                }
            });
            StringBuilder sb = new StringBuilder();
            for(Integer a:list){
                sb.append(a);
            }
            return sb.toString();
        }
    }
}
