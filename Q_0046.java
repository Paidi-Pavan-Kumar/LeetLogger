class Recursion {

    public List<List<Integer>> permute(int[] nums) {
        int n = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        boolean[] map = new boolean[n];
        helper(nums, map, new ArrayList<>(), res, n);
        return res;
    }

    public void helper(int[] nums, boolean[] map, List<Integer> list, List<List<Integer>> res, int n) {
        if(list.size() == n) {
            res.add(new ArrayList<>(list));
            return;
        }

        for(int i = 0; i < n; i++) {
            if(!map[i]) {
                map[i] = true;
                list.add(nums[i]);
                helper(nums, map, list, res, n);
                list.remove(list.size() - 1);
                map[i] = false;
            }
        }
    }

    
}