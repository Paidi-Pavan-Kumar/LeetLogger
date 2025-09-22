class Brute {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        for(int i = 0; i < n; i++) {
            for(int j = i + 1; j < n; j++) {
                if(nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{-1,-1};
    }
}

//Time Complexity: O(n²) (nested loops)
//Space Complexity: O(1) (only a fixed-size result array used)


class Optimized {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++) {
            int complement = target - nums[i];
            if(map.containsKey(complement)) {
                int secondIndex = map.get(complement);
                return new int[]{i, secondIndex};
            }
            map.put(nums[i], i);
        }
        return new int[]{-1, -1};
    }
}

//Time Complexity: O(n) (single pass with hash lookups)
//Space Complexity: O(n) (hashmap stores up to n elements)
