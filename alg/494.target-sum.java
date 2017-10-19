import java.util.*;
class Solution {
    int n = 0;
    public int findTargetSumWays(int[] nums, int S) {
        int sum = 0;
        for (int n : nums) sum += n;
        sum -= S;
        if (sum < 0 || sum % 2 == 1) return 0;
        sum /= 2;
        Arrays.sort(nums);
        find(nums, 0, 0, sum);
        return n;
    }

    private void find(int[] nums, int pos, int sum, int target) {
        if (sum > target) return;
        if (sum == target) n++;
        if (pos == nums.length) return;
        for (int i = pos; i < nums.length; i++) {
            find(nums, i + 1, sum + nums[i], target);
        }
    }
}
