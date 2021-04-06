package com.test.leetcode2104;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName Leetcode0404
 * @Author chenjian
 * @Date 2021-04-06 10:13
 */
public class Leetcode0404 {
    public int numRabbits(int[] answers) {
        Map<Integer, Integer> count = new HashMap<Integer, Integer>();
        for (int y : answers) {
            count.put(y, count.getOrDefault(y, 0) + 1);
        }
        int ans = 0;
        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            int y = entry.getKey(), x = entry.getValue();
            ans += (x + y) / (y + 1) * (y + 1);
        }
        return ans;
    }
}
