/**
 * Created by wang-zhenjun on 9/3/16.
 */

import java.util.*;

public class ValidParentheses {
    public boolean isValid(String s) {
        HashMap<Character, Character> valid = new HashMap<>();
        valid.put('(', ')');
        valid.put('[', ']');
        valid.put('{', '}');

        Stack<Character> stk = new Stack<>();

        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            if (valid.containsKey(c)) {
                stk.add(c);
            } else {
                if (stk.isEmpty() || valid.get(stk.pop().charValue()) != c) return false;
            }
        }

        if (!stk.isEmpty()) return false;

        return true;
    }

    public static void main(String args[]) {
        ValidParentheses s = new ValidParentheses();
        boolean res = s.isValid("{([])}");
        System.out.println(res);
    }
}
