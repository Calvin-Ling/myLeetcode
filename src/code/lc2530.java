package code;

import java.util.PriorityQueue;

/*给你一个下标从 0 开始的整数数组 nums 和一个整数 k 。你的 起始分数 为 0 。

        在一步 操作 中：

        选出一个满足 0 <= i < nums.length 的下标 i ，
        将你的 分数 增加 nums[i] ，并且
        将 nums[i] 替换为 ceil(nums[i] / 3) 。
        返回在 恰好 执行 k 次操作后，你可能获得的最大分数。

        向上取整函数 ceil(val) 的结果是大于或等于 val 的最小整数。

        来源：力扣（LeetCode）
        链接：https://leetcode.cn/problems/maximal-score-after-applying-k-operations
        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/
public class lc2530 {
    public long maxKelements(int[] nums, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(((o1, o2) -> o2 - o1));
        for (int num : nums) {
            maxHeap.offer(num);
        }
        long res = 0;
        while (--k >= 0 && !maxHeap.isEmpty()) {
            int maxVal = maxHeap.poll();
            System.out.println(maxVal);
            res = res + (long) maxVal;
            int val = (int) Math.ceil((double) maxVal / 3);
            maxHeap.offer(val);
        }
        return res;
    }
}
