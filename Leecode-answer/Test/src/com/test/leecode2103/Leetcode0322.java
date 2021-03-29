package com.test.leecode2103;

/**
 * @ClassName Leetcode0325
 * @Author chenjian
 * @Date 2021-03-25 14:37
 */
public class Leetcode0322 {
    public int hammingWeight(int n) {
        int ret = 0;
        for (int i = 0; i < 32; i++) {
            if ((n & (1 << i)) != 0) {
                ret++;
            }
        }
        return ret;
    }
}
