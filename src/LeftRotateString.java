/**
 * Created by Lx on 2016/4/12.
 */
/*
* 汇编语言中有一种移位指令叫做循环左移（ROL）
* ，现在有个简单的任务，就是用字符串模拟这个
* 指令的运算结果。对于一个给定的字符序列S，
* 请你把其循环左移K位后的序列输出。例如，
* 字符序列S=”abcXYZdef”,要求输出循环左移3位后的结果，
* 即“XYZdefabc”。是不是很简单？OK，搞定它！*/
public class LeftRotateString {
    public class Solution {
        /*public String LeftRotateString(String str,int n) {
            if(str.length() < n){
                return str;
            }

            String pre = str.substring(0,n);
            String suff = str.substring(n,str.length());
            String result = suff + pre;
            return result;
        }
*/

        /*
        * 思想：将原str的char数组分为两部分，即用下标n分割开来，分别对两部分就行反转，然后再对整个数组进行反转，
        * 即共进行3次反转。
        * */
        public String LeftRotateString(String str,int n) {
            if(str.length() < n){
                return str;
            }

            char[] chars = str.toCharArray();
            reverse(chars,0,n - 1);
            reverse(chars,n,chars.length - 1);
            reverse(chars,0,chars.length - 1);
            return new String(chars);
        }

        public void reverse(char[] chars,int begin,int end){
            while (end > begin){
                char temp = chars[begin];
                chars[begin++] = chars[end];
                chars[end--] = temp;
            }
        }
    }
}
