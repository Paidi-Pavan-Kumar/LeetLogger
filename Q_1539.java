public class Q_1539 {

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