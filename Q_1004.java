class Brute {

    public int longestOnes(int[] nums, int k) {
        int n = nums.length;
        int max = 0;
        for (int i = 0; i < n; i++) {
            int zeros = 0;
            for (int j = i; j < n; j++) {
                if (nums[j] == 0) {
                    zeros++;
                }

                if (zeros <= k) {
                    int currentLength = j - i + 1;
                    max = Math.max(max, currentLength);
                } else {
                    break;
                }
            }
        }
        return max;
    }

    // Time Complexity (TC):
    // The outer loop runs O(n), and the inner loop also runs up to O(n) in the
    // worst case.
    // Overall time complexity is O(n²).

    // Space Complexity (SC):
    // The solution uses only a few variables for tracking counts and maximums, so
    // the space complexity is O(1).

}

class Better {

    public int longestOnes(int[] nums, int k) {
        int n = nums.length;
        int max = 0;
        int left = 0, right = 0;
        int zeros = 0;
        while (right < n) {
            if (nums[right] == 0)
                zeros++;
            while (zeros > k) {
                if (nums[left] == 0) {
                    zeros--;
                }
                left++;
            }
            max = Math.max(max, right - left + 1);
            right++;
        }
        return max;
    }

}

class Optimal {

    public int longestOnes(int[] nums, int k) {
        int n = nums.length;
        int max = 0;
        int left = 0, right = 0;
        int zeros = 0;
        while (right < n) {
            if (nums[right] == 0)
                zeros++;
            if (zeros > k) {
                if (nums[left] == 0) {
                    zeros--;
                }
                left++;
            }
            if (zeros <= k) {
                max = Math.max(max, right - left + 1);
            }
            right++;
        }
        return max;
    }

    // Time Complexity (TC):

    // The while loop traverses the array once with the left and right pointers,
    // making it O(n).
    // Space Complexity (SC):

    // Only a few variables are used to keep track of counts, so the space
    // complexity is O(1).

}