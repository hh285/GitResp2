package myself;

public class Solution17 {
    public String code(String nums){
        int len=nums.length();
        StringBuilder res = new StringBuilder();
        for(int i=0;i<len;){
            int temp=1;
            while (i<len-1&&nums.charAt(i)==nums.charAt(i+1)){
                temp++;
                i++;
            }
            res.append(temp);
            res.append(nums.charAt(i));
            i++;
        }
        return res.toString();
    }

    public static void main(String[] args) {
        String t="aaabbcc";
        String code = new Solution17().code(t);
        System.out.println(code);
    }
}
