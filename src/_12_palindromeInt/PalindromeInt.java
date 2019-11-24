/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package _12_palindromeInt;

/**
 *
 * @author I300939
 */
public class PalindromeInt {
    
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        int div = 1;
        while (x/div >= 10) {
            div *= 10;
        }
        while (x!=0) {
            int l = x/div;
            int r = x%10;
            if (l != r) return false;
            x = (x % div) / 10;
            div /= 100;
        }
        return true;
    }
    
    public static void main(String[] args) {
        PalindromeInt me = new PalindromeInt();
        System.out.println(me.isPalindrome(1000001));
        System.out.println(me.isPalindrome(224432));
    }
}
