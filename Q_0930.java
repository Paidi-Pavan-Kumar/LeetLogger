class Optimal {

    public int numSubarraysWithSum(int[] nums, int goal) {
        return numSubArraysWithLessThanOrEqualToSum(nums, goal) -
                numSubArraysWithLessThanOrEqualToSum(nums, goal - 1);
    }

    public int numSubArraysWithLessThanOrEqualToSum(int[] nums, int k) {
        if (k < 0)
            return 0;
        int n = nums.length;
        int left = 0, right = 0, count = 0;
        int sum = 0;
        while (right < n) {
            sum += nums[right];
            while (sum > k) {
                sum -= nums[left];
                left++;
            }
            count += (right - left + 1);
            right++;
        }
        return count;
    }

    // Time Complexity (TC):
    // Each element is processed at most twice (once by right and once by left
    // pointers): O(n).
    // The subtraction logic involves constant-time operations: O(1).
    // Total TC: O(n).

    // Space Complexity (SC):
    // No additional data structures are used apart from a few variables: O(1).

}