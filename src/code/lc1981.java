package code;

import java.util.HashSet;
import java.util.Set;

public class lc1981 {
    public int minimizeTheDifference(int[][] mat, int target) {
        Set<Integer> set = new HashSet<>();
        for (int n :mat[0]) {
            set.add(n);
        }
        for (int i = 0; i < mat.length; i++) {
            if (i == 0) continue;
            int[] arr = mat[i];
            Set<Integer> ss = new HashSet<>();
            int min = Integer.MAX_VALUE;
            for (int n :arr) {
                for (int s :set) {
                    if (s + n < target) ss.add(s + n);
                    else min = Math.min(min, s+n);
                }
            }
            if (min < Integer.MAX_VALUE) ss.add(min);
            set = ss;
        }
        int res = Integer.MAX_VALUE;
        for (int n : set) {
            res = Math.min(res, Math.abs(n - target));
        }
        return res;
    }
}
