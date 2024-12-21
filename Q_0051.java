import java.util.ArrayList;
import java.util.List;

class Recursion {

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        solve(board, 0, res, n);
        return res;
    }

    public void solve(char[][] board, int col, List<List<String>> res, int n) {
        if (col == n) {
            res.add(construct(board));
            return;
        }

        for (int row = 0; row < n; row++) {
            if (isSafe(board, row, col, res, n)) {
                board[row][col] = 'Q';
                solve(board, col + 1, res, n);
                board[row][col] = '.';
            }
        }
    }

    public boolean isSafe(char[][] board, int row, int col, List<List<String>> res, int n) {
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

    public List<String> construct(char[][] board) {
        List<String> list = new ArrayList<>();
        for (char[] b : board) {
            list.add(new String(b));
        }
        return list;
    }

    // Time Complexity:

    // Backtracking: There are n possibilities for placing a queen in each column,
    // leading to at most n! configurations in the worst case.
    // Safety Checks: The isSafe function checks the column and diagonals for each
    // position, which takes O(n) time. The total number of safety checks across all
    // configurations is O(n * n!).
    // Overall Time Complexity: O(n * n!).

    // Space Complexity:

    // Call Stack Space: The maximum depth of recursion is n (one recursive call for
    // each column), requiring O(n) space.
    // Auxiliary Space: The board is a 2D array of size n x n, requiring O(n²)
    // space. The result list stores all valid configurations, with each
    // configuration containing n strings of length n. The total space required for
    // the result list depends on the number of solutions, which can be O(n * n!).
    // Overall Space Complexity: O(n² + result size), where the result size is O(n *
    // n!).

}