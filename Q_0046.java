import java.util.ArrayList;
import java.util.List;

class Recursion {

    public List<List<Integer>> permute(int[] nums) {
        int n = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        boolean[] map = new boolean[n];
        helper(nums, map, new ArrayList<>(), res, n);
        return res;
    }

    public void helper(int[] nums, boolean[] map, List<Integer> list, List<List<Integer>> res, int n) {
        if (list.size() == n) {
            res.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!map[i]) {
                map[i] = true;
                list.add(nums[i]);
                helper(nums, map, list, res, n);
                list.remove(list.size() - 1);
                map[i] = false;
            }
        }
    }

    // Time Complexity:

    // Recursive Permutation Generation:
    // The number of permutations of n distinct elements is n!.
    // For each valid permutation, copying it into the result list takes O(n).
    // The total time spent is proportional to O(n * n!).
    // Overall Time Complexity: O(n * n!).

    // Space Complexity:

    // Call Stack Space: The maximum depth of recursion is n (one call for each
    // element in the input array), so the space required for the call stack is
    // O(n).
    // Auxiliary Space:
    // The map array takes O(n) space.
    // Temporary storage for the current permutation list takes O(n).
    // Output Storage: The result list stores all permutations. The space required
    // is proportional to O(n * n!).
    // Overall Space Complexity: O(n + output size), where the output size is O(n *
    // n!).

}