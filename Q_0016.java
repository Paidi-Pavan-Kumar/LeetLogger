class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int n = nums.length, minDiff = Integer.MAX_VALUE, res = 0;
        Arrays.sort(nums);
        for(int i = 0; i < n; i++) {
            if(i != 0 && nums[i] == nums[i - 1]) continue;
            int j = i + 1;
            int k = n - 1;
            while(j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if(sum == target) return sum;
                if(minDiff > Math.abs(sum - target)) {
                    minDiff = Math.abs(sum - target);
                    res = sum;
                }
                else if(sum < target) {
                    j++;
                } else {
                    k--;
                }
            }
        }
        return res;
    }
}

//Time Complexity: O(n²) (outer loop + two-pointer scan)
//Space Complexity: O(1) (only variables, sorting done in-place)
