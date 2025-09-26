class Solution {
    public boolean isSameAfterReversals(int num) {
        int rev1 = h(num);
        return num == h(rev1);
    }

    public int h(int num) {
        int rev = 0;
        while(num != 0) {
            int r = num % 10;
            rev = rev * 10 + r;
            num /= 10;
        }
        return rev;
    }
}
