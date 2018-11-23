package com.ltaocs.array;

/**
 * Lin Tao
 * a.ltaocs.com
 * Leetcode 941. Valid Mountain Array
 */
public class ValidMountainArray {
    public boolean validMountainArray(int[] A) {
        int len = A.length;
        int peek1 = -1;
        int peek2 = -2;
        if (len < 3) {
            return false;
        }
        for (int i = 0; i < len - 1; i++) {
            if (A[i] == A[i + 1]) {
                return false;
            }
            if (A[i] > A[i + 1]) {
                peek1 = i;
                break;
            }
        }
        int end = 0;
        if (peek1 > 0) {
            end = peek1 - 1;
        }
        for (int i = len - 2; i >= end; i--) {
            if (A[i] == A[i + 1]) {
                return false;
            }
            if (A[i] < A[i + 1]) {
                peek2 = i + 1;
                break;
            }
        }
        return peek1 == peek2;
    }

    public static void main(String[] args) {
        int[] A = {14, 82, 89, 84, 79, 70, 70, 68, 67, 66, 63, 60, 58, 54, 44, 43, 32, 28, 26, 25, 22, 15, 13, 12, 10, 8, 7, 5, 4, 3};
        ValidMountainArray L = new ValidMountainArray();
        System.out.println(L.validMountainArray(A));
    }
}
