package code;

import org.junit.Test;

/*
https://leetcode.cn/problems/minimum-swaps-to-make-strings-equal/
 */
public class lc1247 {
    public int minimumSwap(String s1, String s2) {
        char[] chars1 = s1.toCharArray();
        char[] chars2 = s2.toCharArray();
        int res = 0;
        for (int i = 0; i < chars1.length; i++) {
            if (chars1[i] == chars2[i]) continue;
            if (i == chars1.length - 1 && chars1[i] != chars2[i]) return -1;
            // find chars1[i] from s1 which index behind i
            boolean found1 = false;
            boolean found2 = false;
            int index = i + 1, index1 = chars1.length, index2 = chars1.length;
            while (index < chars1.length) {
                if (chars1[index] == chars1[i]) {
                    found1 = chars1[index] != chars2[index];
                    index1 = index;
                }
                if (chars2[index] == chars2[i]) {
                    found2 = chars1[index] != chars2[index];
                    index2 = index;
                }
                if (found1 || found2) break;
                index++;
            }
            if (found1) {
                char tmp = chars2[i];
                chars2[i] = chars1[index];
                chars1[index] = tmp;
                res++;
            } else if (found2) {
                char tmp = chars1[i];
                chars1[i] = chars2[index];
                chars2[index] = tmp;
                res++;
            } else {
                if (index1 < chars1.length) {
                    char tmp = chars2[i];
                    chars2[i] = chars1[index1];
                    chars1[index1] = tmp;
                    res++;
                } else if (index2 < chars2.length) {
                    char tmp = chars1[i];
                    chars1[i] = chars2[index2];
                    chars2[index2] = tmp;
                    res++;
                } else {
                    char tmp = chars1[i];
                    chars1[i] = chars2[i];
                    chars2[i] = tmp;
                    res++;
                    i--;
                }
            }
        }
        return res;
    }

}
