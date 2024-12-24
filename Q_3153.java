class BruteTLE {

    public long sumDigitDifferences(int[] nums) {
        long res = 0, n = nums.length;
        while (nums[0] != 0) {
            List<Integer> digits = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                digits.add(nums[i] % 10);
                nums[i] /= 10;
            }

            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    if (digits.get(i) != digits.get(j)) {
                        res++;
                    }
                }
            }
        }
        return res;
    }

}

class Optimal {

    public long sumDigitDifferences(int[] nums) {
        long res = 0, n = nums.length;
        while (nums[0] != 0) {
            int[] digitCount = new int[10];
            for (int i = 0; i < n; i++) {
                digitCount[nums[i] % 10]++;
                nums[i] /= 10;
            }

            for (int digit = 0; digit <= 9; digit++) {
                res += ((digitCount[digit] * (n - digitCount[digit])));
            }
        }
        return res / 2;
    }

    // Time Complexity:
    // O(d × n)
    // d is the maximum number of digits in the largest number.
    // For each digit position, we process all n numbers.
    
    // Space Complexity:
    // O(1)
    // Uses a fixed-size array (digitCount) of size 10.

}