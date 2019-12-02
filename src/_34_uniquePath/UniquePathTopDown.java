/*
 * If you notice closely, the above DP solution is using a top-down approach. Now
 * let's try bottom-up approach. Remember this important relationship that is
 * necessary for this DP solution to work:
 * The total unique paths at grid(r,c) are equal to the sum of total unique paths
 * from grid to the right (r, c+1) and the grid below (r+1, c)
 */
package _34_uniquePath;

/**
 *
 * @author I300939
 */
public class UniquePathTopDown {
    public int uniquePaths(int m, int n) {
        int[][] mat = new int[m+1][n+1];
        mat[m-1][n] = 1;
        for(int r = m - 1; r >= 0; r--) {
            for(int c = n - 1; c >= 0; c--) {
                mat[r][c] = mat[r+1][c] + mat[r][c + 1];
            }
        }
        return mat[0][0];
    }
}
