/**
 * Created by Lx on 2016/4/13.
 */
/*
* 给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],
* 其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。不能使用除法。
* */
public class Multiply {
    public static class Solution {
        /*
        * 思想：C[i] = A[0] * A[1] * ```` * A[i - 1],D[i] = A[i+1] * ````* A[n - 1]
        * 可得C[i] = C[i - 1] * A[i - 1],D[i] = A[i + 1] * D[i - 1]
        * 最后的结果为B[i] = C[i] * D[i]
        * */
        public int[] multiply(int[] A) {
            if(A == null || A.length < 2){
                return A;
            }

            int B[] = new int[A.length];

            B[0] = 1;
            for(int i = 1;i < A.length;i++){
                B[i] = A[i - 1] * B[i - 1];
            }

            int temp = 1;
            for(int i = A.length - 2;i >= 0;i--){
                temp *= A[i + 1];
                B[i] *= temp;
            }

            return B;
        }

    }
        public static void main(String[] args){
            Multiply.Solution solution = new Solution();
            solution.multiply(new int[]{1,2,3,4,5});
        }
}
