package com.test.leetcode2105;

/**
 * @ClassName Leetcode0522
 * @Author chenjian
 * @Date 2021-05-27 12:34
 */
public class Leetcode0522 {
    public boolean xorGame(int[] nums) {
        if (nums.length % 2 == 0) {
            return true;
        }
        int xor = 0;
        for (int num : nums) {
            xor ^= num;
        }
        return xor == 0;
    }
}
