package cn.wd;

import java.util.HashMap;

public class ewsz {
    public static void main(String[] args) {
        HashMap<String,Integer> map = new HashMap<String,Integer>();
        String str = "服微端云入加迎欢|welcome join us !";

        for(int i = 0 ;i<str.length();i++){
            char c = str.charAt(i);
            String key=String.valueOf(c);
            if(map.containsKey(key)) {
                Integer value=map.get(key);
                map.put(key, value+1);
            }else{
                if(c>='A'&&c<='Z'||c>='a'&&c<='z'){
                    map.put(key, 1);
                }
            }
        }
        System.out.println(map);

        String [] split = str.split("\\|");
        StringBuffer sb = new StringBuffer(split[0]).reverse();
        str = sb.toString()+split[1];
        System.out.println(str);

    }
}
