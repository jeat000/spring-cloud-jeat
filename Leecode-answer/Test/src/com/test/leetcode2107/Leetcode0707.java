package com.test.leetcode2107;

import java.util.HashMap;
import java.util.Map;

/**
 * 别乱动我代码，水很深，你把握不住
 *
 * @ClassName Leetcode0707
 * @Author chenjian
 * @Date 2021-07-09 12:49
 */
public class Leetcode0707 {
    int mod = (int)1e9+7;
    int max = 1 << 22;
    public int countPairs(int[] ds) {
        Map<Integer, Integer> map = new HashMap<>();
        int ans = 0;
        for (int x : ds) {
            for (int i = 1; i < max; i <<= 1) {
                int t = i - x;
                if (map.containsKey(t)) {
                    ans += map.get(t);
                    if (ans >= mod) ans -= mod;
                }
            }
            map.put(x, map.getOrDefault(x, 0) + 1);
        }
        return ans;
    }
}
