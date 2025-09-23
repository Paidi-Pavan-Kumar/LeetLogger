class Brute {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length, res = 0;
        for(int i = 0; i < n; i++) {
            int sum = 0;
            for(int j = i; j < n; j++) {
                sum += nums[j];
                if(sum == k) res++;
            }
        }
        return res;
    }
}

//Time Complexity: O(n²) (nested loops with prefix sum accumulation)
//Space Complexity: O(1) (only variables used)

class Optimized {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length, res = 0, prefixSum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for(int i = 0; i < n; i++) {
            prefixSum += nums[i];
            int rem = prefixSum - k;
            if(map.containsKey(rem)) {
                res += map.get(rem);
            }
            map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);
        }
        return res;
    }
}

//Time Complexity: O(n) (single pass with hashmap lookups)
//Space Complexity: O(n) (hashmap stores prefix sums)
