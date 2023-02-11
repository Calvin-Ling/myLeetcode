package code;

import java.util.Arrays;

/*
https://leetcode.cn/problems/minimum-amount-of-time-to-fill-cups/
 */
public class lc2335 {
    public int fillCups(int[] amount) {
        Arrays.sort(amount);
        if (amount[2] > amount[1] + amount[0]) {
            return amount[2];
        }
        return (amount[0] + amount[1] + amount[2] + 1) / 2;
    }
}
