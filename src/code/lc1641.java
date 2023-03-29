package code;

import java.util.Arrays;

/*
https://leetcode.cn/problems/count-sorted-vowel-strings/
 */
public class lc1641 {
    public int countVowelStrings(int n) {
        int[][] arr = new int[n][5];
        arr[0] = new int[] { 1, 1, 1, 1, 1};
        for (int i = 1; i < n; i++) {
            int lastSum = 0;
            for (int j = 0; j < 5; j++) {
                if (j > 0) lastSum = arr[i][j-1];
                arr[i][j] = arr[i-1][j] + lastSum;
            }
        }
        int res = 0;
        for (int i:arr[n-1]) {
            res += i;
        }
        return res;
    }
}
