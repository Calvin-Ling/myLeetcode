package JZ;

import java.util.Stack;

/**
 * 36.二叉搜索树与双向链表
 * 题目：https://leetcode-cn.com/problems/er-cha-sou-suo-shu-yu-shuang-xiang-lian-biao-lcof/
 * @author Calvin
 * @version 1.0
 * @date 2020/9/2 16:58
 */
public class jz36 {
    class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val,Node _left,Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }
    //中序遍历
    Node pre, head;
    public Node treeToDoublyList(Node root) {
        //递归写法：
        /*
        if(root == null) return null;
        dfs(root);
        head.left = pre;
        pre.right = head;
        return head;
        */
        //利用栈
        if (root == null) return null;
        Stack<Node> stack = new Stack<>();
        while (!stack.isEmpty() || root != null){
            if (root != null){
                stack.push(root);
                root = root.left;
            }else {
                root = stack.pop();
                if (pre != null) pre.right = root;
                else head = root;
                root.left = pre;
                pre = root;
                root = root.right;
            }
        }
        head.left = pre;
        pre.right = head;
        return head;
    }
    void dfs(Node cur) {
        if(cur == null) return;
        dfs(cur.left);
        if(pre != null) pre.right = cur;
        else head = cur;
        cur.left = pre;
        pre = cur;
        dfs(cur.right);
    }
}
