package code;

/**
 * 238. 除自身以外数组的乘积
 * 题意：计算除自身以外的数组的乘积，返回output数组，要求时间复杂度在O(n)，不能用除法
 * 难度：中等
 * 分类：数组，链表，动态规划
 * 思路：除了用除法没想出来。
 * 方法一：左右链表相乘法，另外用两个数组分别存储self的左边所有数的乘积L[i]及右边所有数的乘积R[i]，
 *         那么output[i] = L[i] * R[i]，时间空间复杂度都是O（n）
 * 方法二：在方法一的基础上，初始化output数组为L数组，再动态地更新R，即output[i] = output[i]*R，然后R*=nums[i]
 */
public class lc238 {
    public int[] productExceptSelf(int[] nums){
        int n = nums.length;//记录数组长度
        int[] output = new int[n];
        output[0] = 1;//第一个数的左边的乘积可认为是1
        for (int i = 1; i < n; i++) {
            output[i] = output[i-1] * nums[i-1];
        }
        int right = 1;//同理，最后一个数的右边的乘积可认为是1
        for (int i = n-1; i >=0 ; i--) {
            output[i] = output[i] * right;
            right *= nums[i];//更新right的值
        }
        return output;
    }
}
