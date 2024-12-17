import java.util.HashMap;

class Optimal {

    public int subarraysWithKDistinct(int[] nums, int k) {
        return helper(nums, k) - helper(nums, k - 1);
    }

    public int helper(int[] nums, int k) {
        if (k < 0)
            return 0;
        int left = 0, right = 0, count = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        while (right < nums.length) {
            int num = nums[right];
            map.put(num, map.getOrDefault(num, 0) + 1);
            while (map.size() > k) {
                int ele = nums[left];
                map.put(ele, map.get(ele) - 1);
                if (map.get(ele) == 0) {
                    map.remove(ele);
                }
                left++;
            }
            count += (right - left + 1);
            right++;
        }
        return count;
    }

    // Time Complexity (TC):
    // The right pointer moves from left to right over the array, and for each right
    // pointer, the left pointer also moves at most n times (since each element is
    // added or removed at most once from the map).
    // The map operations (insert, update, remove) are O(1) on average.
    // Hence, the time complexity is O(n), where n is the length of the nums array.

    // Space Complexity (SC):
    // The space complexity is driven by the size of the hash map, which can store
    // at most k distinct elements at any time (where k is the maximum number of
    // distinct elements allowed).
    // Therefore, the space complexity is O(k).

}