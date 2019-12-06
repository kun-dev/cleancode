/*
 * Tower of Hanoi is a mathmatical puzzle where we have three rods and n disks.
 * The objective of the puzzle is move the entire stack to another rod, obeying
 * the following simple rules:
 * 1) Only one disk can moved at a time.
 * 2) Each move consists of taking the upper disk from one of stacks and placing
 *    it on top of another stack i.e a disk can only moved if it is the uppermost
 *    disk on a stack.
 * 3) No disk may be placed on top of a smaller disk.
 */
package _99_interviewQ;

/**
 *
 * @author I300939
 */
public class TowerOfHanoi {
    public static void towerOfHanoi(int n, char from_rod, char to_rod, char throu_rod) {
        if (n == 1) System.out.println("move disk 1 from rod: " + from_rod + " to rod:" + to_rod);
        towerOfHanoi(n-1, from_rod, throu_rod, to_rod);
        System.out.println("move disk n from rod: " + from_rod + " to rod: " + to_rod);
        towerOfHanoi(n-1, throu_rod, to_rod, from_rod);
    }
    
    public static void main(String[] args) {
        int n = 4;
        towerOfHanoi(n, 'A', 'C', 'B');
    }
}
