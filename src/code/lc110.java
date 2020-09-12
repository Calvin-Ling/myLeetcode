package code;

/**
 * 110.判断是否为平衡二叉树
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。
 * 本题中，一棵高度平衡二叉树定义为：
 * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。
 * @author Calvin
 * @version 1.0
 * @date 2020/8/17 12:03
 */
public class lc110 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    boolean res = true;
    public boolean isBalanced(TreeNode root) {
        getHeight(root,1);
        return res;
    }

    public int getHeight(TreeNode head,int level){
        if (head == null){
            return level;
        }
        int lh = getHeight(head.left,level+1);
        if (!res){
            return level;
        }
        int rh = getHeight(head.right,level+1);
        if (!res){
            return level;
        }
        if (Math.abs(lh-rh) > 1){
            res = false;
        }
        return Math.max(lh,rh);
    }
}
