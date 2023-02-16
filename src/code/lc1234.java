package code;

import java.util.HashMap;

/*
https://leetcode.cn/problems/replace-the-substring-for-balanced-string/
 */
public class lc1234 {
    public int balancedString(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        int len = 0, n = s.length();
        HashMap<Character, Integer> need = new HashMap<>();
        for (Character character : map.keySet()) {
            int v = map.get(character);
            if (v > n/4) {
                need.put(character, v-n/4);
                len += (v-n/4);
            }
        }
        if (len == 0) return 0;
        int left = 0, right = len-1, res = Integer.MAX_VALUE;
        HashMap<Character, Integer> curr = new HashMap<>();
        for (int i = 0; i < len; i++) {
            curr.put(s.charAt(i), curr.getOrDefault(s.charAt(i), 0) + 1);
        }
        while (right >= 0 && right < n) {
            boolean bingo = true;
            for (Character character : need.keySet()) {
                if (need.get(character) > curr.getOrDefault(character, 0)) {
                    bingo = false;
                    break;
                }
            }
            if (bingo) res = Math.min(res, right-left+1);
            if (right + 1 >= n) break;
            char nextCh = s.charAt(right+1);
            curr.put(nextCh, curr.getOrDefault(nextCh, 0) + 1);
            right++;
            while (right - left >= len) {
                char tailCh = s.charAt(left);
                int nowCount = curr.get(tailCh);
                if (nowCount > need.getOrDefault(tailCh, 0)) {
                    left++;
                    curr.put(tailCh, nowCount - 1);
                } else {
                    break;
                }
            }
        }
        return res;
    }
}
