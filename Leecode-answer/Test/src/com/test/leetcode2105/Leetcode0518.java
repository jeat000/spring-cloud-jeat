package com.test.leetcode2105;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName Leetcode0518
 * @Author chenjian
 * @Date 2021-05-18 12:28
 */
public class Leetcode0518 {
    public static void main(String[] args) {
        int[]s = new int[]{2,3,1,6,7};
        countTriplets(s);
    }

    public static int countTriplets(int[] arr) {
        int n = arr.length;
        Map<Integer, Integer> cnt = new HashMap<Integer, Integer>();
        Map<Integer, Integer> total = new HashMap<Integer, Integer>();
        int ans = 0, s = 0;
        for (int k = 0; k < n; ++k) {
            int val = arr[k];
            if (cnt.containsKey(s ^ val)) {
                ans += cnt.get(s ^ val) * k - total.get(s ^ val);
            }
            cnt.put(s, cnt.getOrDefault(s, 0) + 1);
            total.put(s, total.getOrDefault(s, 0) + k);
            s ^= val;
        }
        return ans;
    }
}
