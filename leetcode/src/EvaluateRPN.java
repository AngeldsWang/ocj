/**
 * Created by wang-zhenjun on 9/3/16.
 */

import java.util.*;

public class EvaluateRPN {
    public int evalRPN(String[] tokens) {
        Set<String> validOP = new HashSet<>();
        validOP.add("+");
        validOP.add("-");
        validOP.add("*");
        validOP.add("/");

        Stack<Integer> stk = new Stack<>();

        for (int i = 0; i < tokens.length; ++i) {
            if (!validOP.contains(tokens[i])) {
                stk.push(Integer.parseInt(tokens[i]));
                continue;
            } else {
                int op1 = stk.pop();
                int op2 = stk.pop();
                int tmp;
                if (tokens[i].equals("+")) {
                    tmp = op1 + op2;
                } else if (tokens[i].equals("-")) {
                    tmp = op2 - op1;
                } else if (tokens[i].equals("*")) {
                    tmp = op1 * op2;
                } else {
                    tmp = op2 / op1;
                }

                stk.push(tmp);
            }
        }

        return stk.pop();
    }

    public static void main(String args[]) {
        EvaluateRPN s = new EvaluateRPN();
        int res = s.evalRPN(new String[] {"4", "13", "5", "/", "+"});
        System.out.println(res);
    }
}
