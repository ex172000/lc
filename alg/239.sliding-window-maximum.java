import java.util.*;
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0) return new int[0];
        List<Integer> window = new ArrayList<Integer>();
        int[] res = new int[nums.length - k + 1];
        int pos = 0, i = -1, j = 0;
        while (j < k - 1)
            window.add(nums[j++]);
        Collections.sort(window);
        while (j < nums.length) {
            //System.out.println(window);
            int p = Collections.binarySearch(window, nums[j]);
            if (p >= 0) {
                window.add(p, nums[j]);
            } else {
                window.add(-(1 + p), nums[j]);
            }
            if (i >= 0) {
                int q = Collections.binarySearch(window, nums[i]);
                window.remove(q);
            }
            res[pos++] = window.get(window.size() - 1);
            i++; j++;
        }
        return res;
    }
}
