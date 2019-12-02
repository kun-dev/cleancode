/*
 * Design a stack that support push, pop, top and retrieving the minimum element
 * in constant time.
 * push(x) - push element x onto stack
 * pop() - removes the element on top of the stack
 * top() - get the top element
 * getMin() - retrieve the minimum element in the stack
 * Consider using an extra stack to keep track of the current minimum value.
 * During the push operation we choose the new element or the current minimum,
 * whichever that is smaller to push onto the min stack.
 * for the pop operation, we would pop from both stacks. getMin() is then reflected
 * by top element of min stack.
 * We can have minor space optimization:
 * If a new element is larger than the current minimum, we do not need to push it
 * on to the min stack. When we perform the pop operation, check if the popped
 * element is the same as the current minimum. If it is, pop it off the main stack
 * too.
 */
package _30_minStack;

import java.util.Stack;

/**
 *
 * @author I300939
 */
public class MinStack {
    private Stack<Integer> stack = new Stack<>();
    private Stack<Integer> minStack = new Stack<>();
    
    public void push(int x) {
        stack.push(x);
        if (minStack.isEmpty() || minStack.peek() >= x) {
            minStack.push(x);
        }
    }
    
    public int pop() {
        int val = stack.pop();
        if (val == minStack.peek()) {
            minStack.pop();
        }
        return val;
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
}
