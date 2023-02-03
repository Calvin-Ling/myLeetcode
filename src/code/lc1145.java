package code;

import java.util.Stack;

public class lc1145 {
    public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
        TreeNode xNode = null;
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        while (true) {
            TreeNode p = stack.pop();
            if (p.val == x) {
                xNode = p;
                break;
            }
            if (p.left != null) stack.add(p.left);
            if (p.right != null) stack.add(p.right);
        }
        int lCount = getCount(xNode.left);
        if (lCount >= (n + 1)/2) return true;
        int rCount = getCount(xNode.right);
        if (rCount >= (n + 1)/2) return true;
        int remain = n - lCount - rCount - 1;
        return remain >= (n+1)/2;
    }

    private int getCount (TreeNode node) {
        if (node == null) return 0;
        return 1 + getCount(node.left) + getCount(node.right);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
