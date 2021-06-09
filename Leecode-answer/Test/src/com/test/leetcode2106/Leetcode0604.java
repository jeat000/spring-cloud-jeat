package com.test.leetcode2106;

/**
 * 别乱动我代码，水很深，你把握不住
 *
 * @ClassName Leetcode060
 * @Author chenjian
 * @Date 2021-06-09 12:31
 */
public class Leetcode0604 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode pA = headA, pB = headB;
        while (pA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
    }

    public class ListNode {
       int val;
       ListNode next;
       ListNode(int x) {
           val = x;
           next = null;
       }
   }
}
