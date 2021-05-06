package com.test.leetcode2105;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName Leetcode0506
 * @Author chenjian
 * @Date 2021-05-06 10:32
 */
public class Leetcode0506 {
    public int[] decode(int[] encoded, int first) {
        int n = encoded.length + 1;
        int[] arr = new int[n];
        arr[0] = first;
        for (int i = 1; i < n; i++) {
            arr[i] = arr[i - 1] ^ encoded[i - 1];
        }
        return arr;
    }
}
