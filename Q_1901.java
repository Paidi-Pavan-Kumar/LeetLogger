class Brute {

    public int[] findPeakGrid(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int left = Integer.MIN_VALUE;
                int right = Integer.MIN_VALUE;
                int top = Integer.MIN_VALUE;
                int bottom = Integer.MIN_VALUE;

                if (j - 1 >= 0)
                    left = mat[i][j - 1];
                if (j + 1 < n)
                    right = mat[i][j + 1];
                if (i - 1 >= 0)
                    top = mat[i - 1][j];
                if (i + 1 < m)
                    bottom = mat[i + 1][j];

                int ele = mat[i][j];

                if (ele > left && ele > right && ele > top && ele > bottom) {
                    return new int[] { i, j };
                }
            }
        }
        return new int[] { -1, -1 };
    }

    // Time Complexity (TC):

    // The code iterates over every element of the matrix once in a nested loop,
    // resulting in a time complexity of O(m * n), where m is the number of rows and
    // n is the number of columns.

    // Space Complexity (SC):
    // The space complexity is O(1) since the function only uses a constant amount
    // of extra space regardless of the input size.

}

class Optimal {

    public int[] findPeakGrid(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int low = 0, high = n - 1;
        while (low <= high) {
            int col = low + (high - low) / 2;
            int ele = Integer.MIN_VALUE;
            int row = 0;
            for (int i = 0; i < m; i++) {

                if (mat[i][col] > ele) {
                    ele = Math.max(ele, mat[i][col]);
                    row = i;
                }
            }

            int left = Integer.MIN_VALUE;
            int right = Integer.MIN_VALUE;
            int top = Integer.MIN_VALUE;
            int bottom = Integer.MIN_VALUE;

            if (col - 1 >= 0)
                left = mat[row][col - 1];
            if (col + 1 < n)
                right = mat[row][col + 1];
            if (row - 1 >= 0)
                top = mat[row - 1][col];
            if (row + 1 < m)
                bottom = mat[row + 1][col];

            if (ele > left && ele > right && ele > top && ele > bottom) {
                return new int[] { row, col };
            } else if (ele < left) {
                high = col - 1;
            } else {
                low = col + 1;
            }
        }
        return new int[] { -1, -1 };
    }

    // Time Complexity (TC):

    // The while loop runs for O(log n) iterations, as it performs a binary search
    // over the columns.
    // For each column, the inner loop iterates over all rows, which is O(m).
    // Thus, the overall time complexity is O(m * log n), where m is the number of
    // rows and n is the number of columns.

    
    // Space Complexity (SC):

    // The space complexity is O(1) since the function only uses a constant amount
    // of extra space.

}
