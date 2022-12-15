package linkedList;

import nodes.ListNode;

public class DetectCycle {
    public ListNode detectCycle(ListNode head) {
        ListNode newHead = new ListNode(-1, head);
        //跳过第一次移动  因为第一次fast = slow = newHead
        ListNode fast = head.next, slow = head;
        while (fast != null && fast != slow) {
            slow = slow.next;
            fast = fast.next;
            if (fast != null) fast = fast.next;
        }
        if (fast == null) return null;
        //从头开始找
        slow = newHead;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }
}
