/**
 * Created by wang-zhenjun on 8/29/16.
 */

//import java.util.*;
//
//public class ValidSentence {
//    private static final String[] SET_VALUES   = {"he", "here", "we", "go", "rewe"};
//    private static final Set<String> VALID_SET = new HashSet<>(Arrays.asList(SET_VALUES));
//    public static boolean isValidWord(String w) {
//        if (VALID_SET.contains(w)) {
//            return true;
//        }
//
//        return false;
//    }
//
//    public List<String> constructSentence(String str) {
//        if (str.length() == 0) return null;
//        List<String> res = construct(str, 0, 1);
//        return String.join(" ", res);
//    }
//
//    public List<List<String>> construct(String str, int start, int end) {
//        if (str == null || start > end) return null;
//        if (end > str.length()) {
//            if (end - start == 1) {
//                return new ArrayList<>();
//            } else {
//                return null;
//            }
//        }
//
//        String cur = str.substring(start, end);
//        if (isValidWord(cur)) {
//            List<String> curRes = construct(str, end, end + 1);
//            if (curRes != null) {
//                curRes.add(0, cur);
//                return curRes;
//            }
//        }
//
//        return construct(str, start, end + 1);
//    }
//
//    public static void main(String args[]) {
//        ValidSentence s = new ValidSentence();
//        String res = s.constructSentence("herewego");
//        System.out.println(res);
//    }
//}
