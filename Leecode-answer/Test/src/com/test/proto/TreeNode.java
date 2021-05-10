package com.test.proto;

import com.test.leetcode2105.Leetcode0510;

/**
 * @ClassName TreeNode
 * @Author chenjian
 * @Date 2021-05-10 12:36
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode() {}
    public TreeNode(int val) { this.val = val; }
    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.left = left;
        this.right = right;
        this.val = val;
    }
}
