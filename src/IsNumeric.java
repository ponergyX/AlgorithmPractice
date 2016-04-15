/**
 * Created by Lx on 2016/4/15.
 */
public class IsNumeric {
    public class Solution {
        public boolean isNumeric(char[] str) {
            if(str == null || str.length == 0){
                return false;
            }

            int i = 0;
            if(str[i] == '+' || str[i] == '-'){
                i++;
            }
            i = scanNumber(str,i);
            if(i != str.length){
                if(str[i] == '.'){
                    i = scanNumber(str,++i);
                    if(i != str.length && (str[i] == 'E' || str[i] == 'e')){
                        i = scanE(str,++i);
                    }
                }else if(str[i] == 'E' || str[i] == 'e'){
                    i = scanE(str,++i);
                }
            }
            return i == str.length;
        }

        public int scanNumber(char[] str,int i){
            for(;i < str.length;i++){
                if(str[i] < '0' || str[i] > '9'){
                    return i;
                }
            }
            return str.length;
        }

        public int scanE(char[] str,int i){
            if(i == str.length){
                return str.length + 1;
            }
            if(str[i] == '+' || str[i] == '-'){
                i = scanNumber(str,++i);
            }else{
                i = scanNumber(str,i);
            }
            return i;
        }
    }
}
