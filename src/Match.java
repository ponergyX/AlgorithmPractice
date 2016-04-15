/**
 * Created by Lx on 2016/4/13.
 */
/*
* 请实现一个函数用来匹配包括'.'和'*'的正则表达式。
* 模式中的字符'.'表示任意一个字符，而'*'表示它前
* 面的字符可以出现任意次（包含0次）。 在本题中，
* 匹配是指字符串的所有字符匹配整个模式。例如，字
* 符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但是与"
* aa.a"和"ab*a"均不匹配
* */
public class Match {
    public static class Solution {
        /*
        * 思想：递归，当第二个字符为*时需要特殊处理，可以跨过两步（当做包含该字母0次），也可以匹配一次，也可以匹配一个str中的字符
        * 然后继续处于次状态
        * */
        public boolean match(char[] str, char[] pattern)
        {
            if(str == null || pattern == null){
                return false;
            }
            return matchCore(str,pattern,0,0);
        }

        public boolean matchCore(char[] str,char[] pattern,int sIndex,int pIndex){
            if(sIndex == str.length && pIndex == pattern.length){
                return true;
            }

            if(sIndex != str.length && pIndex == pattern.length){
                return false;
            }

            if(pIndex < pattern.length - 1 && pattern[pIndex + 1] == '*'){
                if(sIndex < str.length && (str[sIndex] == pattern[pIndex] || pattern[pIndex] == '.')){
                    return matchCore(str,pattern,sIndex + 1,pIndex + 2) ||
                            matchCore(str,pattern,sIndex + 1,pIndex) ||
                            matchCore(str,pattern,sIndex,pIndex + 2);
                }else{
                    return matchCore(str,pattern,sIndex,pIndex + 2);
                }
            }

            if(sIndex < str.length && (pattern[pIndex] == str[sIndex]) || pattern[pIndex] == '.'){
                return matchCore(str,pattern,sIndex + 1,pIndex + 1);
            }

            return false;
        }
    }

    public static void main(String[] args){
    }
}
