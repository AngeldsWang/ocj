/**
 * Created by wang-zhenjun on 9/4/16.
 */

import java.util.*;
import java.io.*;

public class RecommendCourses {

    public List<String> getDirectFriendsForUser(String user) {
        return new ArrayList<>();
    }

    public List<String> getAttendedCoursesForUser(String user){
        return new ArrayList<>();
    }

    public List<String> getRankedCourses(String user) {

        List<String> result = new ArrayList<>();

        HashMap<String, Integer> courseCount = new HashMap<>();

        Set<String> hasAttended = new HashSet<>();

        for (String course: getAttendedCoursesForUser(user)) {
            hasAttended.add(course);
        }


        for (String fId: getDirectFriendsForUser(user)) {
            List<String> fCourses = getAttendedCoursesForUser(fId);
            for (String cId: fCourses) {
                if (hasAttended.contains(cId)) continue;
                if (courseCount.containsKey(cId)) {
                    courseCount.put(cId, courseCount.get(cId) + 1);
                } else {
                    courseCount.put(cId, 1);
                }
            }
        }

        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>(courseCount.size(), new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });


        for (Map.Entry<String, Integer> course: courseCount.entrySet()) {
            pq.add(course);
        }

        while (!pq.isEmpty()) {
            result.add(pq.poll().getKey());
        }

        return result;
    }

    public static void main(String args[]) {
        RecommendCourses s = new RecommendCourses();
        System.out.println("Hello");
    }
}
