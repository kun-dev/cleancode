/*
 * Factorial of a non-negative integer
 * n! = n*(n-1)*(n-2)...*1
 */
package _99_interviewQ;

/**
 *
 * @author I300939
 */
public class Factorial {
    int factorial(int n) {
        if (n < 0) {
            return -1;
        }
        int result = 1;
        while(n > 0) {
            result = result * n--;
        }
        return result;
    }
    public static void main(String[] args) {
        Factorial me = new Factorial();
        System.out.print(me.factorial(6));
    }
}
