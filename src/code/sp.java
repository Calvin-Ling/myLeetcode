package code;

/**
 * 给定一个长度为n的整数组，数组元素均大于等于0，和一个整数m，
 * 将这个数组分成m个非空的连续子数组。
 * 设计一个算法使得这m个子数组各自和的最大值最小。
 *
 * 输入：
 * nums = [7,2,5,10,8]
 * m = 2
 * 输出：
 * 18
 * 解释：
 * 一共有四种方法将nums分割为2个子数组。
 * 其中最好的方式是将其分为[7,2,5]和[10,8]，
 * 因为此时这两个子数组各自的和的最大值为18，在所有情况中最小。
 */
public class sp {
    public int findMinSumOfSubarray(int[] nums,int m){
        //添加实现
        //二分法“试”出答案
        int minRes = Integer.MAX_VALUE;
        int maxRes = 0;
        for (int i = 0; i < nums.length; i++) {
            minRes = Math.min(minRes,nums[i]);
            maxRes += nums[i];
        }
        return calcu(nums,minRes,maxRes,m);
    }
    public int calcu(int nums[], int low, int high, int m){
        if (low > high)
            return high + 1;
        int mid = (low + high)/2;
        if (juge(nums, mid, m))
            return calcu(nums,low, mid-1,m);
        else
            return calcu(nums,mid+1, high, m);
    }
    public boolean juge(int nums[], int res, int m){
        int seg = 0;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum > res){
                sum = nums[i];
                seg++;
            }
        }
        if (seg >= m)
            return false;
        else
            return true;
    }
}
