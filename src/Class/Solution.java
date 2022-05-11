package Class;

public class Solution {

    public static void main(String[] args) {
        String s1=new String("java");
        String s2=s1.intern();
        String s3="java";
        System.out.println(s1==s2);
        System.out.println(s2==s3);
    }
}
