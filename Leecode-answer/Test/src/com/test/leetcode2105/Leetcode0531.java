package com.test.leetcode2105;

/**
 * 别乱动我代码，水很深，你把握不住
 *
 * @ClassName Leetcode0531
 * @Author chenjian
 * @Date 2021-06-03 14:06
 */
public class Leetcode0531 {
    public boolean isPowerOfFour(int n) {
        return n > 0 && (n & (n - 1)) == 0 && n % 3 == 1;
    }
}
