class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int n = numbers.length;
        int i = 0, j = n - 1;
        while(i < j) {
            int sum = numbers[i] + numbers[j];
            if(sum == target) {
                return new int[]{i + 1, j + 1};
            } else if(sum < target) {
                i++;
            } else {
                j--;
            }
        }
        return new int[]{-1,-1};
    }
}

//Time Complexity: O(n) (single two-pointer scan)
//Space Complexity: O(1) (only a few variables used)
