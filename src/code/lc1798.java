package code;

import java.util.Arrays;

public class lc1798 {
    public int getMaximumConsecutive(int[] coins) {
        Arrays.sort(coins);
        int tail = 0;
        for (int coin : coins) {
            if (coin > tail + 1) return tail + 1;
            tail += coin;
        }
        return tail + 1;
    }
}
