/*
 * Givin a matrix of m*n elements (m rows, n columns), return all elements of
 * the matrix in spiral order.
 * For example, givin the following matrix:
 * [
 *    [1,2,3]
 *    [4,5,6]
 *    [7,8,9]
 * ]
 * You should return [1,2,3,6,9,8,7,4,5]
 * We simulate walking the matrix from the top corner in a spiral manner. In the
 * outmost level, we traverse n steps right, m-1 steps down, n-1 steps left, and
 * m-2 steps up, then we continue traverse into its next inner level.
 *
 * A cleaner solution is to keep track of our current position and the number of
 * steps in both horizontal and vertical directions. As we change direction we
 * decrement the steps in that direction. When the number of steps in a direction
 * becomes zero, we know that we have finished traversing the entire matrix.
 */

package _26_spiralMatrix;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author I300939
 */
public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> elements = new ArrayList<>();
        if (matrix.length == 0) return elements;
        int m = matrix.length, n = matrix[0].length;
        int row = 0, col = -1;
        while(true) {
            for (int i = 0; i < n; i++) {
                elements.add(matrix[row][++col]);
            }
            if (--m == 0) break;
            for (int i = 0; i < m; i++) {
                elements.add(matrix[++row][col]);
            }
            if (--n == 0) break;
            for (int i = 0; i < n; i++) {
                elements.add(matrix[row][--col]);
            }
            if (--m == 0) break;
            for (int i = 0; i < m; i++) {
                elements.add(matrix[--row][col]);
            }
            if (--n == 0) break;
        }
        return elements;
    }
}
