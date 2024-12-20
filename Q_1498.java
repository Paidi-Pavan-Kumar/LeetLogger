import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class RecursionTLE {

    public int numSubseq(int[] nums, int target) {
        Arrays.sort(nums);
        return helper(nums, 0, target, new ArrayList<>());
    }

    public int helper(int[] nums, int index, int target, List<Integer> list) {
        if (index >= nums.length) {
            if (!list.isEmpty() && (list.get(0) + list.get(list.size() - 1)) <= target) {
                return 1;
            } else {
                return 0;
            }
        }

        list.add(nums[index]);
        int left = helper(nums, index + 1, target, list);
        list.remove(list.size() - 1);
        int right = helper(nums, index + 1, target, list);
        return left + right;
    }

}

class Optimal {

    public int numSubseq(int[] nums, int target) {
        int n = nums.length;
        Arrays.sort(nums);
        int result = 0;
        int mod = 1_000_000_007;
        int left = 0, right = n - 1;
        int[] pow = new int[n];
        pow[0] = 1;
        for (int i = 1; i < n; i++) {
            pow[i] = (pow[i - 1] * 2) % mod;
        }

        while (left <= right) {
            if (nums[left] + nums[right] <= target) {
                result = (result + pow[right - left]) % mod;
                left++;
            } else {
                right--;
            }
        }
        return result;
    }

    // Time Complexity:

    // Sorting the array: O(n log n)
    // Precomputing powers of 2: O(n)
    // Two-pointer traversal: O(n)
    // Overall time complexity: O(n log n)

    // Space Complexity:

    // Storing powers of 2 in an array: O(n)
    // Overall space complexity: O(n)

}