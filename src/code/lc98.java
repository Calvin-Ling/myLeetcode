package code;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 98.验证二叉搜索树
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 *
 * 难度：中等
 * 类型：树，二叉搜索树，BST
 * 思路：中序遍历，若当前值比大于或等于上一个遍历的值，则为false
 */
public class lc98 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    List<Integer> list = new LinkedList<>();
    public boolean isValidBST(TreeNode root) {
        if (root == null)
            return true;
        inner(root);
        int pre = list.get(0);
        int flag = 1;
        for (int i:list) {
            if (flag == 1)
                flag --;
            else if (i <= pre)
                return false;
            else
                pre = i;
        }
        return true;
    }
    public void inner(TreeNode root){
        if (root.left != null){
            inner(root.left);
        }
        list.add(root.val);
        if (root.right != null){
            inner(root.right);
        }
    }
}
