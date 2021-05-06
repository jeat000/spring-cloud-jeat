package com.test.leetcode2105;

/**
 * @ClassName Leetcode0503
 * @Author chenjian
 * @Date 2021-05-06 10:31
 */
public class Leetcode0503 {
    public int reverse(int x) {
        int rev = 0;
        while (x != 0) {
            if (rev < Integer.MIN_VALUE / 10 || rev > Integer.MAX_VALUE / 10) {
                return 0;
            }
            int digit = x % 10;
            x /= 10;
            rev = rev * 10 + digit;
        }
        return rev;
    }
}
