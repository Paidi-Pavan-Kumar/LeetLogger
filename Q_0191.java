class Better {
    public int hammingWeight(int n) {
        int count = 0;
        while(n != 0) {
            count += n % 2;
            n = n / 2;
        }
        return count;
    }
}

class Optimal {
    public int hammingWeight(int n) {
        int count = 0;
        for(int i = 0; i < 32; i++) {
            if( ((n >> i) & 1 ) == 1) {
                count++;
            }
        }
        return count;
    }
}