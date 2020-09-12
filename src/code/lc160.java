package code;

/**
 * 160.相交链表
 * 编写一个程序，找到两个单链表相交的起始节点。
 *
 * 双指针，p1和p2，当p1到A的最后一个结点时，重定向到B的初始结点，当p2到B的最后一个结点时，重定向到A的初始结点
 * 相遇的结点即为所求，p1和p2均只需重定向一次。
 * 对的人总会相遇
 * @author Calvin
 * @version 1.0
 * @date 2020/8/19 15:15
 */
public class lc160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode p1 = headA,p2 = headB;
        int flag = 2;
        while (p1 != p2){
            if (p1.next != null){
                p1 = p1.next;
            }else {
                if (flag > 0){
                    p1 = headB;flag--;
                }else {
                    return null;
                }
            }
            if (p2.next != null){
                p2 = p2.next;
            }else {
                if (flag > 0){
                    p2 = headA;flag--;
                }else {
                    return null;
                }
            }
        }
        return p1;
    }
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
        val = x;
        next = null;
        }
    }
}
