package fall1; /**
 * Created by wang-zhenjun on 2016/10/15.
 */

import java.util.*;

public class MainA {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();
        sc.close();
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < str.length() - 1) {
            if (str.charAt(i) == 'r' && str.charAt(i + 1) == 'a') {
                i += 2;
                continue;
            }
            sb.append(str.charAt(i));
            i++;
        }

        if (i < str.length()) {
            sb.append(str.charAt(i));
        }

        System.out.println(sb.toString());
    }
}
