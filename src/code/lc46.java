package code;

import java.util.LinkedList;
import java.util.List;

/**
 * 46.全排列
 * 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
 * 示例:
 * 输入: [1,2,3]
 * 输出:
 * [
 *   [1,2,3],
 *   [1,3,2],
 *   [2,1,3],
 *   [2,3,1],
 *   [3,1,2],
 *   [3,2,1]
 * ]
 *
 * 难度：中等
 * 分类：数组、链表、排列
 * 思路：递归，第一篇博客
 */
public class lc46 {
    int n;
    int[] array;
    List<List<Integer>> llist;
    List<Integer> list;//装数字的箱子
    boolean[] arr;

    public List<List<Integer>> permute(int[] nums) {
        n = nums.length;
        array = nums;
        llist = new LinkedList<>();
        list = new LinkedList<>();
        arr = new boolean[n];
        for (int i = 0; i < n; i++) {
            arr[i] = true;
        }
        fullPermutation(0);
        return llist;
    }
    public void fullPermutation(int step){
        if (step == n)
        {
            List<Integer> tmplist = new LinkedList<>(list);
            llist.add(tmplist);
            return;
        }
        for (int i = 0; i < n; i++) {
            if (arr[i]){
                list.add(array[i]);
                arr[i] = false;//该数已从箱子里取出
                fullPermutation(step + 1);
                arr[i] = true;//放回该数至箱子
                list.remove((Integer) array[i]);
            }
        }
        return;
    }
}
