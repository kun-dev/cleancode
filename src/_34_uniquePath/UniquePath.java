/*
 * A robot is located at the top-left corner of a m*n grid (marked 'start' in
 * the diagram below). The robot can only move either down or right at any point 
 * in time. The robot is trying to reach the bottom-right corner of the grid
 * (marked 'Finish' in the diagram below). How many possible unique paths are there?
 * The most direct way is to write code that traverses each possible path, which
 * can be done using backtracking. When you reach row = m and col = n, you know
 * you've reached bottom-right corner, and there is one additional unique path
 * to it. However, when you reach row > m or col > n, then it's an invalid path
 * and you should stop traversing. For any grid at row = r and col = c, you have
 * two choices: Traverse to the right or traverse to the bottom. Therefore, the
 * total unique paths at grid(r,c) are equal to the sum of total unique paths
 * from the grid to the right and the grid below.
 */
package _34_uniquePath;

/**
 *
 * @author I300939
 */
public class UniquePath {
    private int backtrack(int r, int c, int m, int n) {
        if (r == m - 1 && c == n - 1) {
            return 1;
        }
        if (r >= m || c >= n) {
            return 0;
        }
        return backtrack(r + 1, c, m, n) + backtrack(r, c + 1, m, n);
    }
    public int uniquePaths(int m, int n) {
        return backtrack(0, 0, m, n);
    }
}
