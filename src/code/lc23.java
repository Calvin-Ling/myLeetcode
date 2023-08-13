package code;

public class lc23 {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode res = new ListNode(Integer.MIN_VALUE);
        int idx = getMinIndex(lists);
        ListNode curr = res;
        while (idx != -1) {
            curr.next = lists[idx];
            lists[idx] = lists[idx].next;
            curr = curr.next;
            idx = getMinIndex(lists);
        }
        return res.next;
    }
    private int getMinIndex(ListNode[] lists) {
        int idx = -1, min = Integer.MAX_VALUE;
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null && lists[i].val < min) {
                idx = i;
                min = lists[i].val;
            }
        }
        return idx;
    }
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
