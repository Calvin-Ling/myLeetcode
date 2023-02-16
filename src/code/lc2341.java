package code;

import java.util.Arrays;

/*
https://leetcode.cn/problems/maximum-number-of-pairs-in-array/
 */
public class lc2341 {
    public int[] numberOfPairs(int[] nums) {
        int[] res = new int[2];
        Arrays.sort(nums);
        int index = 0;
        while (index < nums.length) {
            if (index + 1 < nums.length && nums[index] == nums[index + 1]) {
                index+=2;
                res[0]++;
            } else {
                index++;
                res[1]++;
            }
        }
        return res;
    }
}
