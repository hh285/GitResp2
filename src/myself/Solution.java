package myself;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
//
public class Solution {
   public List<List<String>> groupAnagrams(String[] strs) {
       HashMap<String, List<String>> map = new HashMap<>();
       for(String p:strs){
           String cur=convert(p);
           List<String> list = map.get(cur);
           list.add(p);
           map.put(cur,list);
       }
       List<List<String>> res=new ArrayList<>();
       for(Map.Entry q:map.entrySet()){
           List<String> value =(List<String>)q.getValue();
           res.add(value);
       }
       return res;
   }
   public String convert(String p){
       int[] alph=new int[26];
       char[] chars = p.toCharArray();
       for(char t:chars){
           alph[t-'a']++;
       }
       StringBuilder stringBuilder = new StringBuilder();
       for (int i=0;i<26;i++){
           while(alph[i]>0){
               stringBuilder.append(i+'a');
               alph[i]--;
           }
       }
       return stringBuilder.toString();
   }

    public static void main(String[] args) {

    }
}
