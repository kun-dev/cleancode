/*
 * A number could contain an optional exponent part, which is marked by a
 * character 'e' followed by a whole number(exponent). For example, 'le10' is
 * numeric
 */
package _06_validnumber;

/**
 *
 * @author I300939
 */
public class ValidNumberWithExponent {
    public boolean isNumber(String s) {
        int i = 0, n = s.length();
        while (i < n && Character.isWhitespace(s.charAt(i))) i++;
        if (i < n && (s.charAt(i) == '+' || s.charAt(i) == '-')) i++;
        boolean isNumeric = false;
        while (i < n && Character.isDigit(s.charAt(i))) {
            i++;
            isNumeric = true;
        }
        if (i < n && s.charAt(i) == '.') {
            i++;
            while (i < n && Character.isDigit(s.charAt(i))) {
                i++;
                isNumeric = true;
            }
        }
        if (isNumeric && i < n && s.charAt(i) == 'e') {
            i++;
            isNumeric = false;
            if (i < n && (s.charAt(i) == '+' || s.charAt(i) == '-')) i++;
            while (i < n && Character.isDigit(s.charAt(i))) {
                i++;
                isNumeric = true;
            }
        }
        while (i < n && Character.isWhitespace(s.charAt(i))) i++;
        return isNumeric && i == n;
    }
    
    public static void main(String[] args) {
        ValidNumberWithExponent me = new ValidNumberWithExponent();
        boolean result = me.isNumber("12.32e21");
        if (result) {
            System.out.println("it is a number");
        } else {
            System.out.println("it is not a number");
        }
    }
}
