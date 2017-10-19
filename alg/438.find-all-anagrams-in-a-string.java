import java.util.*;
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if (p.length() == 0 || s.length() == 0 || p.length() > s.length()) return res;
        int i = 0, j = p.length() - 1;
        Map<Character, Integer> mapp = new HashMap<>(), maps = new HashMap<>();
        for (char c : p.toCharArray())
            mapp.put(c, mapp.getOrDefault(c, 0) + 1);
        int count = mapp.size(), cur = 0;
        for (int k = i; k <= j; k++) {
            char c = s.charAt(k);
            if (!mapp.containsKey(c)) continue;
            maps.put(c, maps.getOrDefault(c, 0) + 1);
            if (maps.get(c) == mapp.get(c)) cur++;
        }
        if (cur == count) res.add(i);
        System.out.println(cur);
        System.out.println(count);
        j++;
        while (j < s.length()) {
            char toAdd = s.charAt(j), toRemove = s.charAt(i);
            if (mapp.containsKey(toAdd)) {
                maps.put(toAdd, maps.getOrDefault(toAdd, 0) + 1);
                if (maps.get(toAdd) == mapp.get(toAdd)) cur++;
            }
            if (mapp.containsKey(toRemove)) {
                maps.put(toRemove, maps.get(toRemove) - 1);
                if (maps.get(toRemove) == mapp.get(toRemove) - 1) cur--;
            }
            if (count == cur) res.add(i + 1);
            i++; j++;
        }
        return res; 
    }
}
