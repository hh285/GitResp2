package myself;

import java.util.Stack;

//s = "3[a2[c]]"
//    3 [acc
//输出："accaccacc"
public class Solution4 {
    public String decodeString(String s) {
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        int len = chars.length;
        StringBuilder res=new StringBuilder();
        for (int i = 0; i < len; i++) {
            if((chars[i]>='0'&&chars[i]<='9')
            ||(chars[i]=='[')||(chars[i]>='a'&&chars[i]<='z')){
                stack.add(chars[i]);
            }
            else{//碰到‘]’
                StringBuilder stringBuilder = new StringBuilder();
                while(!stack.isEmpty()&&stack.peek()!='['){
                    Character pop = stack.pop();
                    stringBuilder.append(pop);
                }
                if (!stack.isEmpty()) {
                    stack.pop();
                }
                StringBuilder Mul=new StringBuilder();
                while (!stack.isEmpty()&&(stack.peek()>='0'&&stack.peek()<='9')) {
                    Character temp=stack.pop();
                    Mul.append(temp);
                }
                int mul=0;
                if (Mul != null) {
                    mul = Integer.valueOf(Mul.reverse().toString());
                }
                StringBuilder base=new StringBuilder(stringBuilder.reverse());
                for(int j=0;j<mul-1;j++){
                    stringBuilder.append(base);
                }//此部分结束了
                for(int k=0;k<stringBuilder.length();k++){
                    stack.add(stringBuilder.charAt(k));
                }
            }
        }
        while (!stack.isEmpty()){
            res.append(stack.pop());
        }
        String s1 = res.reverse().toString();
        return s1;
    }

    public static void main(String[] args) {
        String s="10[abc]";
        String s1 = new Solution4().decodeString(s);
        System.out.println(s1);
    }
}
