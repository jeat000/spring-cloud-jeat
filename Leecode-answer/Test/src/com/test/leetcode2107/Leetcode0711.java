package com.test.leetcode2107;

import java.util.Arrays;

/**
 * 别乱动我代码，水很深，你把握不住
 *
 * @ClassName Leetcode0711
 * @Author chenjian
 * @Date 2021-07-15 12:40
 */
public class Leetcode0711 {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int h = 0, i = citations.length - 1;
        while (i >= 0 && citations[i] > h) {
            h++;
            i--;
        }
        return h;
    }
}
