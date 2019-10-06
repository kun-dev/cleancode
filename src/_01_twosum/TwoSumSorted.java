/*
 * Similar to the unsorted two sum question, excepted that the input array is
 * already sorted in the ascending order
 * O(n) runtime, O(1) space - Two pointer
 * Let's assume we have two indices pointing to the ith and jth elements, Ai and
 * Aj respectively. The sume of Ai and Aj could only fall into one of there
 * three possibilities:
 * i. Ai + Aj > target, we should decrement j
 * ii. Ai + Aj < target, we should increase i
 * iii. Ai + Aj == traget, found the answer
 */
package _01_twosum;

/**
 *
 * @author I300939
 */
public class TwoSumSorted {
    public int[] twoSum(int[] numbers, int target) {
        // assume numbers is already sorted
        int i = 0, j = numbers.length -1;
        while (i < j) {
            int sum = numbers[i] + numbers[j];
            if (sum > target) {
                j--;
            } else if (sum < target) {
                i++;
            } else {
                return new int[] {i+1, j+1};
            }
        }
        throw new IllegalArgumentException("No two sum found");
    }
    
    public static void main(String[] args) {
        TwoSumSorted me = new TwoSumSorted();
        int[] result = me.twoSum(new int[] {1, 3, 5, 7 ,8}, 10);
        System.out.println("the result is: " + result[0] + " : " + result[1]);
    }
}
