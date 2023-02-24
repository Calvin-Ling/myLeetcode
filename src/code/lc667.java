package code;

public class lc667 {
    public int[] constructArray(int n, int k) {
        int[] res = new int[n];
        res[0] = 1;
        boolean isPlus = true;
        for (int i = 1; i < n; i++) {
            int gap = k - (i - 1);
            if (gap <= 0) {
                res[i] = k - gap + 2;
                continue;
            }
            if (isPlus) {
                res[i] = res[i-1] + gap;
                isPlus = false;
            } else {
                res[i] = res[i-1] - gap;
                isPlus = true;
            }
        }
        return res;
    }
}
