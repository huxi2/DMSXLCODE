package stackQueue;

import java.util.LinkedList;
import java.util.Queue;

public class MyStack {
    Queue<Integer> queue;

    public MyStack() {
        queue = new LinkedList<>();
    }

    public void push(int x) {
        queue.offer(x);
    }

    public int pop() {
        int size = queue.size();
        while (size > 1) {
            queue.offer(queue.poll());
            size--;
        }
        return queue.poll();
    }

    public int top() {
        int size = queue.size(), ans=0;
        while (size > 0) {
            if (size == 1) ans = queue.peek();
            queue.offer(queue.poll());
            size--;
        }
        return ans;
    }

    public boolean empty() {
        return queue.isEmpty();
    }
}
