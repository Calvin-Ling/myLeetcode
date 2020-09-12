package code;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Stack;

/**
 * 198. 打家劫舍
 * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，
 * 影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，
 * 如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 * 给定一个代表每个房屋存放金额的非负整数数组，
 * 计算你不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
 *
 * 示例 1：
 * 输入：[1,2,3,1]
 * 输出：4
 * 解释：偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
 *      偷窃到的最高金额 = 1 + 3 = 4 。
 * 示例 2：
 * 输入：[2,7,9,3,1]
 * 输出：12
 * 解释：偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
 *      偷窃到的最高金额 = 2 + 9 + 1 = 12 。
 * 提示：
 * 0 <= nums.length <= 100
 * 0 <= nums[i] <= 400
 *
 * 难度：简单
 * 分类：数组
 * 思路：暴力递归（超时），动规，如：b,a,i。a即将覆盖i，偷i即为b+i，不偷即为a，b再等于原来的a。
 */
public class lc198 {
    public int rob(int[] nums) {
//        int result = ifrob(nums,0,true);
//        return result;

        int a = 0;
        int b = 0;
        for (int i:nums) {
            int temp = a;
            a = Math.max(a,b+i);
            b = temp;
        }
        return a;
    }

    public int ifrob(int[] nums, int index, boolean flag){
        if (index >= nums.length)
            return 0;
        if (flag){
            return Math.max(nums[index]+ifrob(nums,index+1,false),ifrob(nums,index+1,true));
        }
        else {
            return ifrob(nums,index+1,true);
        }
    }
}
