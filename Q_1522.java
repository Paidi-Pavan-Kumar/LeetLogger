import java.util.Arrays;

class Optimal {

    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int n = position.length;
        int low = 0;
        int high = position[n - 1] - position[0];
        int ans = 0;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            boolean isPossible = helper(position, mid, m);
            if (isPossible) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }

    public boolean helper(int[] position, int gap, int cows) {
        int countCows = 1;
        int currentCow = position[0];
        for (int x : position) {
            if (x - currentCow >= gap) {
                countCows++;
                currentCow = x;
            }
        }
        return countCows >= cows;
    }

    // Time Complexity (TC):
    // Sorting the position array: O(n log n), where
    // 𝑛
    // n is the number of elements in position.
    // Binary search on the distance: The range of distances is from 0 to
    // position[n-1] - position[0]. Each step of the binary search calls the helper
    // function, which iterates over the position array, costing O(n). The binary
    // search has O(log(max_distance)) iterations.
    // Overall complexity: O(n log n + n log(max_distance)).
    // Space Complexity (SC):
    // O(1), as the algorithm uses a constant amount of extra space regardless of
    // the input size.
}