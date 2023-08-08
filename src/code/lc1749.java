package code;

public class lc1749 {
    public int maxAbsoluteSum(int[] nums) {
        int maxRet = 0, minRet = 0, maxSum = 0, minSum = 0;
        for (int i = 0; i < nums.length; i++) {
            maxSum += nums[i];
            maxRet = Math.max(maxRet, maxSum);
            maxSum = Math.max(0, maxSum);

            minSum += nums[i];
            minRet = Math.min(minRet, minSum);
            minSum = Math.min(0, minSum);
        }
        return Math.max(maxRet, -minRet);
    }
}
