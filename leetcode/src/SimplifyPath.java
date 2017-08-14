/**
 * Created by wang-zhenjun on 9/3/16.
 */

import java.util.*;

public class SimplifyPath {
    public String simplifyPath(String path) {
        List<String> dirs = new ArrayList<>();

        int i = 1;
        while (i < path.length()) {
            int j = path.indexOf('/', i);
            if (j == -1) j = path.length();
            String dir = path.substring(i, j);

            if (!dir.isEmpty() && !dir.equals(".")) {
                if (dir.equals("..")) {
                    if (dirs.size() > 0) {
                        dirs.remove(dirs.size() - 1);
                    }
                } else {
                    dirs.add(dir);
                }
            }

            i = j + 1;
        }

        StringBuilder sb = new StringBuilder();
        if (dirs.isEmpty()) {
            sb.append("/");
        } else {
            for (String dir : dirs) {
                sb.append("/").append(dir);
            }
        }

        return sb.toString();
    }

    public static void main(String args[]) {
        SimplifyPath s = new SimplifyPath();
        String res = s.simplifyPath("/.");
        System.out.println(res);
    }
}
