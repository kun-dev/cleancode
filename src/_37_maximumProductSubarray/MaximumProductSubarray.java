/*
 * Find the contiguous subarray within an array of integers that has the largest
 * product.
 * This problem is very similar to Maximum Sum Subarray. There is a slight twist
 * though. Besides keeping track of the largest product, we also need to keep track
 * of the smallest product. Why? The smallest product, which is the largest in the
 * negative sense could become the maximum when being multiplied by a negative number.
 */
package _37_maximumProductSubarray;

/**
 *
 * @author I300939
 */
public class MaximumProductSubarray {
    public int maxProduct(int[] A) {
        assert A.length > 0;
        int max = A[0], min = A[0], maxAns = A[0];
        for (int i = 1; i < A.length; i++) {
            int mx = max, mn = min;
            max = Math.max(Math.max(A[i], mx * A[i]), mn * A[i]);
            min = Math.min(Math.min(A[i], mx * A[i]), mn * A[i]);
            maxAns = Math.max(max, maxAns);
        }
        return maxAns;
    }
}
