/**
 * Created by Lx on 2016/4/13.
 */
/*
* 将一个字符串转换成一个整数，要求不能使用字符串转换整数的库函数。
* */
public class StrToInt {
    public class Solution {
        public int StrToInt(String str) {
            int result = 0;
            if(str == null || str.length() == 0){
                return result;
            }
            boolean positive = true;

            //检测最开始的正负号
            int i = 0;
            if(str.charAt(i) == '-'){
                positive = false;
                i++;
            }else if(str.charAt(i) == '+'){
                positive = true;
                i++;
            }

            while (i < str.length()){
                if (str.charAt(i) <= '9' && str.charAt(i) >= '0'){
                    result = result*10 + (str.charAt(i++) - '0');
                }else{//出现字母的情况
                    result = 0;
                    break;
                }
            }

            result = positive? result : -1 * result;
            return result;
        }
    }
}
