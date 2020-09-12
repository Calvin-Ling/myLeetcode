package JZ;

/**
 * 56.数组中数字出现的次数
 * 一个整型数组 nums 里除两个数字之外，其他数字都出现了两次。请写程序找出这两个只出现一次的数字。要求时间复杂度是O(n)，空间复杂度是O(1)。
 * 示例 1：
 *
 * 输入：nums = [4,1,4,6]
 * 输出：[1,6] 或 [6,1]
 * 示例 2：
 *
 * 输入：nums = [1,2,10,4,1,4,3,3]
 * 输出：[2,10] 或 [10,2]
 *
 * 限制：
 *
 * 2 <= nums.length <= 10000
 *
 * 解法：所有数字异或的结果为a，在a中取第i位，二进制的值为1（表示那两个独特的数字在这一位是不一样的），
 * 在原数组中，二进制第i位为1的分成一组，为0的分成另一组，就可以保证两组：
 *              1.要求的那两个独特的数字不在同一组
 *              2.相同的数字都在一组
 * 再分别对这两组异或，即可以求出那两个独特的数字
 * @author Calvin
 * @version 1.0
 * @date 2020/9/5 23:00
 */
public class jz56 {
    public int[] singleNumbers(int[] nums) {
        int a = 0;
        for (int num : nums) a^=num;
        //获取为1的任意一位，这里选最低位
        int mask = 1;
        while ((a&mask) == 0) mask <<= 1;
        int x = 0, y = 0;
        for (int num : nums){
            if ((num & mask) == 0){
                x ^= num;
            }else {
                y ^= num;
            }
        }
        return new int[]{x,y};
    }
}
