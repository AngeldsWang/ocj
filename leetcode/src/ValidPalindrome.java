/**
 * Created by wang-zhenjun on 9/2/16.
 */

import java.util.*;

public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        if (s.length() == 0 || s == null) return true;

        int i = 0;
        int j = s.length() - 1;

        while (i < j) {
            while (i < j && !Character.isLetterOrDigit(s.charAt(i))) {
                i++;
            }

            while (i < j && !Character.isLetterOrDigit(s.charAt(j))) {
                j--;
            }

            if (Character.toLowerCase(s.charAt(i)) == Character.toLowerCase(s.charAt(j))) {
                i++;
                j--;
            } else {
                return false;
            }
        }

        return true;
    }

    public static void main(String args[]) {
        ValidPalindrome s = new ValidPalindrome();
        boolean res = s.isPalindrome("A man, a plan, a canal: Panama");
        System.out.println(res);
    }
}
