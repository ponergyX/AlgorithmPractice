/**
 * Created by Lx on 2016/4/12.
 */
/*
* 牛客最近来了一个新员工Fish，每天早晨
* 总是会拿着一本英文杂志，写些句子在本
* 子上。同事Cat对Fish写的内容颇感兴趣，
* 有一天他向Fish借来翻看，但却读不懂它
* 的意思。例如，“student. a am I”。后
* 来才意识到，这家伙原来把句子单词的顺序
* 翻转了，正确的句子应该是“I am a student.”。
* Cat对一一的翻转这些单词顺序可不在行，你能帮助他么？
* */
public class ReverseSentence {
    public static class Solution {
        /*
        * 思想：两次翻转char数组，第一次翻转之后再在第一次翻转的基础上移每个单词为单位进行翻转（用' '分割）,
        * 相对于用栈来实现省去了辅助空间。
        * */
        public String ReverseSentence(String str) {
            if (str.length() < 2){
                return str;
            }

            char[] chars = str.toCharArray();
            reverse(chars,0,chars.length - 1);//第一次翻转，翻转所有字母

            int begin = 0;
            int end = begin;
            while (begin < chars.length){
                if(chars[begin] == ' '){
                    begin++;
                    end++;
                }else if( end >= chars.length || chars[end] == ' '){
                    reverse(chars,begin,--end);
                    begin = ++end;
                }else{
                    end++;
                }
            }
            String result = new String(chars);
            return result;
        }

        public void reverse(char[] chars,int begin,int end){
            while (end > begin){
                char temp = chars[begin];
                chars[begin++] = chars[end];
                chars[end--] = temp;
            }
        }
    }

    public static void main(String[] args){
        ReverseSentence.Solution reverseSentence = new ReverseSentence.Solution();
        System.out.println(reverseSentence.ReverseSentence("I am a student."));
    }
}
