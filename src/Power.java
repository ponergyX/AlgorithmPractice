/**
 * Created by Lx on 2016/3/19.
 */
public class Power {
    public class Solution {
        public double Power(double base, int exponent) {
            if(exponent == 0){
                return 1;
            }

            if(exponent < 0){
                base = 1 / base;
                exponent *= -1;
            }

            double result = 1;
            for(int i = 1;i <= exponent;i++){
                result *= base;
            }
            return result;
        }
    }
}
