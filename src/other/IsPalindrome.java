package other;

import nodes.ListNode;
import org.junit.Test;

import java.util.Stack;

public class IsPalindrome {
    public boolean isPalindrome(ListNode head) {
        int len = 0;
        Stack<Integer> stack = new Stack<>();
        ListNode p = head;
        while (p != null) {
            len++;
            p = p.next;
        }
        p = head;
        for (int i = 0; i < len / 2; i++) {
            stack.push(p.val);
            p = p.next;
        }

        if (len % 2 != 0) p = p.next;
        while (p != null) {
            if (p.val != stack.peek()) break;
            stack.pop();
            p = p.next;
        }

        return stack.isEmpty();
    }
}
