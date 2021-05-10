package com.test.leetcode2105;

/**
 * @ClassName Leetcode0507
 * @Author chenjian
 * @Date 2021-05-10 12:51
 */
public class Leetcode0507 {
    public int xorOperation(int n, int start) {
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            ans ^= (start + i * 2);
        }
        return ans;
    }
}
