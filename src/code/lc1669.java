package code;

public class lc1669 {
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode p = list1, res = list1;
        for (int i = 0; i < b; i++) {
            if (i + 1 < a) list1 = list1.next;
            p = p.next;
        }
        list1.next = list2;
        while (list2.next != null) {
            list2 = list2.next;
        }
        list2.next = p.next;
        return res;
    }
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
