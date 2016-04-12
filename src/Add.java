/**
 * Created by Lx on 2016/4/12.
 */
/*
* 写一个函数，求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号。
* */
public class Add {
    public class Solution {
        /*
        * 思想：位运算，先按位加不进位，该过程相当于异或，然后在求进位结果，该过程相当于与运算并左移一位，
        * 然后再相加进位和之前的不按进位加的结果，知道进位为0
        * */
        public int Add(int num1,int num2) {
            int sum = 0,carry = 0;
            do {
                sum = num1 ^ num2;
                carry = (num1 & num2) << 1;
                num1 = sum;
                num2 = carry;
            }while (num2 != 0);
            return sum;
        }
    }
}
