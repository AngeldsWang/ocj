/**
 * Created by wang-zhenjun on 7/2/16.
 */

import java.util.Scanner;

public class LineBreak {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();

        String []result = str.split(",");

        for (int i = 0; i < result.length; ++i) {
            System.out.println(result[i]);
        }
    }
}
