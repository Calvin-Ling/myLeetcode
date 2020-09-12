package code;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;

/**
 * 102.二叉树层序遍历
 * 给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
 * 示例：
 * 二叉树：[3,9,20,null,null,15,7]
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回其层次遍历结果：
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 *
 * 难度：中等
 * 分类：二叉树
 * 思路：层序遍历算法
 */
public class lc102 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> lists = new LinkedList<>();
        if (root == null){
            return lists;
        }
        List<TreeNode> nodes = new LinkedList<>();//记录当前层的节点，这里可用queue
        nodes.add(root);
        while (!nodes.isEmpty()){
            List<Integer> list = new LinkedList<>();
            int size = nodes.size();//记录当前nodes的个数
            for (int i = 0; i < size; i++) {//遍历这一层的节点
                TreeNode removeNode = nodes.remove(0);//从记录中取出当前遍历的节点
                list.add(removeNode.val);
                if (removeNode.left != null){//填入下一层要遍历的节点
                    nodes.add(removeNode.left);
                }
                if (removeNode.right != null){
                    nodes.add(removeNode.right);
                }
            }
            lists.add(list);Collections.reverse(list);
        }
        return lists;
    }

    public void test(){
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        TreeNode right = new TreeNode(20);
        right.left =new TreeNode(15);
        right.right = new TreeNode(7);
        root.right = right;

        List<List<Integer>> lists = levelOrder(root);
        for (List<Integer> list: lists) {
            for (Integer n: list) {
                System.out.print(n+" ");
            }
            System.out.println();
        }
    }
}
