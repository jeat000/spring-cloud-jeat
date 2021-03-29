package com.test.leecode2103;

/**
 * @ClassName Leetcode0329
 * @Author chenjian
 * @Date 2021-03-29 15:45
 */
public class Leetcode0329 {
    public int reverseBits(int n) {
        int rev = 0;
        for (int i = 0; i < 32 && n != 0; ++i) {
            rev |= (n & 1) << (31 - i);
            n >>>= 1;
        }
        return rev;
    }
}
