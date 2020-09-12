package JZ;

/**
 * 从尾到头打印链表
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 * @author Calvin
 * @version 1.0
 * @date 2020/8/28 16:26
 */
public class jz06 {
    public static int[] reversePrint(ListNode head) {
        //单链表逆序
        ListNode pre = null;
        ListNode next = null;
        int len = 0;
        while(head != null){
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
            len++;
        }
        int[] res = new int[len];
        for (int i = 0; i < len; i++) {
            res[i] = pre.val;
            System.out.println(res[i]);
            pre = pre.next;
        }
        return res;
    }

    public static void main(String[] args){
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        node1.next = node3;node3.next = node2;
        reversePrint(node1);
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
