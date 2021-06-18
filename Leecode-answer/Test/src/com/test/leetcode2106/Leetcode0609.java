package com.test.leetcode2106;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 别乱动我代码，水很深，你把握不住
 *
 * @ClassName Leetcode0609
 * @Author chenjian
 * @Date 2021-06-09 12:31
 */
public class Leetcode0609 {
    public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
        int[][] dp = new int[n + 1][minProfit + 1];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }
        int len = group.length, MOD = (int)1e9 + 7;
        for (int i = 1; i <= len; i++) {
            int members = group[i - 1], earn = profit[i - 1];
            for (int j = n; j >= members; j--) {
                for (int k = minProfit; k >= 0; k--) {
                    dp[j][k] = (dp[j][k] + dp[j - members][Math.max(0, k - earn)]) % MOD;
                }
            }
        }
        return dp[n][minProfit];
    }

    public static void main(String[] args) {
        Set<String> strings = new HashSet<>();
        strings.add("123");
        strings.add("1");
        strings.add("12");
        strings.add("12");
        Set<String> strings2 = new HashSet<>();
        strings2.add("123");
        strings2.add("1");
        strings2.add("1");
        strings2.add("12");

        System.out.println(strings.equals(strings2));
    }
}
