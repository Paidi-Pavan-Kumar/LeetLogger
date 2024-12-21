class Recursion {

    public void solveSudoku(char[][] board) {
        solve(board);
    }

    public boolean solve(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {

                    for (char c = '1'; c <= '9'; c++) {
                        if (isSafe(board, i, j, c)) {
                            board[i][j] = c;
                            if (solve(board) == true) {
                                return true;
                            } else {
                                board[i][j] = '.';
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isSafe(char[][] board, int row, int col, char c) {
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == c)
                return false;
            if (board[i][col] == c)
                return false;
            if (board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == c)
                return false;
        }
        return true;
    }

    // Time Complexity:

    // Backtracking: The algorithm recursively tries to fill each cell of the Sudoku
    // board. There are 81 cells (9x9), and for each empty cell, we try placing one
    // of 9 digits (from 1 to 9).

    // Checking if the move is safe: For each empty cell, the isSafe function checks
    // the row, column, and 3x3 subgrid to ensure that placing a digit is valid.
    // This takes O(9) time for each check.

    // Since we explore all possible configurations for the board, the worst-case
    // time complexity is O(9^(n^2)), where n = 9 for the 9x9 grid. In practical
    // terms, this is generally optimized due to the backtracking approach cutting
    // down invalid branches early.

    // Overall Time Complexity: O(9^(n^2)) in the worst case, though it's often much
    // faster in practice due to early pruning of invalid options.

    // Space Complexity:

    // Call Stack: The depth of the recursive call stack is at most 81 (one
    // recursive call for each cell), so the space required for the call stack is
    // O(81) = O(1) (constant space).

    // Board: The board is a 2D array of size 9x9, which takes O(81) = O(1) space
    // (constant space).

    // Overall Space Complexity: O(1), since the space is constant regardless of the
    // board size, as the board size is fixed (9x9).

}