package code;

/*
给你一个整数数组 nums 和一个整数 x 。每一次操作时，你应当移除数组 nums 最左边或最右边的元素，然后从 x 中减去该元素的值。请注意，需要 修改 数组以供接下来的操作使用。

        如果可以将 x 恰好 减到 0 ，返回 最小操作数 ；否则，返回 -1 。

        来源：力扣（LeetCode）
        链接：https://leetcode.cn/problems/minimum-operations-to-reduce-x-to-zero
        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/
public class lc1658 {
    public int minOperations(int[] nums, int x) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum == x) return nums.length;
        int lSum = 0, rSum = sum, count = nums.length + 1, r = 0;
        for (int l = -1; l < nums.length; l++) {
            if (l >= 0) {
                lSum += nums[l];
            }
            while (lSum + rSum > x && r < nums.length) {
                rSum -= nums[r];
                r++;
            }
            if (lSum + rSum == x) {
                count = Math.min(count, nums.length - r + l + 1);
            }
        }
        return count > nums.length ? -1 : count;
    }
}
