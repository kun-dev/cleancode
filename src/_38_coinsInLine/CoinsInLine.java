/*
 * There are n coins in a line (assume n is even). Two players take turns to take
 * a coin from one of the ends of the line until there are no more coins left. The
 * player with the larger amount of money wins.
 * 1. Would you rather go first or second? Does it matter?
 * 2. Assume that you go first, describe an algorithm to compute the maximum amount
 * of money you can win.
 * Solution: Going first will guarantee that you will not lost. By following the
 * strategy below, you will always win the game (or get a possible tie).
 * 1. Count the sum of all coins that are odd-numbered. (Call this X)
 * 2. Count the sum of all coins that are even-numbered. (Call this Y)
 * 3. If X>Y, take the left-most coin first. Chooose all odd-numbered coins in
 *    subsequent moves.
 * 4. If X<Y, take the right-most coin first. Choose all even-numbered coins in
 *    subsequent moves.
 * 5. If X=Y, you will guarantee to get a tie if you stick with taking only even-
 *    numbered/odd-numberedd coins.
 * By going first and depending on the coin you choose, you are essentially forcing
 * your opponent to take either only even-numbered or odd-numbered coins.
 */
package _38_coinsInLine;

/**
 *
 * @author I300939
 */
public class CoinsInLine {
    
}
