import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 * Created by Lx on 2016/3/23.
 */
/*
* 题目描述

输入一个字符串,按字典序打印出该字符串中字符的所有排列。
例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。 结果请按字母顺序输出。
输入描述:
输入一个字符串,长度不超过9(可能有字符重复),字符只包括大小写字母。
* */
public class Permutation {
    public class Solution {
        public ArrayList<String> Permutation(String str) {
            ArrayList<Character> charlist = new ArrayList<>();
            ArrayList<String> result = new ArrayList<>();
            for(char a:str.toCharArray()){
                charlist.add(a);
            }
            Collections.sort(charlist);
            permutation(result,charlist,new StringBuilder());
            HashMap<String,Boolean> hashMap = new LinkedHashMap<>();
            for(String s:result){
                hashMap.put(s,true);
            }
            result.clear();
            for(String s:hashMap.keySet()){
                result.add(s);
            }
            return result;
        }

        public void permutation(ArrayList<String> result,ArrayList<Character> charList,StringBuilder sb){
            if(charList.size() == 1){
                sb.append(charList.get(0));
                result.add(sb.toString());
            }
            for(Character a:charList){
                StringBuilder stringBuilder = new StringBuilder(sb.toString());
                stringBuilder.append(a);
                int index = charList.indexOf(a);
                ArrayList<Character> cl = (ArrayList<Character>) charList.clone();
                cl.remove(index);
                permutation(result,cl,stringBuilder);
            }
        }
    }
}
