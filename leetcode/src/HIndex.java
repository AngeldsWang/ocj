/**
 * Created by wang-zhenjun on 2016/10/12.
 */

import java.util.*;

public class HIndex {
    public int hIndex(int[] citations) {
        if (citations.length == 0) return 0;
        List<Integer> cites = new ArrayList<>(citations.length);
        for (int i: citations) {
            cites.add(i);
        }
        Collections.sort(cites, Collections.reverseOrder());

        int hIndex = citations.length;
        int low    = 0;
        int high   = citations.length;
        int bias   = bias_hIndex(hIndex, cites);
        while (bias != 0) {
            if (bias < 0) {
                low = hIndex;
            } else {
                high = hIndex;
            }
            hIndex = (low + high) / 2;
            bias = bias_hIndex(hIndex, cites);
        }

        return hIndex;
    }

    public int bias_hIndex(int hIndex, List<Integer> cites) {
        if (hIndex < 0) return -1;
        if (hIndex == 0) return  0;
        if (hIndex > cites.size()) return 1;

        int sub = cites.get(hIndex - 1);
        int other = -1;
        if (hIndex < cites.size()) {
            other = cites.get(hIndex);
        }

        if (sub >= hIndex) {
            if (other < 0 || other <= hIndex) {
                return 0;
            } else {
                return -1;
            }
        }

        return 1;
    }

    public static void main(String args[]) {
        int[] citations = {0};
        HIndex s = new HIndex();
        int hIndex = s.hIndex(citations);
        System.out.println(hIndex);
    }
}
