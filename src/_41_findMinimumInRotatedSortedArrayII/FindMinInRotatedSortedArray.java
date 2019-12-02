/*
 * If the rotated sorted array could contain duplicates? What is the runtime
 * complexity?
 * O(n)
 */
package _41_findMinimumInRotatedSortedArrayII;

/**
 *
 * @author I300939
 */
public class FindMinInRotatedSortedArray {
    public int findMin(int[] A) {
        int L = 0, R = A.length - 1;
        while (L < R && A[L] >= A[R]) {
            int M = (L + R) / 2;
            if (A[M] > A[R]) {
                L = M + 1;
            } else if (A[M] < A[L]) {
                R = M;
            } else {
                L = L + 1;
            }
        }
        return A[L];
    }
}
