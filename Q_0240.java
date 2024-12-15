class Better {

    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        for (int row = 0; row < m; row++) {
            boolean found = bs(matrix[row], target);
            if (found) {
                return true;
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
            } else if (matrix[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return false;
    }

    // Time Complexity (TC):
    // The outer loop iterates over each row of the matrix (O(m)).
    // For each row, a binary search is performed, taking O(log n), where
    // n is the number of columns.
    // Overall time complexity: O(m * log n).

    // Space Complexity (SC):
    // O(1): The algorithm uses only a constant amount of extra space for variables
    // (low, high, mid, etc.) in each binary search call.

}

class Optimal {

    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int row = 0, col = n - 1;
        while (row < m && col >= 0) {
            if (matrix[row][col] == target) {
                return true;
            } else if (matrix[row][col] < target) {
                row++;
            } else {
                col--;
            }
        }
        return false;
    }

    // Time Complexity (TC):
    // O(m + n): The algorithm starts at the top-right corner of the matrix and
    // either moves left (decreasing col) or downward (increasing row). In the worst
    // case, it traverses the entire row and column, resulting in
    // m+n steps.
    
    // Space Complexity (SC):
    // O(1): Only a constant amount of space is used for variables (row, col, etc.),
    // with no additional data structures.

}
