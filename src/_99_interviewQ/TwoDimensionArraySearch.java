/*
 * Given an n * m matrix and a number x, find the position of in the matrix if
 * it is present in it. Otherwise print "Not Found". In the given matrix, every
 * row and column is stored in increasing order. The designed algorithm should
 * have linear time complexity.
 */
package _99_interviewQ;

/**
 *
 * @author I300939
 */
public class TwoDimensionArraySearch {
    public static void search(int[][] matrix, int x) {
        int i = 0, j = matrix[0].length - 1;
        while (i < matrix.length && j >= 0) {
            if (matrix[i][j] == x) {
                System.out.printf("Found x at matrix[%s][%s]\n", i, j);
                return;
            } else if (matrix[i][j] > x) {
                j--;
            } else { //matrix[i][j] < x
                i++;
            }
        }
        System.out.println("Not Found");
        return;
    }
    
    public static void main(String[] args) {
        int[][] matrix = {
            {10,20,30,40},
            {15,25,35,45},
            {27,29,37,48},
            {32,33,39,50}
        };
        search(matrix, 29);
    }
}
