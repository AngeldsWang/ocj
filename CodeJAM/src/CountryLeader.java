/**
 * Created by wang-zhenjun on 2016/10/18.
 */

import java.io.*;
import java.util.*;

public class CountryLeader {
    public static void main(String args[]) throws Exception {

        //String name = "A-small-practice";
        String name = "A-large-practice";
        String path = "";

        Scanner sc = new Scanner(new File(path + name + ".in"));
        PrintWriter pw = new PrintWriter(path + name + ".out");
        //Scanner sc = new Scanner(System.in);
        //PrintWriter pw = new PrintWriter(System.out);

        int T = sc.nextInt();
        for (int i = 0; i < T; ++i) {
            int N = sc.nextInt();
            sc.nextLine();
            String[] people = new String[N];
            for (int j = 0; j < N; ++j) {
                people[j] = sc.nextLine();
            }
            String leader = solve(people);
            pw.printf("Case #%d: %s\n", (i + 1), leader);
            pw.flush();
        }

        pw.close();
        sc.close();
    }

    public static String solve(String people[]) {
        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                if (o2.getValue() > o1.getValue()) {
                    return 1;
                } else if (o2.getValue() < o1.getValue()) {
                    return -1;
                }

                if (o1.getKey().compareTo(o2.getKey()) < 0) {
                    return -1;
                } else if (o1.getKey().compareTo(o2.getKey()) > 0) {
                    return 1;
                }

                return 0;
            }
        });

        Map<String, Integer> ht = new HashMap<>();
        for (String name: people) {
            Set<Character> alphas = new HashSet<>();
            for (int i = 0; i < name.length(); ++i) {
                if (name.charAt(i) != ' ') {
                    alphas.add(name.charAt(i));
                }
            }
            ht.put(name, alphas.size());
        }

        for (Map.Entry<String, Integer> entry: ht.entrySet()) {
            pq.add(entry);
        }

        return pq.poll().getKey();
    }
}
