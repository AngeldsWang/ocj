/**
 * Created by wang-zhenjun on 9/3/16.
 */

import java.util.*;

public class LongestValidParentheses {
    public int longestValidParentheses(String s) {
        int max = 0;
        int start = -1;

        Stack<Integer> stk = new Stack<>();

        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == '(') {
                stk.push(i);
            } else {
                if (stk.isEmpty()) {
                    start = i;
                } else {
                    stk.pop();
                    if (stk.isEmpty()) max = Math.max(max, i - start);
                    else max = Math.max(max, i - stk.peek());
                }
            }
        }

        return max;
    }

    public static void main(String args[]) {
        LongestValidParentheses s = new LongestValidParentheses();
        int res = s.longestValidParentheses("()()((()");
        System.out.println(res);
    }
}
