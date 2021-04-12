package com.test.leetcode2104;

/**
 * @ClassName Leetcode0410
 * @Author chenjian
 * @Date 2021-04-12 12:58
 */
public class Leetcode0410 {
    public boolean isUgly(int n) {
        if (n <= 0) {
            return false;
        }
        int[] factors = {2, 3, 5};
        for (int factor : factors) {
            while (n % factor == 0) {
                n /= factor;
            }
        }
        return n == 1;
    }
}
