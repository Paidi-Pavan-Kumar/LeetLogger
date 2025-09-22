class Brute {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        Set<List<Integer>> set = new HashSet<>();
        for(int i = 0; i < n; i++) {
            for(int j = i + 1; j < n; j++) {
                for(int k = j + 1; k < n; k++) {
                    int sum = nums[i] + nums[j] + nums[k];
                    if(sum == 0) {
                        set.add(new ArrayList<>(List.of(
                            nums[i], nums[j], nums[k]
                        )));
                    }
                }
            }
        }
        list.addAll(set);
        return list;
    }
}

//Time Complexity: O(n³) (three nested loops)
//Space Complexity: O(n³) in worst case (set storing up to all triplets)

class Optimized {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            if(i != 0 && nums[i] == nums[i - 1]) continue;
            int j = i + 1;
            int k = n - 1;
            while(j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if(sum < 0) {
                    j++;
                } else if(sum > 0) {
                    k--; 
                } else {
                    list.add(new ArrayList<>(
                        List.of(nums[i], nums[j], nums[k])
                    ));
                    j++;
                    k--;
                    while(j < k && nums[j] == nums[j - 1]) {
                        j++;
                    }
                    while(j < k && nums[k] == nums[k + 1]) {
                        k--;
                    }
                }
            }
        }
        return list;
    }
}

//Time Complexity: O(n²) (outer loop + two-pointer scan)
//Space Complexity: O(1) (ignoring output list, sorting done in-place)
