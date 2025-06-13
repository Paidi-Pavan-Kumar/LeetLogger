class Solution {
    public int countCompleteSubarrays(int[] nums) {
        int n = nums.length, res = 0;
        Set<Integer> set = new HashSet<>();
        for(int x : nums) set.add(x);
        for(int i = 0; i < n; i++) {
            Set<Integer> list = new HashSet<>();
            for(int j = i; j < n; j++) {
                list.add(nums[j]);
                if(set.size() == list.size()) res++;
                if(set.size() < list.size()) break;
            }
        }
        return res;
    }
}
/* Time Complexity: O(n²)
Because there are two nested loops. For each starting index i, the inner loop runs from i to n, so in total it can take up to n² operations.

Space Complexity: O(d)
Where d is the number of distinct elements in the array. Two sets are used: one to store all distinct elements (set), 
and another temporary set (list) used inside the inner loop. Each can grow up to d in size. */
