package code;
/*
https://leetcode.cn/problems/take-gifts-from-the-richest-pile/submissions/
 */
public class lc2558 {
    public long pickGifts(int[] gifts, int k) {
        for (int j = 0; j < k; j++) {
            int m = 0;
            for (int i = 0; i < gifts.length; i++) {
                m = gifts[i] > gifts[m] ? i : m;
            }
            gifts[m] = new Double(Math.sqrt(gifts[m])).intValue();
        }
        long res = 0;
        for (int gift : gifts) {
            res+=gift;
        }
        return res;
    }
}
