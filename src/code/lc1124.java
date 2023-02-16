package code;

/*
https://leetcode.cn/problems/longest-well-performing-interval/
 */
public class lc1124 {
    public int longestWPI(int[] hours) {
        int[] work = new int[hours.length];
        int[] life = new int[hours.length];
        int res = 0, countW = 0, countL = 0;
        for (int i = 0; i < hours.length; i++) {
            if (hours[i] > 8) {
                countW++;
            } else {
                countL++;
            }
            work[i] = countW;
            life[i] = countL;
        }
        for (int i = 0; i < hours.length; i++) {
            for (int j = i; j < hours.length; j++) {
                if (i > 0) {
                    if ((work[j] - work[i-1]) > (life[j] - life[i-1])) {
                        res = Math.max(res, j - i + 1);
                    }
                } else {
                    if (work[j] > life[j]) {
                        res = Math.max(res, j + 1);
                    }
                }
            }
        }
        return res;
    }
}
