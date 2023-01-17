package code;

import java.util.HashMap;
import java.util.Map;

/*给你一个数组 nums ，数组中只包含非负整数。定义 rev(x) 的值为将整数 x 各个数字位反转得到的结果。比方说 rev(123) = 321 ， rev(120) = 21 。我们称满足下面条件的下标对 (i, j) 是 好的 ：

        0 <= i < j < nums.length
        nums[i] + rev(nums[j]) == nums[j] + rev(nums[i])
        请你返回好下标对的数目。由于结果可能会很大，请将结果对 109 + 7 取余 后返回。

        来源：力扣（LeetCode）
        链接：https://leetcode.cn/problems/count-nice-pairs-in-an-array
        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/
public class lc1814 {
    private final int MOD = (int) 1e9 + 7;
    public int countNicePairs(int[] nums) {
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            int k = num - rev(num);
            // 只能这样一个个加，直接乘会超出范围，再取余结果就不对了
            res = (res + map.getOrDefault(k, 0)) % MOD;
            map.put(k, map.getOrDefault(k, 0) + 1);
        }
        return res;
    }

    public int rev(int num) {
        String s = num + "";
        int res = 0, i = 0;
        while (i < s.length()) {
            int m = i, base = 1;
            while (--m >= 0) {
                base *= 10;
            }
            res += (s.charAt(i) - '0') * base;
            i++;
        }
        return res;
    }
}
