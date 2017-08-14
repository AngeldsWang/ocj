package fall3; /**
 * Created by wang-zhenjun on 2016/10/15.
 */

import java.util.*;

public class MainC {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.close();

        int num = N;
        int length = 0;
        while (num > 0) {
            num /= 10;
            length++;
        }

        int i = 2;
        int target = N * i;
        int count = 0;
        while (target < Math.pow(10, length)) {
            if (is_per(target, N)) {
                count++;
            }
            i++;
            target = N * i;
        }

        System.out.println(count);
    }

    public static boolean is_per(Integer n1, Integer n2) {
        return checkAnagram(n1.toString(), n2.toString());
    }

    public static boolean checkAnagram(String str1, String str2) {

        if (str1.length() != str2.length())
            return false;

        char[] a = str1.toCharArray();
        char[] b = str2.toCharArray();

        Arrays.sort(a);
        Arrays.sort(b);

        return Arrays.equals(a, b);
    }
}