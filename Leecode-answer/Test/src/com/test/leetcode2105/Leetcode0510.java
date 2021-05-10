package com.test.leetcode2105;

import com.test.proto.TreeNode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @ClassName Leetcode0510
 * @Author chenjian
 * @Date 2021-05-10 12:32
 */
public class Leetcode0510 {

    public static TreeNode stringToTreeNode(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return null;
        }

        String[] parts = input.split(",");
        String item = parts[0];
        TreeNode root = new TreeNode(Integer.parseInt(item));
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);

        int index = 1;
        while(!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.remove();

            if (index == parts.length) {
                break;
            }

            item = parts[index++];
            item = item.trim();
            if (!item.equals("null")) {
                int leftNumber = Integer.parseInt(item);
                node.left = new TreeNode(leftNumber);
                nodeQueue.add(node.left);
            }

            if (index == parts.length) {
                break;
            }

            item = parts[index++];
            item = item.trim();
            if (!item.equals("null")) {
                int rightNumber = Integer.parseInt(item);
                node.right = new TreeNode(rightNumber);
                nodeQueue.add(node.right);
            }
        }
        return root;
    }

    public static String booleanToString(boolean input) {
        return input ? "True" : "False";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            TreeNode root1 = stringToTreeNode(line);
            line = in.readLine();
            TreeNode root2 = stringToTreeNode(line);

            boolean ret = new Solution().leafSimilar(root1, root2);

            String out = booleanToString(ret);

            System.out.print(out);
        }
    }

}



class Solution {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> seq1 = new ArrayList<Integer>();
        List<Integer> seq2 = new ArrayList<Integer>();
        toRes(root1,seq1);
        toRes(root2,seq2);
        return seq1.equals(seq2);
    }

    private void toRes(TreeNode root, List<Integer> str) {
        if(root.left==null && root.right==null){
            str.add(root.val);
        }else{
            if(root.left!=null){
                toRes(root.left,str);
            }
            if(root.right!=null){
                toRes(root.right,str);
            }
        }
    }
}