/**
 * Created by wang-zhenjun on 9/3/16.
 */

import java.util.*;

public class LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        String[] words = s.split("\\s+");
        if (words.length == 0) return 0;
        return words[words.length - 1].length();
    }

    public static void main(String args[]) {
        LengthOfLastWord s = new LengthOfLastWord();
        int res = s.lengthOfLastWord(" ");
        System.out.println(res);
    }
}
