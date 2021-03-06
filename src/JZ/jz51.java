package JZ;

/**
 * 51.逆序对
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: [7,5,6,4]
 * 输出: 5
 *
 * 双重循环超时
 * 解法：https://leetcode-cn.com/problems/shu-zu-zhong-de-ni-xu-dui-lcof/solution/shu-zu-zhong-de-ni-xu-dui-by-leetcode-solution/
 * @author Calvin
 * @version 1.0
 * @date 2020/9/11 13:51
 */
public class jz51 {
    public int reversePairs(int[] nums) {
        int res = 0;
        for(int i = 0; i < nums.length-1; i++){
            for(int j = i+1; j < nums.length; j++){
                if(nums[i] > nums[j]) res++;
            }
        }
        return res;
    }
}
