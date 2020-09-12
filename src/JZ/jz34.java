package JZ;

import java.util.HashMap;
import java.util.Map;

/**
 * 35.复杂链表的拷贝（深拷贝）
 * 请实现 copyRandomList 函数，复制一个复杂链表。在复杂链表中，每个节点除了有一个 next 指针指向下一个节点，还有一个 random 指针指向链表中的任意节点或者 null。
 * 输入：head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
 * 输出：[[7,null],[13,0],[11,4],[10,2],[1,0]]
 *
 * 输入：head = [[1,1],[2,1]]
 * 输出：[[1,1],[2,1]]
 *
 * 输入：head = [[3,null],[3,0],[3,null]]
 * 输出：[[3,null],[3,0],[3,null]]
 *
 * 输入：head = []
 * 输出：[]
 * 解释：给定的链表为空（空指针），因此返回 null。
 *
 * 解法：HashMap ，map中存的是(原节点，拷贝节点)的一个映射
 * 原地修改，将拷贝节点放到源节点后面
 * @author Calvin
 * @version 1.0
 * @date 2020/9/2 15:15
 */
public class jz34 {
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
    public Node copyRandomList(Node head) {
        return func1(head);
    }

    public Node func1(Node head){
        if (head == null) return null;
        Map<Node,Node> map = new HashMap<>();
        for (Node curr = head; curr != null; curr = curr.next) {
            map.put(curr,new Node((curr.val)));
        }
        for (Node curr = head; curr != null; curr = curr.next) {
            map.get(curr).next = map.get(curr.next);
            map.get(curr).random = map.get(curr.random);
        }
        return map.get(head);
    }

    public Node func2(Node head){
        if (head == null) return null;
        for (Node node = head, copy = null; node != null; node = node.next) {
            copy = new Node(node.val);
            copy.next = node.next;
            node.next = copy;
        }
        for (Node node = head; node != null; node = node.next) {
            if (node.random != null){
                node.next.random = node.random.next;
            }
        }
        Node newHead = head.next;
        for (Node node = head, temp = null; node != null && node.next != null;) {
            temp = node.next;
            node.next = temp.next;
            node = temp;
        }
        return newHead;
    }
}
