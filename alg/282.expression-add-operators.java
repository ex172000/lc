import java.util.*;
class Solution {
    List<String> res;
    public List<String> addOperators(String num, int target) {
        res = new ArrayList<>();
        helper(num, "", 0, 0, 0, target);
        return res;
    }
    public void helper(String num, String s, int p, long cur, long prev, int target) {
        if (p == num.length()) {
            if (cur == target) res.add(s);
            return;
        }
        for (int i = p; i < num.length(); i++) {
            if (i > p && num.charAt(i - 1) == '0') break;
            String k = num.substring(p, i + 1);
            long v = Long.parseLong(k);
            if (s.equals("")) {
                helper(num, k, i + 1, v, v, target);
            } else {
                helper(num, s + "*" + v, i + 1, cur - prev + prev * v, prev * v, target);
                helper(num, s + "+" + v, i + 1, cur + v, v, target);
                helper(num, s + "-" + v, i + 1, cur - v, -v, target);
            }
        }
    }
}
