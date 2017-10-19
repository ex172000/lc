import java.util.*;
class Solution {
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        List<Integer> num = new ArrayList<>();
        int ptr1 = nums1.length - 1, ptr2 = nums2.length - 1;
        while (ptr1 >= 0 && ptr2 >= 0) {
            if (nums1[ptr1] < nums2[ptr2])
                num.add(0, nums1[ptr1--]);
            else if (nums1[ptr1] > nums2[ptr2])
                num.add(0, nums2[ptr2--]);
            else {
                int i = ptr1, j = ptr2;
                while (i >= 0 && j >= 0) {
                    if (nums1[i] < nums2[j]) {
                        num.add(0, nums1[ptr1--]);
                        break;
                    } else if (nums1[i] > nums2[j]) {
                        num.add(0, nums2[ptr2--]);
                        break;
                    } else {
                        i--;
                        j--;
                    }
                }
                if (i < 0 || j < 0)
                    num.add(0, nums1[ptr1--]);
            }
        }
        while (ptr1 >= 0)
            num.add(0, nums1[ptr1--]);
        while (ptr2 >= 0)
            num.add(0, nums2[ptr2--]);
        System.out.println(num);
        List<Integer> max = new ArrayList<>();
        find(max, num, 0, k);
        int[] res = new int[k];
        for (int i = 0; i < k; i++) res[i] = max.get(i);
        return res;
    }

    private void find(List<Integer> res, List<Integer> num, int p, int left) {
        if (left == 0) return;
        int max = num.get(p), index = p;
        for (int i = p; i < num.size() - left + 1; i++) {
            if (num.get(i) == 9) {
                res.add(9);
                find(res, num, i + 1, left - 1);
                break;
            } else {
                if (num.get(i) > max) {
                    max = num.get(i);
                    index = i;
                }
            }
        }
        res.add(max);
        find(res, num, index + 1, left - 1);
    }
}
