package other;

import nodes.ListNode;

public class ReorderList {
    public void reorderList(ListNode head) {
        //拆分两段列表
        if (head == null || head.next == null) return;
        ListNode left = head, right = head.next;
        while (right != null) {
            left = left.next;
            right = right.next;
            if (right == null) break;
            right = right.next;
        }
        right = left.next;
        left.next = null;
        left = head;

        // 头插法逆置
        ListNode new_head = new ListNode(-1);
        ListNode p;
        while (right != null) {
            p = right;
            right = right.next;
            p.next = new_head.next;
            new_head.next = p;
        }
        right = new_head.next;

        p = new ListNode(-1);
        while (left != null && right != null) {
            p.next = left;
            p = left;
            left = left.next;
            p.next = right;
            p = right;
            right = right.next;
        }
        if (left != null) p.next = left;
    }
}
