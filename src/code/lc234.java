package code;

public class lc234 {
    public boolean isPalindrome(ListNode head) {
        int count = 0;
        ListNode curr = head;
        while (curr != null) {
            curr = curr.next;
            count++;
        }
        if (count == 1) return true;
        // 从中间分为两个list
        int m = count / 2;
        curr = head;
        while (--m > 0) {
            curr = curr.next;
        }
        ListNode behind = count % 2 == 0 ? curr.next : curr.next.next;
        curr.next = null;
        if (count / 2 == 1) return head.val == behind.val;
        // 反转后面的list
        ListNode last = behind;
        behind = behind.next;
        ListNode next = behind.next;
        last.next = null;
        behind.next = last;
        while (next != null) {
            last = behind;
            behind = next;
            next =  next.next;
            behind.next = last;
        }
        // 比较
        m = count / 2;
        ListNode before = head;
        while (--m >= 0) {
            if (before.val != behind.val) return false;
            before = before.next;
            behind = behind.next;
        }
        return true;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
