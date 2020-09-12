package JZ;

import java.util.Stack;

/**
 * 33.二叉搜索树的后序遍历序列
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。如果是则返回 true，否则返回 false。假设输入的数组的任意两个数字都互不相同。
 * 解法：递归，时间O(N^2)
 * 借助单调栈，时间O(N)
 * @author Calvin
 * @version 1.0
 * @date 2020/9/2 14:08
 */
public class jz33 {
    public boolean verifyPostorder(int[] postorder) {
        //递归：
        //return func(postorder,0,postorder.length-1,Integer.MAX_VALUE);
        //单调栈解法：
        Stack<Integer> stack = new Stack<>();
        int root = Integer.MAX_VALUE;
        for (int i = postorder.length-1; i >= 0; i--) {
            if (postorder[i] > root) return false;
            while (!stack.isEmpty()&&stack.peek() > postorder[i]) root = stack.pop();
            stack.add(postorder[i]);
        }
        return true;
    }

    public boolean func(int[] postorder, int start, int end, int parent){
        if(start >= end) return true;
        int i;
        for(i = end - 1; i >= start; i--){
            if(postorder[i] < postorder[end]) break;
            if(postorder[i] > parent) return false;
        }
        return func(postorder,start,i,postorder[end])&&func(postorder,i+1,end-1,parent);
    }
}
