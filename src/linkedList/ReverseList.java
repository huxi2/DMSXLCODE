package linkedList;

import nodes.ListNode;

public class ReverseList {
    public ListNode reverseList(ListNode head) {
        ListNode newHead = new ListNode(-1), p = head, r;
        while (p != null) {
            r = p.next;
            p.next = newHead.next;
            newHead.next = p;
            p = r;
        }
        return newHead.next;
    }
}
