import java.util.*;
class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        if (k == 0) {
            for (int i = 1; i < nums.length; i++)
                if (nums[i] == 0 && nums[i] == nums[i - 1])
                    return true;
            return false;
        }
        Set<Integer> set = new HashSet<>();
        int cur = 0;
        for (int i = 0; i < nums.length; i++) {
            cur = (nums[i] + cur) % k;
            if (cur == 0 && i > 0) return true;
            if (set.contains(cur)) return true;
            set.add(cur);
        }
        return false;
    }
}
