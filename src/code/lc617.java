package code;

public class lc617 {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        return mergeTreesInternal(root1, root2);
    }

    public TreeNode mergeTreesInternal(TreeNode root1, TreeNode root2) {
        if (root1 == null) {
            return root2;
        } else if (root2 == null) {
            return root1;
        } else {
            return new TreeNode(root1.val + root2.val,
                    mergeTreesInternal(root1.left, root2.left),
                    mergeTreesInternal(root1.right, root2.right));
        }
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
