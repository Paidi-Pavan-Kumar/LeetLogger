import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Recursion {

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        helper(nums, 0, new ArrayList<>(), res);
        return res;
    }

    public void helper(int[] nums, int index, List<Integer> list, List<List<Integer>> res) {
        res.add(new ArrayList<>(list));

        for (int i = index; i < nums.length; i++) {
            if (i > index && nums[i] == nums[i - 1])
                continue;
            list.add(nums[i]);
            helper(nums, i + 1, list, res);
            list.remove(list.size() - 1);
        }
    }

    // Time Complexity:

    // Sorting: Sorting the array nums takes O(n log n), where n is the length of
    // the input array.
    // Recursive Subset Generation:
    // Each element can either be included or excluded in a subset, leading to a
    // maximum of 2^n subsets.
    // Due to duplicate handling, fewer subsets are generated. In the worst case
    // (all elements unique), 2^n subsets are still explored.
    // Copying the current subset to the result list takes O(k) for each valid
    // subset, where k is the average size of a subset.
    // Overall Time Complexity: O(n log n + 2^n * k), where k is the average size of
    // a subset.

    // Space Complexity:

    // Call Stack Space: The maximum depth of recursion is n (one call for each
    // element in the input array), so the space required for the call stack is
    // O(n).
    // Auxiliary Space: Temporary storage for the current subset list takes O(n).
    // Output Storage: The result list stores all subsets. The space depends on the
    // number of subsets and their sizes, proportional to O(n * 2^n).
    // Overall Space Complexity: O(n + output size).

}