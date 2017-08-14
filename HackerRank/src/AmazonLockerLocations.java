/**
 * Created by wang-zhenjun on 9/4/16.
 */

import java.util.*;

public class AmazonLockerLocations {

    static int[][] getLockerDistanceGrid(int cityLength, int cityWidth, int[] lockerXCoordinates, int[] lockerYCoordinates) {
        int[][] res = new int[cityLength][cityWidth];

        for (int i = 0; i < cityLength; ++i) {
            Arrays.fill(res[i], Integer.MAX_VALUE);
        }

        for (int i = 0; i < lockerXCoordinates.length; ++i) {
            for (int j = 0; j < cityLength; ++j) {
                for (int k = 0; k < cityWidth; ++k) {
                    res[j][k] = Math.min(res[j][k], Math.abs(j + 1 - lockerXCoordinates[i]) + Math.abs(k + 1 - lockerYCoordinates[i]));
                }
            }
        }

        return res;
    }
}
