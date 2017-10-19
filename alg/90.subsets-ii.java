import java.util.*;
class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums)
            map.put(n, map.getOrDefault(n, 0) + 1);
        List<List<Integer>> res = new ArrayList<>();
        for (int key : map.keySet()) {
            List<List<Integer>> sets = getSet(key, map.get(key));
            List<List<Integer>> resTmp = new ArrayList<List<Integer>>();
            for (List<Integer> list : res) {
                for (List<Integer> set : sets) {
                    List<Integer> tmp = new ArrayList<>(list);
                    tmp.addAll(set);
                    resTmp.add(tmp);
                }
            }
            if (!resTmp.isEmpty())
                res.addAll(resTmp);
            res.addAll(sets);
        }
        res.add(0, new ArrayList<>());
        return res;
    }

    private List<List<Integer>> getSet(int key, int count) {
        List<Integer> list = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            list.add(key);
            res.add(new ArrayList<Integer>(list));
        }
        return res;
    }
}
