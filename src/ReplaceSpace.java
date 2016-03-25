/**
 * Created by Lx on 2016/3/19.
 */
public class ReplaceSpace {
    public String replaceSpace(StringBuffer str) {
        if(str == null){
            return null;
        }


        StringBuilder sb = new StringBuilder();
        for(int i = 0;i < str.length();i++){
            if(str.charAt(i) == ' '){
                sb.append("%20");
            }else{
                sb.append(str.charAt(i));
            }
        }

        return sb.toString();
    }
}
