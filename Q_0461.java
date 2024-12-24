class S1 {
    public int hammingDistance(int x, int y) {
        int count = 0;
        for (int i = 0; i < 32; i++) {
            if (((x >> i) & 1) != ((y >> i) & 1)) {
                count++;
            }
        }
        return count;
    }

    // Time Complexity:
    // The loop runs for 32 iterations (constant), so the complexity is O(1).

    // Space Complexity:
    // The function uses a constant amount of extra space, so the complexity is
    // O(1).

}

class S2 {

    public int hammingDistance(int x, int y) {
        int count = 0;
        int xor = x ^ y;
        for(int i = 0; i < 32; i++) {
            if( ((xor >> i) & 1) == 1) {
                count++;
            }
        }
        return count;
    }
}

class S3 {

    public int hammingDistance(int x, int y) {
        return Integer.bitCount(x ^ y);
    }
}