/**
 * Created by Lx on 2016/3/19.
 */
public class RectCover {
    /*
    * 思想：若横放一块砖则还有target - 1块砖可以任意摆放，但若竖放一块砖则其旁边的一块也必为竖放，因此还有target-2块砖可以任意摆放
    * */
    public int RectCover(int target) {
        if(target <= 1){
            return 1;
        }else if(target == 2){
            return 2;
        }else{
            return  RectCover(target - 1) + RectCover(target - 2);
        }
    }
}
