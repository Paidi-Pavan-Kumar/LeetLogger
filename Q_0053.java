class Solution {
    public int maxSubArray(int[] nums) {
        int sum = Integer.MIN_VALUE, csum = 0;
        for(int x : nums) {
            csum += x;
            if(csum > sum) sum = csum;
            if(csum < 0) csum = 0;
        }
        return sum;
    }
}

//Time Complexity: O(n) (single pass over array)
//Space Complexity: O(1) (only variables used)
