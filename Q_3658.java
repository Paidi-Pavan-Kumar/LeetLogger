class Solution {
    public int gcdOfOddEvenSums(int n) {
        int even = n * (n + 1);
        int odd = n * n;
        return even - odd; 
    }
}
