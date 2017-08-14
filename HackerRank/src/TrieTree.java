/**
 * Created by wang-zhenjun on 9/4/16.
 */

import java.util.*;

public class TrieTree {
    private TrieNode root;

    public TrieTree() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        TrieNode cur = root;
        for (int i = 0; i < word.length(); ++i) {
            if (!cur.containsKey(word.charAt(i))) {
                cur.put(word.charAt(i), new TrieNode());
            }
            cur = cur.get(word.charAt(i));
            cur.increaseCount();
        }
        cur.setEnd();
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        TrieNode cur = root;
        for (int i = 0; i < word.length(); ++i) {
            if (cur.containsKey(word.charAt(i))) {
                cur = cur.get(word.charAt(i));
            } else {
                return false;
            }
        }

        return cur.isEnd();
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        TrieNode cur = root;
        for (int i = 0; i < prefix.length(); ++i) {
            if (cur.containsKey(prefix.charAt(i))) {
                cur = cur.get(prefix.charAt(i));
            } else {
                return false;
            }
        }

        return true;
    }

    public int startsWithCount(String prefix) {
        TrieNode cur = root;
        for (int i = 0; i < prefix.length(); ++i) {
            if (cur.containsKey(prefix.charAt(i))) {
                cur = cur.get(prefix.charAt(i));
            } else {
                return 0;
            }
        }

        return cur.getCount();
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());

        TrieTree tt = new TrieTree();

        for (int i = 0; i < N; ++i) {
            String[] line = sc.nextLine().split(" ");
            if (line[0].equals("add")) {
                tt.insert(line[1]);
            } else if (line[0].equals("find")) {
                System.out.println(tt.startsWithCount(line[1]));
            }
        }

        sc.close();
    }
}

class TrieNode {
    // R links to node children
    private TrieNode[] links;

    private final int R = 26;

    private boolean isEnd;

    private int count;

    public TrieNode() {
        count = 0;
        links = new TrieNode[R];
    }

    public boolean containsKey(char ch) {
        return links[ch -'a'] != null;
    }

    public TrieNode get(char ch) {
        return links[ch -'a'];
    }

    public void put(char ch, TrieNode node) {
        links[ch -'a'] = node;
    }

    public void setEnd() {
        isEnd = true;
    }

    public boolean isEnd() {
        return isEnd;
    }

    public void increaseCount() {
        count++;
    }

    public int getCount() {
        return count;
    }
}