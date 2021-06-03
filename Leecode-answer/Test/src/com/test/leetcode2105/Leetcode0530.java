package com.test.leetcode2105;

/**
 * 别乱动我代码，水很深，你把握不住
 *
 * @ClassName Leetcode0530
 * @Author chenjian
 * @Date 2021-06-03 14:06
 */
public class Leetcode0530 {
    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }
}
