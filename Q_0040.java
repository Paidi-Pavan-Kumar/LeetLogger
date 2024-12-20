import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Recursion {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        int n = candidates.length;
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        helper(candidates, 0, res, new ArrayList<>(), target, n);
        return res;
    }

    public void helper(int[] candidates, int index, List<List<Integer>> res, List<Integer> list, int target, int n) {
        if (target == 0) {
            res.add(new ArrayList<>(list));
            return;
        }

        for (int i = index; i < n; i++) {
            if (i > index && candidates[i] == candidates[i - 1])
                continue;
            if (candidates[i] > target)
                break;

            list.add(candidates[i]);
            helper(candidates, i + 1, res, list, target - candidates[i], n);
            list.remove(list.size() - 1);
        }
    }

    // Time Complexity:

    // Sorting the Input Array: Sorting the candidates takes O(n log n), where n is
    // the size of the input array.
    // Recursive Calls: The helper function explores combinations recursively. In
    // the worst case, it examines 2^n subsets of candidates, where n is the number
    // of candidates. However, pruning (skipping duplicates and stopping when the
    // current candidate exceeds the target) reduces the number of calls
    // significantly.
    // Construction of Combinations: For each valid combination, copying it into the
    // result takes O(k), where k is the average size of the combination.
    // Overall Time Complexity: O(n log n + 2^n * k).

    // Space Complexity:

    // Call Stack Space: The maximum depth of recursion is O(n), as at most n
    // elements can be part of a single combination.
    // Auxiliary Space: Temporary storage for the current combination list takes
    // O(k), where k is the size of the current combination.
    // Output Storage: The result list stores all valid combinations, requiring
    // space proportional to the total number of combinations and their sizes.
    // Overall Space Complexity: O(n + k + output size).

}