import java.util.ArrayList;
import java.util.List;

class RecursionTLE {

    public int sumOfPower(int[] nums, int k) {
        return subsets(nums, 0, new ArrayList<>(), k);
    }

    public int subsets(int[] nums, int index, List<Integer> list, int k) {
        if(index >= nums.length) {
            int count = helper(list, 0, 0, k);
            return count;
        }

        list.add(nums[index]);
        int left = subsets(nums, index + 1, list, k);
        list.remove(list.size() - 1);
        int right = subsets(nums, index + 1, list, k);
        return left + right;
    }

    public int helper(List<Integer> nums, int index, int sum, int target) {
        if(index >= nums.size()) {
            if(sum == target) {
                return 1;
            } else {
                return 0;
            }
        }

        int left = helper(nums, index + 1, sum + nums.get(index), target);
        int right = helper(nums, index + 1, sum, target);
        return left + right;
    }

    
}
