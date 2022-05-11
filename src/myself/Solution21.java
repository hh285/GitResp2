package myself;

import java.util.ArrayList;
import java.util.List;
//leetcode438
public class Solution21 {
    public List<Integer> findAnagrams(String s, String p) {
        int[] alphm1 = new int[26];
        char[] chars1 = p.toCharArray();
        int len1=s.length();
        int len2=p.length();
        for(int i=0;i<chars1.length;i++){
            alphm1[p.charAt(i)-'a']++;
        }//统计
        List<Integer> res=new ArrayList<>();
        //s中找p
        for(int start=0;start<=len1-len2;start++){
            int[] alphm2=new int[26];
            int k=start;
            for(;k<start+len2;k++){
                alphm2[s.charAt(k)-'a']++;
            }
            int w=0;
            for(;w<26;w++){
                if(alphm1[w]!=alphm2[w]){
                    break;
                }
            }
            if(w>=26){
                res.add(k);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String s = new String("cbaebabacd");
        String t=new String("abc");
        List<Integer> anagrams = new Solution21().findAnagrams(s, t);
        for(int l:anagrams){
            System.out.println(l);
        }
    }
}
