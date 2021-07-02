package com.test.leetcode2106;

/**
 * 别乱动我代码，水很深，你把握不住
 *
 * @ClassName Leetcode0629
 * @Author chenjian
 * @Date 2021-07-02 12:21
 */
public class Leetcode0629 {
    public String convertToTitle(int columnNumber) {
        int n = columnNumber;
        StringBuilder str = new StringBuilder();
        while(n!=0){
            n--;
            str.append((char) ('A' + n % 26));
            n=n/26;
        }
        return str.reverse().toString();
    }
}
