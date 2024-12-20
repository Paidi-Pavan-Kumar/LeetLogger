import java.util.ArrayList;
import java.util.List;

class Recursion {

    public List<List<Integer>> subsets(int[] nums) {
        int n = nums.length;
        List<List<Integer>> list = new ArrayList<>();
        return helper(nums, 0, new ArrayList<>(), list, n);
    }

    public List<List<Integer>> helper(int[] nums, int index, List<Integer> subList, List<List<Integer>> list, int n) {
        if (index >= n) {
            list.add(new ArrayList<>(subList));
            return list;
        }

        subList.add(nums[index]);
        helper(nums, index + 1, subList, list, n);
        subList.remove(subList.size() - 1);
        helper(nums, index + 1, subList, list, n);
        return list;
    }

    // Time Complexity (TC):

    // Recursive Calls:
    // For each element in the array, you decide either to include it in the subset
    // or not, leading to 2^n total subsets (where n is the size of the input
    // array).
    // The recursive depth is O(n), but the total operations grow exponentially due
    // to the binary decision tree.

    // Copying Sublist:
    // For each subset generated, a deep copy of the subset is made and added to the
    // result. The cost of copying depends on the subset's size. On average, the
    // copying cost across all subsets is O(n * 2^n).

    // Overall TC:
    // The total time complexity is O(n * 2^n).

    // Space Complexity (SC):

    // Call Stack Space:
    // The recursive depth is O(n).

    // Auxiliary Space:
    // Temporary storage for the subset (subList) is O(n).

    // Output Storage:
    // A total of 2^n subsets are generated, each of size up to n. Thus, the space
    // required for the output is O(n * 2^n).

    // Overall SC:
    // The total space complexity is O(n * 2^n) (output dominates).

    // Summary:

    // Time Complexity: O(n * 2^n)
    // Space Complexity: O(n * 2^n)

}