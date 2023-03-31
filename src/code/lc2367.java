package code;

/*
https://leetcode.cn/problems/number-of-arithmetic-triplets/
 */
public class lc2367 {
    public int arithmeticTriplets(int[] nums, int diff) {
        int i = 0, j = 1, k = 2, res = 0;
        while (i < nums.length - 2) {
            j = i + 1;
            while (j < nums.length - 1) {
                if (nums[j] - nums[i] == diff) {
                    k = j + 1;
                    while (k < nums.length) {
                        if (nums[k] - nums[j] == diff) res++;
                        k++;
                    }
                }
                j++;
            }
            i++;
        }
        return res;
    }
}
