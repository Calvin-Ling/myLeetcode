package JZ;

/**
 * 39.数组中出现次数超过数组长度一半的数字
 * 解法：摩尔投票法，时间O(N) 空间O(1)
 * @author Calvin
 * @version 1.0
 * @date 2020/9/3 14:24
 */
public class jz39 {
    public int majorityElement(int[] nums){
        int x = 0, votes = 0;
        for (int num : nums){
            if (votes == 0) x = num;
            votes += num == x ? 1:-1;
        }
        //验证x是否为出现次数超过数组长度的一半的数字
        int count = 0;
        for (int num : nums){
            count += num == x ? 1 : 0;
        }
        return count > nums.length/2 ? x : 0;
    }
}
