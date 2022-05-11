package myself;

import java.util.*;

//leetcode20
class Vaildkh {
    public boolean isValid(String s) {//只有一种括号
        int len = s.length(), left = 0;
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                left--;
            }
            if (left < 0) {
                return false;
            }
        }
        return left == 0 ? true : false;
    }

    public boolean isValid2(String s) {//多种括号
        int len = s.length();
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for (char p : chars) {
            if (p == '(' || p == '{' || p == '[') {
                stack.add(p);
            } else {
                if (stack.peek() == convert(p)) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        if (stack.isEmpty()) {
            return true;
        }
        return false;
    }
    public char convert(char s) {
        if (s == ')') {
            return '(';
        } else if (s == '}') {
            return '{';
        }
        return '[';
    }

    //leetcode921
    public int minAddToMakeValid(String s) {//只有()
        int len = s.length(), need = 0, res = 0;
        char[] chars = s.toCharArray();
        for (char p : chars) {
            if (p == '(') {
                need++;
            } else {
                need--;
                if (need == -1) {
                    res++;
                    need = 0;
                }
            }
        }
        res+=need;
        return res;
    }

    //leetcode1541
    public int minInsertions(String s) {
        int len = s.length(), need = 0, res = 0;
        char[] chars = s.toCharArray();
        for (char p : chars) {
            if (p == '(') {
                need += 2;
                if (need % 2 == 1) {
                    res++;
                    need--;
                }
            } else {//遇到了右括号
                need--;
                if (need == -1) {
                    res++;
                    need = 1;
                }
            }
        }
        res = res + need;
        return res;
    }

//    leetcode32
//    dp[i]表示以下标i字符结尾的最长有效括号的长度。
//    dp[i]=dp[i−1]+dp[i−dp[i−1]−2]+2
//    dp[i]=dp[i−2]+2

    public int longestValidParentheses(String s) {
        int ans = 0;
        int[] dp = new int[s.length()];
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                } else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                    dp[i] = dp[i - 1] + ((i - dp[i - 1]) >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
                }
                ans = Math.max(ans, dp[i]);
            }
        }
//Collection  isEmpty() size()  iterator() addAll  removeAll equals
        return ans;

//        Collections.sort();
//        Collections.reverse();
//        Collections.max();
//                    binarySearch
//                    Fill

    }
}
//String res="da";

//常用方法：length charAt split toLowerCase() toUpperCase() equals substring
//indexOf replace contains
//startsWith(String prefix)：判断字符串是否以指定的前缀开始
