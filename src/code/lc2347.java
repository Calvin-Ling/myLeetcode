package code;

import java.util.HashMap;

public class lc2347 {
    public String bestHand(int[] ranks, char[] suits) {
        boolean isFlush = true;
        for (int i = 0; i < suits.length - 1; i++) {
            if (suits[i] != suits[i+1]) {
                isFlush = false;
                break;
            }
        }
        if (isFlush) return "Flush";
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int rank : ranks) {
            map.put(rank, map.getOrDefault(rank, 0) + 1);
        }
        boolean isPair = false;
        for (Integer value : map.values()) {
            if (value >= 3) {
                return "Three of a Kind";
            }
            if (value >= 2) {
                isPair = true;
            }
        }
        return isPair ? "Pair" : "High Card";
    }
}
