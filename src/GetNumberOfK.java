/**
 * Created by Lx on 2016/3/25.
 */
/*
* 统计一个数字在排序数组中出现的次数。
* */
public class GetNumberOfK {
    public static class Solution {
        /*public int GetNumberOfK(int [] array , int k) {
            if(array.length == 0){
                return 0;
            }

            int result = 0;
            for(int i = 0;i < array.length;i++){
                if(k == array[i]){
                    result++;
                }

                if(result > 0 && k != array[i]){
                    break;
                }
            }

            return result;
        }*/


        /*
        * 剑指offer书中思想：利用二分查找的特点，若mid等于k则查看他前面的数是否为k，若为k继续二分查找mid前面的部分，知道找到
        * 第一个k的开始的下标。找最后一个k的下标思想同第一个k一样，最后通过得到的下标来计算k的个数。时间复杂度为O（lgn)交线性
        * 查找的复杂度O（n）来说更好
        * */
        public int GetNumberOfK(int [] array,int k){
            int firstK = getFirstK(array,k,0,array.length - 1);
            int lastK = getLastK(array,k,0,array.length - 1);
            int number = 0;
            if(lastK > -1 && firstK > -1){
                number = lastK - firstK + 1;
            }
            return number;
        }

        public int getFirstK(int[] array,int k,int start,int end){
            if(start > end){
                return -1;
            }

            int mid = (start + end) / 2;
            if(array[mid] == k){
                if((mid - 1 >= start && array[mid - 1] != k) || mid == start){
                    return mid;
                }else{
                    end = mid - 1;
                }
            }else if(array[mid] > k){
                end = mid - 1;
            }else{
                start = mid + 1;
            }
            return getFirstK(array,k,start,end);
        }

        public int getLastK(int[] array,int k,int start,int end){
            if(start > end){
                return -1;
            }

            int mid = (start + end) / 2;
            if(array[mid] == k){
                if((mid + 1 <= end && array[mid + 1] != k) || mid == end){
                    return mid;
                }else{
                    start = mid + 1;
                }
            }else if(array[mid] > k){
                end = mid - 1;
            }else{
                start = mid + 1;
            }
            return getLastK(array,k,start,end);
        }
    }

    public static void main(String[] args){
        Solution solution = new GetNumberOfK.Solution();
        solution.GetNumberOfK(new int[]{3,3,3,3,4,5},3);
    }
}
