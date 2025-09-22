class Solution {
    public int maxFrequencyElements(int[] nums) {
        int n = nums.length, max = 0, res = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            if(map.get(nums[i]) > max) max++;
        }
        for(int key : map.keySet()) {
            if(map.get(key) == max) res += max;
        }
        return res;
    }
}

//Time Complexity: O(n) (one pass to count + one pass over unique keys)
//Space Complexity: O(n) (hashmap stores frequencies of elements)
