class Optimal {

    public int splitArray(int[] nums, int k) {
        if (k > nums.length)
            return -1;
        int low = Integer.MIN_VALUE;
        int high = 0;
        for (int x : nums) {
            low = Math.max(low, x);
            high += x;
        }
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int maxSubArrays = isPossible(nums, mid, k);
            if (maxSubArrays <= k) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    public int isPossible(int[] nums, int sum, int k) {
        int subArraySum = 0;
        int subArrayCount = 0;
        for (int x : nums) {
            if (subArraySum + x <= sum) {
                subArraySum += x;
            } else {
                subArrayCount++;
                subArraySum = x;
            }
        }
        if (subArraySum > 0)
            subArrayCount++;
        return subArrayCount;
    }

    // Time Complexity (TC):
    // Binary Search on low to high: The binary search range is from the largest
    // element (low) to the sum of all elements (high). The number of iterations is
    // O(log(high - low)).
    // Checking with isPossible: For each iteration of binary search, isPossible
    // processes the array, which costs O(n).
    // Overall complexity: O(n log(high - low)), where
    // n is the size of the array.
    
    // Space Complexity (SC):
    // O(1), as the algorithm only uses a constant amount of extra space for
    // variables (low, high, mid, subArraySum, etc.).

}