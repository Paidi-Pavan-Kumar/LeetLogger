class Better {

    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        for (int row = 0; row < m; row++) {
            if (matrix[row][0] <= target &&
                    target <= matrix[row][n - 1]) {
                return bs(matrix[row], target);
            }
        }
        return false;
    }

    public boolean bs(int[] matrix, int target) {
        int low = 0, high = matrix.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (matrix[mid] == target) {
                return true;
            } else if (matrix[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return false;
    }

    // Time Complexity (TC):
    // Row selection: The algorithm iterates through the rows of the matrix to find
    // the row containing the target. This takes O(m), where
    // m is the number of rows.
    // Binary search: For the selected row, the algorithm performs a binary search,
    // which takes O(log n), where
    // n is the number of columns.
    // Overall complexity: O(m + log n) in the worst case.

    // Space Complexity (SC):
    // O(1): The algorithm uses a constant amount of extra space for variables (low,
    // high, mid, etc.).

}

class Optimal {

    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int low = 0, high = m * n - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int row = mid / n;
            int col = mid % n;
            if (matrix[row][col] == target) {
                return true;
            } else if (matrix[row][col] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return false;
    }

    // Time Complexity (TC):
    // O(log(m * n)): The algorithm treats the 2D matrix as a 1D array and performs
    // a binary search on it. Since the total number of elements is
    // m×n, the time complexity is logarithmic with respect to the total elements.
    
    // Space Complexity (SC):
    // O(1): The algorithm uses a constant amount of extra space for variables (low,
    // high, mid, row, col, etc.), without additional data structures.
}
