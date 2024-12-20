import java.util.ArrayList;
import java.util.List;

class Recursion {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        int n = candidates.length;
        List<List<Integer>> res = new ArrayList<>();
        helper(candidates, 0, res, new ArrayList<>(), target, 0, n);
        return res;
    }

    public void helper(int[] candidates, int index, List<List<Integer>> res, List<Integer> list, int target, int sum,
            int n) {
        if (index >= n) {
            if (sum == target) {
                res.add(new ArrayList<>(list));
            }
            return;
        }

        if (sum + candidates[index] <= target) {
            list.add(candidates[index]);
            helper(candidates, index, res, list, target, sum + candidates[index], n);
            list.remove(list.size() - 1);
        }
        helper(candidates, index + 1, res, list, target, sum, n);
    }

    // Time Complexity:

    // Recursive Calls: Each candidate can be included multiple times until the
    // target is reached or exceeded. For every candidate, there are two choices:
    // include it or skip it. The total number of combinations explored is
    // approximately 2^n, where n is the number of candidates.
    // Construction of Valid Combinations: Each valid combination requires copying
    // the current list into the result, which takes O(k), where k is the size of
    // the combination.
    // Overall Time Complexity: O(2^n * k), where k is the average size of a
    // combination.
    // Space Complexity:

    // Call Stack Space: The recursive depth is proportional to the target divided
    // by the smallest candidate value, O(target/min).
    // Auxiliary Space: Temporary storage for the current combination list uses O(k)
    // space, where k is the size of the current combination.
    // Overall Space Complexity: O(target/min + k)

}