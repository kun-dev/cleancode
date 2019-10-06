/*
 * Validate if a given string is numeric
 */
package _06_validnumber;

/**
 *
 * @author I300939
 */
public class ValidNumber {
    public boolean isNumeric(String s) {
        int i = 0, n = s.length();
        boolean isNumeric = false;
        while (i < n && Character.isWhitespace(s.charAt(i))) i++;
        if (i < n && (s.charAt(i) == '+' || s.charAt(i) == '-')) i++;
        while (i < n && Character.isDigit(s.charAt(i))) {
            i++;
            isNumeric = true;
        }
        if (i < n && (s.charAt(i) == '.')) {
            i++;
            while (i < n && Character.isDigit(s.charAt(i))) {
                i++;
                isNumeric = true;
            }
        }
        while (i < n && Character.isWhitespace(s.charAt(i))) i++;
        return isNumeric && i == n;
    }
    
    public static void main(String[] args) {
        ValidNumber me = new ValidNumber();
        boolean result = me.isNumeric("-232.324232");
        if (result) {
            System.out.println("it is number");
        } else {
            System.out.println("it is not a number");
        }
    }
}
