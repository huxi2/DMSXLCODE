package linkedList;

import nodes.ListNode;

public class RemoveElements {
    public ListNode removeElements(ListNode head, int val) {
        ListNode _head = new ListNode(-1, head);
        ListNode pre = _head;
        while (pre.next != null) {
            if (pre.next.val == val) {
                pre.next = pre.next.next;
            } else {
                pre = pre.next;
            }
        }
        return _head.next;
    }
}
