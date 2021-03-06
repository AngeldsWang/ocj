package fall2; /**
 * Created by wang-zhenjun on 2016/10/15.
 */

import java.util.Scanner;

public class MainA {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; ++i) {
            arr[i] = sc.nextInt();
        }
        sc.close();

        int count = 0;
        for (int i = 1; i < N - 1; ++i) {
            if (arr[i] > arr[i - 1] && arr[i] > arr[i + 1]) {
                count++;
            }
        }

        System.out.println(count);
    }
}
