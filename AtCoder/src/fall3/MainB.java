package fall3; /**
 * Created by wang-zhenjun on 2016/10/15.
 */


import java.util.*;

public class MainB {

    public static int K;
    public static PriorityQueue<String> pq = new PriorityQueue<>(new Comparator<String>() {
        @Override
        public int compare(String o1, String o2) {
            return o1.compareTo(o2);
        }
    });

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();
        K = sc.nextInt();
        sc.close();

        HashMap<Character, Integer> ht = new HashMap<>();

        for (int i = 0; i < str.length(); ++i) {
            char c = str.charAt(i);
            if (ht.containsKey(c)) {
                ht.put(c, ht.get(c) + 1);
            } else {
                ht.put(c, 1);
            }
        }

        dfs(ht, str.length(), str);

        if (!pq.isEmpty()) {
            System.out.println(pq.poll());
        } else {
            System.out.println(str);
        }
    }

    public static void dfs(HashMap<Character, Integer> ht, int N, String str) {
        for (Character c: ht.keySet()) {
            int l = ht.get(c);
            if (N - l >= K) {
                ht.put(c, Integer.MAX_VALUE);

                String substr = str.replace(c.toString(), "");
                pq.add(substr);

                dfs(ht, N - l, substr);
                ht.put(c, l);
            }
        }
    }
}