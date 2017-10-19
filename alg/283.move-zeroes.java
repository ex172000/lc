class Solution {
    public void moveZeroes(int[] nums) {
        int ptr = 0;
        for (int i = 0; i < nums.length && ptr < nums.length; i++) {
            if (nums[i] == 0) {
                if (ptr <= i) ptr = i;
                while (ptr < nums.length - 1 && nums[ptr] == 0) ptr++;
                nums[i] = nums[ptr];
                nums[ptr] = 0;
            }
        }
    }
}
