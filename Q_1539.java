class Brute {

    public int findKthPositive(int[] arr, int k) {
        int missing = 0, index = 0;
        for (int i = 1; i <= 2000; i++) {
            if (index >= arr.length || i != arr[index]) {
                missing++;
            } else {
                index++;
            }
            if (missing == k)
                return i;
        }
        return -1;
    }
    // Time Complexity (TC):
    // The loop runs for a maximum of 2000 iterations (fixed value), so the time
    // complexity is O(2000). This is effectively a constant time complexity, O(1),
    // because 2000 is a fixed upper limit.

    // Space Complexity (SC):
    // The space complexity is O(1) as the algorithm only uses a constant amount of
    // extra space for variables (missing, index, and i).

}

class optimal{

    public int findKthPositive1(int[] arr, int k) {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int missing = arr[mid] - (mid + 1);
            if (missing < k) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low + k;
    }

    // Time Complexity (TC):
    // The algorithm performs a binary search, so the time complexity is O(log n),
    // where
    // n is the length of the input array arr.

    // Space Complexity (SC):
    // The space complexity is O(1) as it only uses a constant amount of extra space
    // for variables (low, high, mid, and missing).
}