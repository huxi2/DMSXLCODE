package other;

import nodes.ListNode;
import org.junit.Test;

public class HasCycle {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;
        ListNode fast = head.next, slow = head;
        while (fast != null && fast != slow) {
            slow = slow.next;
            fast = fast.next;
            if (fast == null) break;
            fast = fast.next;
        }
        return fast != null;
    }
}
