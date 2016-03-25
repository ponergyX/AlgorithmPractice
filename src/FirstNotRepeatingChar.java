import java.util.HashMap;

/**
 * Created by Lx on 2016/3/25.
 */
/*
* 在一个字符串(1<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符的位置。若为空串，返回-1。位置索引从0开始
* */
public class FirstNotRepeatingChar {
    public static class Solution {
        public class Item{
            public int index;//下标
            public int number;//数字出现的次数
            public Item(int index,int number){
                this.index = index;
                this.number = number;
            }
        }

        public int FirstNotRepeatingChar(String str) {
            if(str.length() == 0 || str == null){
                return -1;
            }
            HashMap<Character,Item> map = new HashMap<>();
            char[] chars = str.toCharArray();
            for(int i = 0;i < chars.length;i++){
                if(map.get(chars[i]) != null){
                    map.get(chars[i]).number++;
                }else{
                    map.put(chars[i],new Item(i,1));
                }
            }

            int sIndex = str.length();
            for(Character c : map.keySet()){
                System.out.println(c);
                if(map.get(c).number == 1){
                    if(map.get(c).index < sIndex){
                        sIndex = map.get(c).index;
                    }
                }
            }
            return sIndex == str.length() ? -1 : sIndex;
        }
    }

    public static void main(String[] args){
        Solution solution = new FirstNotRepeatingChar.Solution();
        System.out.println(solution.FirstNotRepeatingChar("google"));
    }
}
