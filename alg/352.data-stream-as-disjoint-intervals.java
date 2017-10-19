/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
import java.util.*;
class SummaryRanges {
    Map<Integer, Integer> headMap, tailMap;
    Set<Integer> visited;
    /** Initialize your data structure here. */
    public SummaryRanges() {
        headMap = new HashMap<>();
        tailMap = new HashMap<>();
        visited = new HashSet<>();
    }
    
    public void addNum(int val) {
        if (visited.contains(val)) return;
        visited.add(val);
        int newHead = val, newTail = val;
        if (headMap.containsKey(val + 1))
            newTail = headMap.remove(val + 1);
        if (tailMap.containsKey(val - 1))
            newHead = tailMap.remove(val - 1);
        headMap.put(newHead, newTail);
        tailMap.put(newTail, newHead);
    }
    
    public List<Interval> getIntervals() {
        List<Interval> res = new ArrayList<>();
        List<Integer> keys = new ArrayList(headMap.keySet());
        Collections.sort(keys);
        for (int key : keys)
            res.add(new Interval(key, headMap.get(key)));
        return res;
    }
}

/**
 * Your SummaryRanges object will be instantiated and called as such:
 * SummaryRanges obj = new SummaryRanges();
 * obj.addNum(val);
 * List<Interval> param_2 = obj.getIntervals();
 */
