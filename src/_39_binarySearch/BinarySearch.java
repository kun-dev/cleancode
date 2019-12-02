/*
 * Given a sorted array and a target value, return the index if the target is found.
 * If not, return the index where it would be if it were inserted in order. You
 * may assue no duplicates in the array.
 * This problem is a direct application of Binary Search, as you can spot it easily
 * by the keywords sorted and finding target. The requirement seem complex, but
 * let's first start with something we are already familiar with - the raw binary
 * search algorithm.
 */
package _39_binarySearch;

/**
 *
 * @author I300939
 */
public class BinarySearch {
    public int searchInsert(int[] A, int target) {
        int L = 0, R = A.length - 1;
        while (L < R) {
            int M = (L + R) / 2;
            if (A[M] < target) {
                L = M + 1;
            } else {
                R = M;
            }
        }
        return (A[L] < target) ? L + 1 : L;
    }
}
