package code;
/*
给你一个整数数组 nums （下标 从 0 开始 计数）以及两个整数：low 和 high ，请返回 漂亮数对 的数目。

        漂亮数对 是一个形如 (i, j) 的数对，其中 0 <= i < j < nums.length 且 low <= (nums[i] XOR nums[j]) <= high 。

        来源：力扣（LeetCode）
        链接：https://leetcode.cn/problems/count-pairs-with-xor-in-a-range
        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/
public class lc1803 {
    // 暴力 boom！时间超了
    public int countPairs(int[] nums, int low, int high) {
        int count = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int xorRes = nums[i] ^ nums[j];
                count += (xorRes >= low && xorRes <= high ? 1 : 0);
            }
        }
        return count;
    }

    // 改良版-暴力 侥幸AC
    public int countPairs2(int[] nums, int low, int high) {
        int ans = 0;
        int max = 0;
        int min = Integer.MAX_VALUE;
        int[] freq = new int[20001];
        for (int num : nums) {
            freq[num]++;
            max = Math.max(max, num);
            min = Math.min(min, num);
        }

        for (int j = min; j <= max; j++) {
            if(freq[j] == 0)continue;
            for (int i = low; i <= high; i++) {
                int xor = i ^ j;
                if(xor >=1 && xor <=20000) {
                    ans += freq[j]*freq[xor];
                }
            }
        }
        return ans>>1;
    }
}
