class Solution {
    public int evenNumberBitwiseORs(int[] nums) {
        int res = 0;
        for(int x : nums) {
            if(x % 2 == 0) res |= x;
        }
        return res;
    }
}
