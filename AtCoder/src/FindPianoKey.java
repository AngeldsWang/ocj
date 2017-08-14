/**
 * Created by wang-zhenjun on 6/11/16.
 */

import java.util.Scanner;

public class FindPianoKey {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        // 白黒白黒白白黒白黒白黒白
        String pattern = "WBWBWWBWBWBW";

        String temp[] = {"Do", "Do", "Re", "Re", "Mi", "Fa", "Fa", "So", "So", "La", "La", "Si"};

        // WBWBWWBWBWBWWBWBWWBW Do
        // BWBWWBWBWBW WBWBWWBWBWBW
        int beginIdx = str.indexOf(pattern);

        if (beginIdx >= 0) {
            System.out.println(temp[(temp.length - beginIdx) % temp.length]);
        } else {
            int miIdx = str.indexOf("WW");
            if (miIdx > 2) {
                System.out.println("Do");
            } else {
                System.out.println("Re");
            }
        }
    }
}
