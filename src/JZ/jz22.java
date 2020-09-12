package JZ;

/**
 * 22.链表中倒数第k个结点
 * 输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，
 * 本题从1开始计数，即链表的尾节点是倒数第1个节点。例如，一个链表有6个节点，从头节点开始，
 * 它们的值依次是1、2、3、4、5、6。这个链表的倒数第3个节点是值为4的节点。
 * 示例：
 *
 * 给定一个链表: 1->2->3->4->5, 和 k = 2.
 * 返回链表 4->5.
 *
 * 解法：快慢指针，快指针比慢指针快k步
 * @author Calvin
 * @version 1.0
 * @date 2020/8/31 13:59
 */
public class jz22 {
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode frommer = head,latter = head;
        int i;
        for (i = 0; i < k && frommer!=null; i++) {
            frommer = frommer.next;
        }
        while (frommer != null){
            frommer = frommer.next;
            latter = latter.next;
        }
        return i>=k ? latter : null;
    }
}
