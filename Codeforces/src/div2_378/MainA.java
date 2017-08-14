package div2_378;

/**
 * Created by wang-zhenjun on 2016/10/31.
 */

import java.util.*;

public class MainA {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        sc.close();

        Set<Character> set = new HashSet<>(Arrays.asList('A', 'E', 'I', 'O', 'U', 'Y'));

        int min = 1;
        int cur = -1;
        for (int i = 0; i < str.length(); ++i) {
            if (set.contains(str.charAt(i))) {
                if (i - cur > min) {
                    min = i - cur;
                }
                cur = i;
            }
        }
        if (str.length() - cur > min) {
            min = str.length() - cur;
        }

        System.out.println(min);
    }
}
