package code;

import java.util.HashMap;

public class lc409 {
    public int longestPalindrome(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        int res = 0;
        for (char c : map.keySet()) {
            if (map.get(c) % 2 == 0) res+=map.get(c);
            else if (res % 2 == 0){
                res+=map.get(c);
            } else {
                res+=(map.get(c) - 1);
            }
        }
        return res;
    }
}
