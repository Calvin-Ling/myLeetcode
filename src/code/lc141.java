package code;

import java.util.HashSet;
import java.util.Set;
import java.util.Vector;

/**
 * 141. 环形链表
 * 题意：给一个链表，判断链表中是否有环，整数pos表示链表尾部接到链表中的位置（索引从0开始）。如果pos是-1，则该链表中没有环。
 * 难度：简单
 * 分类：链表
 * 思路：判断链表是否有环，显然哈希表
 * 方法一：哈希表，时间空间复杂度O(n)
 * 方法二：双指针，快慢指针，时间负责度O(n),空间复杂度O(1)
 */
public class lc141 {
    class ListNode{
        int val;
        ListNode next;
        ListNode(int x){
            val = x;
            next = null;
        }
    }

    public boolean hasCycle(ListNode head){
        /*
        //哈希表方法实现：
        Set<ListNode> nodes = new HashSet<>();//构造hashSet
        while (head != null){
            if (nodes.contains(head)){
                return true;//出现已经在hashSet的结点，则说明有环
            } else {
                nodes.add(head);
            }
            head = head.next;
        }
        return false;
        */


        //快慢指针实现：
        if (head == null ||head.next == null){
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast){
            if (fast == null || fast.next == null){
                return false;//快指针先到达末端，则说明没有环
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;

        /*
        //破坏表结构的实现：
        while(head !=null){
            if(head == head.next){
                return true;
            }
            if(head.next != null){
                head.next = head.next.next;
            }
            head = head.next;
        }
        return false;
         */
    }
}
