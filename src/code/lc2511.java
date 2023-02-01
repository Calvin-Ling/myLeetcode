package code;

public class lc2511 {
    public int captureForts(int[] forts) {
        int start = -1, end = -1, res = 0;
        for (int i = 0; i < forts.length; i++) {
            if (forts[i] == 1) {
                if (end >= 0 && start < end) res = Math.max(res, i - end - 1);
                start = i;
            } else if (forts[i] == -1) {
                if (start >= 0 && end < start) res = Math.max(res, i - start - 1);
                end = i;
            }
        }
        return res;
    }
}
