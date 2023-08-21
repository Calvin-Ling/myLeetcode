package code;

public class lc2816 {
    public ListNode doubleIt(ListNode head) {
        ListNode tail = reversList(head);
        ListNode curr = tail, last = curr;
        boolean flag = false;
        while (curr != null) {
            int t = curr.val * 2 + (flag ? 1 : 0);
            flag = t > 9;
            curr.val = flag ? t - 10 : t;
            last = curr;
            curr = curr.next;
        }
        if (flag) last.next = new ListNode(1);
        return reversList(tail);
    }

    private ListNode reversList(ListNode head){
        ListNode last = null, next = head.next;
        while (next != null) {
            head.next = last;
            last = head;
            head = next;
            next = next.next;
        }
        head.next = last;
        return head;
    }
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
