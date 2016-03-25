/**
 * Created by Lx on 2016/3/18.
 */
public class TwoDimensionArraySearch {
    public boolean Find(int [][] array,int target) {
        int i = array.length - 1;
        int m = 0;
        while (i >= 0 && m < array[0].length){
            if(target < array[i][m]){
                i--;
            }else if(target > array[i][m]){
                m++;
            }else{
                return true;
            }
        }
        return false;
    }
}
