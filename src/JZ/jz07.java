package JZ;

/**
 * 7.重建二叉树
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如，给出
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 返回如下的二叉树：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * @author Calvin
 * @version 1.0
 * @date 2020/8/29 7:46
 */
public class jz07 {
    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int x){
            this.val = x;
        }
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(0, 0, inorder.length - 1, preorder, inorder);
    }

    public TreeNode helper(int preStart,int inStart,int inEnd,int[] preorder, int[] inorder){
        if (preStart >= preorder.length || inStart > inEnd) return null;
        TreeNode root = new TreeNode(preorder[preStart]);
        int index = 0;//root结点在中序遍历的位置
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == root.val){
                index = i;break;
            }
        }
        root.left = helper(preStart+1,inStart,index-1,preorder,inorder);
        root.right = helper(preStart+1+index-inStart,index+1,inEnd,preorder,inorder);
        return root;
    }
}
