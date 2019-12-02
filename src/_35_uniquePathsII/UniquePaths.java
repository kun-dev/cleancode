/*
 * Similar to previous question, but now consider if some obstacles are added to
 * the grids. How many unique paths would there be?
 * An obstacle and empty space are marked as 1 and 0 respectively in the grid.
 * It turns out to be really easy to extend from the buttom-up dynamic programming
 * approach above. Just set the total paths to 0 when you encounter an obstacle.
 */
package _35_uniquePathsII;

/**
 *
 * @author I300939
 */
public class UniquePaths {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        if (m == 0) return 0;
        int n = obstacleGrid[0].length;
        int[][] mat = new int[m+1][n+1];
        mat[m-1][n] = 1;
        for (int r = m - 1; r >= 0; r--) {
            for (int c = n - 1; c >= 0; c--) {
                mat[r][c] = (obstacleGrid[r][c] == 1) ? 0 : mat[r][c + 1] + mat[r + 1][c];
            }
        }
        return mat[0][0];
    }
}
