package com.ltaocs.stack;

import java.util.Stack;

/**
 * Lin Tao
 * a.ltaocs.com
 * LeetCode 946. Validate Stack Sequences
 * Given two sequences pushed and popped with distinct values, return true if and only if this could have been the result of a sequence of push and pop operations on an initially empty stack.
 * Example 1:
 * Input: pushed = [1,2,3,4,5], popped = [4,5,3,2,1]
 * Output: true
 * Explanation: We might do the following sequence:
 * push(1), push(2), push(3), push(4), pop() -> 4,
 * push(5), pop() -> 5, pop() -> 3, pop() -> 2, pop() -> 1
 * Example 2:
 * Input: pushed = [1,2,3,4,5], popped = [4,3,5,1,2]
 * Output: false
 * Explanation: 1 cannot be popped before 2.
 * Note:
 * 0 <= pushed.length == popped.length <= 1000
 * 0 <= pushed[i], popped[i] < 1000
 * pushed is a permutation of popped.
 * pushed and popped have distinct values.
 */
public class ValidateStackSequences {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int poppedPoint = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < pushed.length; i++) {
            if (pushed[i] != popped[poppedPoint]) {
                stack.push(pushed[i]);
            } else {
                poppedPoint++;
                while (!stack.empty() && stack.peek() == popped[poppedPoint]) {
                    poppedPoint++;
                    stack.pop();
                }
            }
        }
        for (int i = poppedPoint; i < popped.length; i++) {
            if (!stack.empty()) {
                int pop = stack.pop();
                if (pop != popped[poppedPoint]) {
                    return false;
                } else {
                    poppedPoint++;
                }
            }
        }
        return stack.empty() ? true : false;
    }

    public static void main(String[] args) {
        int[] pushed = {1, 2, 3, 4, 5};
        int[] popped = {4, 5, 3, 2, 1};
        int[] pushed1 = {2, 1, 0};
        int[] popped1 = {1, 2, 0};
        ValidateStackSequences v = new ValidateStackSequences();
        System.out.println(v.validateStackSequences(pushed1, popped1));
    }
}


