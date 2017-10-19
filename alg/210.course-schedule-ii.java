import java.util.*;
class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, Set<Integer>> map = new HashMap<>(),
                                   rmap = new HashMap<>();
        for (int[] pre : prerequisites) {
            Set<Integer> set = map.getOrDefault(pre[0], new HashSet<>()),
                         rset = map.getOrDefault(pre[0], new HashSet<>());
            set.add(pre[1]);
            rset.add(pre[0]);
            map.put(pre[0], set);
            rmap.put(pre[1], rset);
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < numCourses; i++)
            if (!map.containsKey(i))
                list.add(i);
        List<Integer> res = new ArrayList<>();
        while (true) {
            if (list.isEmpty()) {
                if (res.size() < numCourses) 
                    return new int[0];
                else break;
            }
            res.addAll(list);
            List<Integer> next = new ArrayList<>();
            for (int course : list) {
                if (!rmap.containsKey(course)) continue;
                Set<Integer> rset = rmap.get(course);
                for (int k : rset) {
                    Set<Integer> set = map.get(k);
                    if (set == null || set.size() == 1) next.add(k);
                    else set.remove(new Integer(course));
                }
            }
            list = next;
        }
        int[] arr = new int[numCourses];
        for (int i = 0; i < numCourses; i++)
            arr[i] = res.get(i);
        return arr;
    }
}
