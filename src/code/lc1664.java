package code;

public class lc1664 {
    public int waysToMakeFair(int[] nums) {
        if (nums.length == 1) return 1;
        if (nums.length == 2) return 0;
        int n = nums.length;
        int[] sum = new int[n];
        for (int i = 0; i < n; i++) {
            if (i < 2) sum[i] = nums[i];
            else sum[i] = nums[i] + sum[i-2];
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                if (n % 2 == 0) {
                    count+= ((sum[n-2] - sum[0]) == sum[n-1] ? 1 : 0);
                } else {
                    count+= ((sum[n-1] - sum[0]) == sum[n-2] ? 1 : 0);
                }
            } else if (i == 1) {
                if (n % 2 == 0) {
                    count+= ((sum[n-2] - sum[0]) == (sum[0] + sum[n-1] - sum[1]) ? 1 : 0);
                } else {
                    count+= ((sum[n-1] - sum[0]) == (sum[0] + sum[n-2] - sum[1]) ? 1 : 0);
                }
            } else if (i % 2 == 0) {
                if (n % 2 == 0) {
                    count+= ((sum[i-1] + sum[n-2] - sum[i]) == (sum[i-2] + sum[n-1] - sum[i-1]) ? 1:0);
                } else {
                    count+= ((sum[i-1] + sum[n-1] - sum[i]) == (sum[i-2] + sum[n-2] - sum[i-1]) ? 1:0);
                }
            } else {
                if (n % 2 == 0) {
                    count+= ((sum[i-2] + sum[n-2] - sum[i-1]) == (sum[i-1] + sum[n-1] - sum[i]) ? 1:0);
                } else {
                    count+= ((sum[i-2] + sum[n-1] - sum[i-1]) == (sum[i-1] + sum[n-2] - sum[i]) ? 1:0);
                }
            }
        }
        return count;
    }
}
