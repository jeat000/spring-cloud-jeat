package com.test.leetcode2106;

import java.util.ArrayList;
import java.util.List;

/**
 * 别乱动我代码，水很深，你把握不住
 *
 * @ClassName Leetcode0621
 * @Author chenjian
 * @Date 2021-06-23 12:40
 */
public class Leetcode0621 {
    public List<String> readBinaryWatch(int turnedOn) {
        List<String> ans = new ArrayList<String>();
        for (int h = 0; h < 12; ++h) {
            for (int m = 0; m < 60; ++m) {
                if (Integer.bitCount(h) + Integer.bitCount(m) == turnedOn) {
                    ans.add(h + ":" + (m < 10 ? "0" : "") + m);
                }
            }
        }
        return ans;
    }
}
