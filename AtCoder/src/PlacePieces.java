/**
 * Created by wang-zhenjun on 7/2/16.
 */

import java.util.*;

public class PlacePieces {

    static int G[][];

    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);

        G = new int[7][7];
        for (int i = 1; i <= 6; ++i) {
            for(int j = 1; j <= 6; ++j) {
                char c = (char)sc.nextByte();
                if ( c == 'o' ) {
                    G[i][j] = 1;
                }
            }
        }

        if ( !check_s() ) {
            System.out.println(0);
            return;
        }

        for (int i = 1; i <= 6; ++i) {

        }
    }

    public static boolean check_s() {
        for (int i = 1; i <= 6; ++i) {
            int sum_row = 0;
            int sum_col = 0;
            for (int j = 1; j <= 6; ++j) {
                sum_row += G[i][j];
                sum_row += G[j][i];
            }

            if ( sum_row > 3 || sum_col > 3 ) {
                return false;
            }
        }

        return true;
    }

    public static boolean check_e() {
        for (int i = 1; i <= 6; ++i) {
            int sum_row = 0;
            int sum_col = 0;
            for (int j = 1; j <= 6; ++j) {
                sum_row += G[i][j];
                sum_row += G[j][i];
            }

            if ( sum_row != 3 || sum_col != 3 ) {
                return false;
            }
        }

        return true;
    }

    public static boolean check_col(int col) {
        int sum = 0;
        for (int i = 1; i<= 6; ++i) {
            sum += G[i][col];
        }

        if (sum < 3) {
            return true;
        }

        return false;
    }
}
