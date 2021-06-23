package com.test.leetcode2106;

import java.util.HashSet;
import java.util.Set;

/**
 * 别乱动我代码，水很深，你把握不住
 *
 * @ClassName Leetcode0622
 * @Author chenjian
 * @Date 2021-06-23 12:40
 */
public class Leetcode0622 {
    Set<String> res = new HashSet<>();
    public String[] permutation(String s) {
        dfs(s.toCharArray(),0);
        String[] strArray = new String[res.size()];
        res.toArray(strArray);
        return strArray;
    }

    private void dfs(char[]arr, int i){
        if(i==arr.length){
            res.add(new String(arr));
        }
        for(int x=i; x<arr.length; x++){
            swap(arr,i,x);
            dfs(arr,i+1);
            swap(arr,i,x);
        }
    }

    private void swap(char[]arr,int l, int r){
        if(l==r){
            return;
        }
        char temp = arr[l];
        arr[l]=arr[r];
        arr[r]=temp;
    }
}
