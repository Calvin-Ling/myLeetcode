package code;

/*
https://leetcode.cn/problems/house-robber-iv/
 */
public class lc2560 {
    // timeout
    public int minCapability(int[] nums, int k) {
        return minCapabilityInner(nums, k, 0, Integer.MIN_VALUE);
    }

    private int minCapabilityInner (int[] nums, int k, int i, int s) {
        if (k == 0) return s;
        if (k > (nums.length - i) /2) {
            for (int j = i; j < nums.length; j+=2) {
                s = Math.max(s, nums[j]);
            }
            return s;
        } else {
            int yesCap = minCapabilityInner(nums, k-1, i+2, Math.max(s, nums[i]));
            int noCap = minCapabilityInner(nums, k, i+1, s);
            return Math.min(yesCap, noCap);
        }
    }
}
