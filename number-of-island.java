class Solution {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;

        int rows = grid.length;
        int cols = grid[0].length;
        int numIslands = 0;

        // Loop through each cell
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                // If land is found, start DFS and count 1 island
                if (grid[r][c] == '1') {
                    dfs(grid, r, c);
                    numIslands++;
                }
            }
        }

        return numIslands;
    }

    // Mark connected land as visited using DFS
    private void dfs(char[][] grid, int r, int c) {
        int rows = grid.length;
        int cols = grid[0].length;

        // Boundary or water check
        if (r < 0 || c < 0 || r >= rows || c >= cols || grid[r][c] == '0') {
            return;
        }

        // Mark the current land cell as visited
        grid[r][c] = '0';

        // Explore all 4 directions (up, down, left, right)
        dfs(grid, r - 1, c); // up
        dfs(grid, r + 1, c); // down
        dfs(grid, r, c - 1); // left
        dfs(grid, r, c + 1); // right
    }
}
