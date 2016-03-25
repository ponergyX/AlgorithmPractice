import java.util.ArrayList;

/**
 * Created by Lx on 2016/3/20.
 */
public class PrintMatrix {

    /*
    * 思想：记录对角线的两个订单的坐标，在一次while循环中分别对四条边进行输出，然后将对角线的顶点往里缩一格
    * */
    public class Solution {
        public ArrayList<Integer> printMatrix(int [][] matrix) {
            ArrayList<Integer> list = new ArrayList<>();
            if(matrix.length == 0 || matrix[0].length == 0){
                return list;
            }
            int top = 0,left = 0,right = matrix[0].length - 1,bottom = matrix.length - 1;
            while (top <= bottom && right >= left){
                for (int i = left;i <= right;i++){
                    list.add(matrix[top][i]);
                }

                for (int i = top + 1;i <= bottom;i++){
                    list.add(matrix[i][right]);
                }

                //判断是否是单行
                if(top != bottom){
                    for(int i = right - 1;i >= left;i--){
                        list.add(matrix[bottom][i]);
                    }
                }

                //判断是否是单列
                if(left != right){
                    for(int i = bottom - 1;i >= top + 1;i--){
                        list.add(matrix[i][left]);
                    }
                }

                top++;
                left++;
                right--;
                bottom--;
            }
            return list;
        }
    }
}
