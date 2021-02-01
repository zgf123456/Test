package com.zgf.Test.aligorthm.twopoint;

/**
 * https://leetcode-cn.com/problems/reverse-nodes-in-k-group/
 * <p>
 * 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
 * <p>
 * k 是一个正整数，它的值小于或等于链表的长度。
 * <p>
 * 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序
 */
public class ReverseKGroup {
    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        listNode1.next = listNode2;
        ListNode listNode3 = new ListNode(3);
        listNode2.next = listNode3;
        ListNode listNode4 = new ListNode(4);
        listNode3.next = listNode4;
        ListNode listNode5 = new ListNode(5);
        listNode4.next = listNode5;
        ReverseKGroup reverseKGroup = new ReverseKGroup();
        ListNode listNode = reverseKGroup.reverseKGroup(listNode1, 2);

        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }

    /**
     * 思路快慢指针
     *
     * @param head
     * @param k
     * @return
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) return head;

        ListNode slow = head;
        ListNode fast = head;
        int n = 1;
        while (fast.next != null && n < k) {
            fast = fast.next;
            n++;
        }

        if (n < k) {
            return head;
        }

        // 翻转slow和fast之间的链表
        head = fast;
        n = 1;
        ListNode cur = slow;
        ListNode curNext = cur.next;
        slow.next = fast.next;
        while (n < k) {
            ListNode temp = cur;
            cur = curNext;
            curNext = cur.next;
            cur.next = temp;
            n++;
        }

        ListNode listNode = reverseKGroup(slow.next, k);
        slow.next = listNode;
        return head;
    }
}
