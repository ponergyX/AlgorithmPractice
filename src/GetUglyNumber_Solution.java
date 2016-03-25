import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by Lx on 2016/3/25.
 */

/*
* 把只包含因子2、3和5的数称作丑数（Ugly Number）。
* 例如6、8都是丑数，但14不是，因为它包含因子7。
* 习惯上我们把1当做是第一个丑数。
* 求按从小到大的顺序的第N个丑数。
* */
public class GetUglyNumber_Solution {
    public class Solution {

        /*
        *   1）初始化array和队列：Q2 Q3 Q5
            2）将1插入array
            3）分别将1*2、1*3 、1*5插入Q2 Q3 Q5
            4)令x为Q2 Q3 Q5中的最小值，将x添加至array尾部
            5）若x存在于：
                Q2：将 x * 2、x * 3、x*5 分别放入Q2 Q3 Q5，从Q2中移除x
                Q3：将 x * 3、x*5 分别放入Q3 Q5，从Q3中移除x
                Q5：将 x * 5放入Q5，从Q5中移除x
            6）重复步骤4~6，知道找到第k个元素
        * */
        public int GetUglyNumber_Solution(int index) {
            if(index <= 0){
                return 0;
            }
            ArrayList<Integer> resultList = new ArrayList<>();
            LinkedList<Integer> q2 = new LinkedList<>();
            LinkedList<Integer> q3 = new LinkedList<>();
            LinkedList<Integer> q5 = new LinkedList<>();
            resultList.add(1);
            q2.addFirst(2);
            q3.addFirst(3);
            q5.addFirst(5);
            for(int i = 1;i < index;i++){
                int fQ2 = q2.getFirst();
                int fQ3 = q3.getFirst();
                int fQ5 = q5.getFirst();
                int smallest = Math.min(fQ2,Math.min(fQ3,fQ5));
                resultList.add(smallest);
                if(smallest == fQ2){
                    q2.addLast(smallest * 2);
                    q3.addLast(smallest * 3);
                    q5.addLast(smallest * 5);
                    q2.removeFirst();
                    continue;
                }

                if(smallest == fQ3){
                    q3.addLast(smallest * 3);
                    q5.addLast(smallest * 5);
                    q3.removeFirst();
                    continue;
                }

                q5.addLast(smallest * 5);
                q5.removeFirst();
            }
            return resultList.get(index - 1);
        }
    }
}
