package com.test.leetcode2106;

import java.util.*;

/**
 * 别乱动我代码，水很深，你把握不住
 *
 * @ClassName Leetcode0620
 * @Author chenjian
 * @Date 2021-06-23 12:39
 */
public class Leetcode0620 {
    Map<String, List<String>> edges;
    Set<String> dead;
    String king;

    public void ThroneInheritance(String kingName) {
        edges = new HashMap<String, List<String>>();
        dead = new HashSet<String>();
        king = kingName;
    }

    public void birth(String parentName, String childName) {
        List<String> children = edges.getOrDefault(parentName, new ArrayList<String>());
        children.add(childName);
        edges.put(parentName, children);
    }

    public void death(String name) {
        dead.add(name);
    }

    public List<String> getInheritanceOrder() {
        List<String> ans = new ArrayList<String>();
        preorder(ans, king);
        return ans;
    }

    private void preorder(List<String> ans, String name) {
        if (!dead.contains(name)) {
            ans.add(name);
        }
        List<String> children = edges.getOrDefault(name, new ArrayList<String>());
        for (String childName : children) {
            preorder(ans, childName);
        }
    }
}
