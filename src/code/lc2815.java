package code;

public class lc2815 {
    public int maxSum(int[] nums) {
        int res = -1;
        int[] m = new int[10];
        for (int num : nums) {
            for (int i = 9; i >= 0; i--) {
                if ((num + "").indexOf(i) > -1) {
                    if (m[i] > 0) {
                        res = Math.max(res, m[i] + num);
                        m[i] = Math.max(m[i], num);
                    } else {
                        m[i] = num;
                    }
                    break;
                }
            }
        }
        return res;
    }
}
