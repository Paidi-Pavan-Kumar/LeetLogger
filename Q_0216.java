import java.util.ArrayList;
import java.util.List;

class Recursion {

    public List<List<Integer>> combinationSum3(int k, int n) {
        int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        List<List<Integer>> res = new ArrayList<>();
        helper(arr, 0, new ArrayList<>(), n, k, res);
        return res;
    }

    public void helper(int[] arr, int index, List<Integer> list, int target, int k, List<List<Integer>> res) {
        if (list.size() == k) {
            if (target == 0) {
                res.add(new ArrayList<>(list));
            }
            return;
        }

        for (int i = index; i < arr.length; i++) {
            if (arr[index] > target)
                break;
            list.add(arr[i]);
            helper(arr, i + 1, list, target - arr[i], k, res);
            list.remove(list.size() - 1);
        }
    }

    // Time Complexity:

    // Recursive Calls:
    // The problem is to generate combinations using numbers 1 through 9. For each
    // number, there is a binary choice: include or exclude it.
    // This results in 2^9 = 512 possible subsets in the worst case. However, the
    // constraints (list size must be exactly k and the sum must equal n) prune the
    // recursion tree significantly.
    // The pruning reduces the number of subsets explored, but the complexity
    // remains exponential in the worst case: O(2^9).
    // Constructing Valid Combinations:
    // Each valid combination is added to the result list. Copying a combination
    // takes O(k), where k is the size of the combination.
    // Overall Time Complexity: O(2^9 * k).

    // Space Complexity:

    // Call Stack Space:
    // The maximum depth of recursion is at most k, as a combination cannot contain
    // more than k numbers.
    // Space required for the call stack: O(k).
    // Auxiliary Space:
    // Temporary storage for the current combination list takes O(k).
    // Output Storage:
    // The result list stores all valid combinations. Space depends on the number of
    // valid combinations and their sizes, proportional to O(k * number of
    // combinations).
    // Overall Space Complexity: O(k + output size).

}