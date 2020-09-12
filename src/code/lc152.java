package code;

/**
 * 152.乘积最大子数组
 * 给你一个整数数组 nums ，
 * 请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字），
 * 并返回该子数组所对应的乘积。
 *
 * 示例 1:
 * 输入: [2,3,-2,4]
 * 输出: 6
 * 解释: 子数组 [2,3] 有最大乘积 6。
 * 示例 2:
 * 输入: [-2,0,-1]
 * 输出: 0
 * 解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。
 *
 * 难度：中等
 * 类型：数组，动规
 * 思路：fmax[i]=max(fmax[i-1]*nums[i],fmin[i-1]*nums[i],nums[i]);fmin[i]=min(fmax[i-1]*nums[i],fmin[i-1]*nums[i],nums[i])
 */
public class lc152 {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int fmax = nums[0];
        int fmin = nums[0];
        int result = nums[0];
        for (int i = 1; i < n; i++) {
            int tmpmax = fmax;
            int tmpmin = fmin;
            fmax = Math.max(tmpmax*nums[i],Math.max(tmpmin*nums[i],nums[i]));
            fmin = Math.min(tmpmax*nums[i],Math.min(tmpmin*nums[i],nums[i]));
            result = Math.max(result,fmax);
        }
        return result;
    }
}
