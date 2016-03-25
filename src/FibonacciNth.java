/**
 * Created by Lx on 2016/3/19.
 */
public class FibonacciNth {
    public class Solution {
        public int Fibonacci(int n) {
            if(n < 2){
                return n;
            }

            int a = 0,b = 1,i = 2;

            while (i++ <= n){
                int temp = a + b;
                a = b;
                b = temp;
            }
            return b;
        }
    }
}
