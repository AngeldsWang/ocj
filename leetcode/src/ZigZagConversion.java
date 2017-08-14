/**
 * Created by wang-zhenjun on 8/21/16.
 */

import java.util.*;

public class ZigZagConversion {
    public String convert(String s, int numRows) {
        List<ArrayList<Character>> arr = new ArrayList<>();

        for (int i = 0; i < numRows; ++i) {
            arr.add(new ArrayList<>());
        }

        int i = numRows - 1;
        int t = 1;
        boolean f = true;
        for (; i < s.length(); i += (2 * numRows - 2)) {
            arr.get(numRows - 1).add(s.charAt(i));
            f = true;
            for (int j = numRows - 2; j >= 0; j--, t++) {
                arr.get(j).add(s.charAt(i - t));
                if (i + t < s.length()) {
                    arr.get(j).add(s.charAt(i + t));
                } else {
                    f = false;
                    break;
                }
            }
            if (f) {
                arr.get(0).remove(arr.get(0).size() - 1);
            }
        }
        i -= (2 * numRows - 2);
        t--;
        int r = 0;
        if (f) {
            while (i + t < s.length()) {
                arr.get(r).add(s.charAt(i + t));
                t++;
                r++;
            }
        }

        StringBuilder sb = new StringBuilder(s.length());

        for (ArrayList<Character> row : arr) {
            for (Character c : row) {
                sb.append(c);
            }
        }
        //sb.append(s.charAt(s.length() - 1));

        return sb.toString();
    }

    public static void main(String args[]) {
        ZigZagConversion zzc = new ZigZagConversion();

        String sr = zzc.convert("PAYPALISHIRING", 3);

        System.out.println(sr);
    }
}
