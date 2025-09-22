class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            if(i != 0 && nums[i] == nums[i - 1]) continue;
            for(int j = i + 1; j < n; j++){
                if(j != i + 1 && nums[j] == nums[j - 1]) continue;
                int k = j + 1;
                int l = n - 1;
                while(k < l) {
                    long sum = (long) nums[i] + (long)nums[j] + (long)nums[k] + (long)nums[l];
                    if(sum < target) {
                        k++;
                    } else if(sum > target) {
                        l--;
                    } else {
                        res.add(new ArrayList<>(
                            List.of(
                                nums[i], nums[j], nums[k], nums[l]
                            )
                        ));
                        k++;
                        l--;
                        while(k < l && nums[k] == nums[k - 1]) k++;
                        while(k < l && nums[l] == nums[l + 1]) l--;
                    }
                }
            }
        }
        return res;
    }
}

//Time Complexity: O(n³) (two nested loops + two-pointer scan)
//Space Complexity: O(1) (ignoring output list, sorting done in-place)
