package com.test.leetcode2106;

/**
 * 别乱动我代码，水很深，你把握不住
 *
 * @ClassName Leetcode0623
 * @Author chenjian
 * @Date 2021-06-23 12:40
 */
public class Leetcode0623 {
    public int hammingWeight(int n) {
        // return Integer.bitCount(n);
        int ret = 0;
        while (n != 0) {
            n &= n - 1;
            ret++;
        }
        return ret;
    }
}
