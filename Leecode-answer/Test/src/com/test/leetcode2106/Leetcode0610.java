package com.test.leetcode2106;

/**
 * 别乱动我代码，水很深，你把握不住
 *
 * @ClassName Leetcode0610
 * @Author chenjian
 * @Date 2021-06-15 12:48
 */
public class Leetcode0610 {
    public int change(int amount, int[] coins) {
        int[]db = new int[amount+1];
        db[0]=1;
        for(int coin:coins){
            for (int i = coin; i <= amount; i++) {
                db[i] += db[i - coin];
            }
        }
        return db[amount];
    }
}
