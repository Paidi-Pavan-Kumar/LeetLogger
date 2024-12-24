class Brute {

    public int totalHammingDistance(int[] nums) {
        int count = 0, n = nums.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                count += Integer.bitCount(nums[i] ^ nums[j]);
            }
        }
        return count;
    }

}

class Optimal {

    public int totalHammingDistance(int[] nums) {
        int count = 0, n = nums.length;
        for (int i = 0; i < 32; i++) {
            int setBits = 0;
            for (int j = 0; j < n; j++) {
                setBits += ((nums[j] >> i) & 1);
            }
            int unsetBits = n - setBits;
            count += (setBits * unsetBits);
        }
        return count;
    }

    // Time Complexity: O(n)
    // Space Complexity: O(1)
}
