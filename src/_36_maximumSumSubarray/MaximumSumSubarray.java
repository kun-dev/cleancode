/*
 * Find the contiguous subarray within an array that has the largest sum.
 */
package _36_maximumSumSubarray;

/**
 *
 * @author I300939
 */
public class MaximumSumSubarray {
    public int maxSubArray(int[] A) {
        int maxEndingHere = A[0], maxSoFar = A[0];
        for (int i = 1; i < A.length; i++) {
            maxEndingHere = Math.max(maxEndingHere + A[i], A[i]);
            maxSoFar = Math.max(maxEndingHere, maxSoFar);
        }
        return maxSoFar;
    }
}
