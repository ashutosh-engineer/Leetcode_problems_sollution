// You are given an m x n matrix board containing letters 'X' and 'O', capture regions that are surrounded:

// Connect: A cell is connected to adjacent cells horizontally or vertically.
// Region: To form a region connect every 'O' cell.
// Surround: The region is surrounded with 'X' cells if you can connect the region with 'X' cells and none of the region cells are on the edge of the board.
// To capture a surrounded region, replace all 'O's with 'X's in-place within the original board. You do not need to return anything.

 

// Example 1:

// Input: board = [["X","X","X","X"],["X","O","O","X"],["X","X","O","X"],["X","O","X","X"]]

// Output: [["X","X","X","X"],["X","X","X","X"],["X","X","X","X"],["X","O","X","X"]]

class Solution {
    public void solve(char[][] board) {
        if (board == null || board.length == 0) return;
        int m = board.length, n = board[0].length;

        // Step 1: Mark all 'O's connected to border as safe
        for (int i = 0; i < m; i++) {
            dfs(board, i, 0);         // first column
            dfs(board, i, n - 1);     // last column
        }
        for (int j = 0; j < n; j++) {
            dfs(board, 0, j);         // first row
            dfs(board, m - 1, j);     // last row
        }

        // Step 2: Flip all unmarked 'O's to 'X', and restore marked to 'O'
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X'; // captured
                } else if (board[i][j] == '#') {
                    board[i][j] = 'O'; // safe
                }
            }
        }
    }

    private void dfs(char[][] board, int i, int j) {
        int m = board.length, n = board[0].length;
        if (i < 0 || i >= m || j < 0 || j >= n || board[i][j] != 'O') return;

        board[i][j] = '#'; // temporarily mark as safe

        // Explore in 4 directions
        dfs(board, i + 1, j);
        dfs(board, i - 1, j);
        dfs(board, i, j + 1);
        dfs(board, i, j - 1);
    }
}
