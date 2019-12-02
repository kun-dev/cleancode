/*
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 * Find the minimum element. You may assume no duplicate exists in the array.
 */
package _40_findMinimumInsortedRotatedArray;

/**
 *
 * @author I300939
 */
public class FindMinInSortedRotatedArray {
    public int findMin(int[] A) {
        int L = 0, R = A.length - 1;
        while (L < R && A[L] >= A[R]) {
            int M = (L + R) / 2;
            if (A[M] > A[R]) {
                L = M + 1;
            } else {
                R = M;
            }
        }
        return A[L];
    }
}
