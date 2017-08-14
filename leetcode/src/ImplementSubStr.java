/**
 * Created by wang-zhenjun on 9/2/16.
 */

import java.util.*;

public class ImplementSubStr {
    public int strStr(String haystack, String needle) {
        if (haystack == null || needle == null) return -1;
        if (needle.length() == 0 && haystack != null) return 0;

        int start = 0;
        int cur;

        for (int i = 0; i <= haystack.length() - needle.length(); ++i) {
            if (haystack.charAt(i) == needle.charAt(0)) {
                start = i;
                int j = 1;
                for (; j < needle.length(); ++j) {
                    if (haystack.charAt(i + j) != needle.charAt(j)) {
                        break;
                    }
                }
                if (j == needle.length()) {
                    return start;
                }
            }
        }

        return -1;
    }

    public static void main(String args[]) {
        ImplementSubStr s = new ImplementSubStr();
        int res = s.strStr("hayahello", "");
        System.out.println(res);
    }
}
