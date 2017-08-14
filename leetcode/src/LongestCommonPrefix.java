/**
 * Created by wang-zhenjun on 9/3/16.
 */

import java.util.*;

public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";

        for (int i = 0; i < strs[0].length(); ++i) {
            for (int j = 0; j < strs.length - 1; ++j) {
                if (Math.min(strs[j].length(), strs[j + 1].length()) <= i ||
                        strs[j].charAt(i) != strs[j + 1].charAt(i)) {
                    return strs[0].substring(0, i);
                }
            }
        }

        return strs[0];
    }

    public static void main(String args[]) {
        LongestCommonPrefix s = new LongestCommonPrefix();
        String res = s.longestCommonPrefix(new String[] {"aa", "a"});
        System.out.println(res);
    }
}
