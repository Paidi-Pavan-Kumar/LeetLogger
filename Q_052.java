class Recursion {

    class Solution {
        public int totalNQueens(int n) {
            char[][] board = new char[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    board[i][j] = '.';
                }
            }
            int[] res = { 0 };
            solve(board, 0, n, res);
            return res[0];
        }

        public void solve(char[][] board, int col, int n, int[] res) {
            if (col == n) {
                res[0]++;
                return;
            }

            for (int row = 0; row < n; row++) {
                if (isSafe(board, row, col, n)) {
                    board[row][col] = 'Q';
                    solve(board, col + 1, n, res);
                    board[row][col] = '.';
                }
            }
        }

        public boolean isSafe(char[][] board, int row, int col, int n) {
            int dupRow = row;
            int dupCol = col;

            // north west
            while (dupRow >= 0 && dupCol >= 0) {
                if (board[dupRow--][dupCol--] == 'Q')
                    return false;
            }

            dupRow = row;
            dupCol = col;

            // west
            while (dupCol >= 0) {
                if (board[dupRow][dupCol--] == 'Q')
                    return false;
            }

            dupRow = row;
            dupCol = col;

            while (dupRow < n && dupCol >= 0) {
                if (board[dupRow++][dupCol--] == 'Q')
                    return false;
            }

            return true;

        }

    }

    // Time Complexity:

    // Backtracking: The algorithm explores all possible ways to place queens on the
    // board. There are n possible positions for each queen in each column, and at
    // most n! configurations in the worst case.
    
    // Safety Check: The isSafe function checks for conflicts in the column and
    // diagonals, which takes O(n) time for each placement.

    // Overall Time Complexity: O(n * n!) because the worst-case number of recursive
    // calls is n! and each call performs a safety check in O(n) time.

    // Space Complexity:

    // Call Stack: The maximum depth of the recursion is n (one recursive call for
    // each column), so the space required for the call stack is O(n).

    // Board: The board is a 2D array of size n x n, which takes O(n²) space.

    // Result Array: The result array stores one integer to keep track of the number
    // of solutions, which takes O(1) space.

    // Overall Space Complexity: O(n²), considering the board and the maximum
    // recursion depth.

}