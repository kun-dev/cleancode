/*
 * The Fibonacci numbers are the numbers in the following integer sequence
 * Fn = F(n-1) + F(n-2)
 * F0 = 0 F1 = 1
 */
package _99_interviewQ;

/**
 *
 * @author I300939
 */
public class Fibonacci {
    // Time complexity is exponential, we can oberve that implementation does
    // a lot of repeated work, so this is a bad implementation for nth fibonacci
    static int fib1(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("wrong input");
        }
        if (n <= 1) {
            return n;
        }
        return fib1(n-1) + fib1(n-2);
    }
    
    //fibonacci series using dynamic programming
    static int fib2(int n) {
        // declare an array to store fibonacci numbers
        int f[] = new int[n+2]; // 1 extra to handle case, n = 0;
        f[0] = 0;
        f[1] = 1;
        for (int i = 2; i <=n; i++) {
            f[i] = f[i-1] + f[i-2];
        }
        return f[n];
    }
    
    //fibonacci series using space optimized method
    static int fib3(int n) {
        int a = 0, b = 1, c;
        if (n == 0) {
            return a;
        }
        for (int i = 2; i <= n; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return b;
    }
}
