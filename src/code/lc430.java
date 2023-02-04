package code;

import java.util.Stack;

public class lc430 {
    public Node flatten(Node head) {
        if (head == null) return null;
        Stack<Node> stack = new Stack<>();
        Node p = head;
        while (true) {
            if (p.child != null) {
                if (p.next != null) stack.add(p.next);
                p.next = p.child;
                p.next.prev = p;
                p.child = null;
            }
            if (p.next == null) {
                if (stack.isEmpty()) break;
                Node t = stack.pop();
                p.next = t;
                t.prev = p;
            }
            p = p.next;
        }
        return head;
    }
    class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;
    };
}
