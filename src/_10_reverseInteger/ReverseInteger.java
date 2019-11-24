/*
 * Q: Reverse digits of an integer. For example: x=123, return 321
 * Q: When reversed integer overflows, function should return 0
 */
package _10_reverseInteger;

/**
 *
 * @author I300939
 */
public class ReverseInteger {
    public int reverse(int x) {
        int ret = 0;
        while (x != 0) {
            // handle overflow/underflow
            if (Math.abs(ret) > Integer.MAX_VALUE / 10) {
                return 0;
            }
            ret = ret * 10 + x % 10;
            x /= 10;
        }
        return ret;
    }
    
    public static void main(String[] args) {
        ReverseInteger me = new ReverseInteger();
        System.out.println(me.reverse(123));
        System.out.println(me.reverse(-123));
        System.out.println(me.reverse(1000000003));
    }
}
