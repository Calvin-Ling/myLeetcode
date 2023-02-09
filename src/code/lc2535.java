package code;

import java.util.Arrays;

/*给你一个正整数数组 nums 。

        元素和 是 nums 中的所有元素相加求和。
        数字和 是 nums 中每一个元素的每一数位（重复数位需多次求和）相加求和。
        返回 元素和 与 数字和 的绝对差。

        注意：两个整数 x 和 y 的绝对差定义为 |x - y| 。

        来源：力扣（LeetCode）
        链接：https://leetcode.cn/problems/difference-between-element-sum-and-digit-sum-of-an-array
        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/
public class lc2535 {
    public int differenceOfSum(int[] nums) {
        int s1 = Arrays.stream(nums).sum();
        int s2 = 0;
        for (int num : nums) {
            String str = num + "";
            for (int i = 0; i < str.length(); i++) {
                s2 += (str.charAt(i) - '0');
            }
        }
        return Math.abs(s1 - s2);
    }
}
