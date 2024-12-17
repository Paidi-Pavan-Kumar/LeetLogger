class Optimal {

    public int numberOfSubarrays(int[] nums, int k) {
        return helper(nums, k) - helper(nums, k - 1);
    }

    public int helper(int[] nums, int k) {
        if (k < 0)
            return 0;
        int left = 0, right = 0, count = 0;
        int odds = 0;
        while (right < nums.length) {
            if (nums[right] % 2 == 1)
                odds++;
            while (odds > k) {
                if (nums[left] % 2 == 1)
                    odds--;
                left++;
            }
            count += (right - left + 1);
            right++;
        }
        return count;
    }

    // Time Complexity (TC):
    // Both right and left pointers traverse the array at most once: O(n).
    // Total TC: O(n).

    // Space Complexity (SC):
    // No additional space apart from a few variables is used: O(1).

}