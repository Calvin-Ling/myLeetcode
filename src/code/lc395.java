package code;

import java.util.HashSet;
import java.util.Set;

/*给你一个字符串 s 和一个整数 k ，请你找出 s 中的最长子串， 要求该子串中的每一字符出现次数都不少于 k 。返回这一子串的长度。*/
public class lc395 {
    public int longestSubstring(String s, int k) {
        if (s.length() < k) return 0;
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }
        Set<Character> set = new HashSet<>();
        boolean flag = true;
        for (int i = 0; i < 26; i++) {
            if (count[i] >= k) {
                set.add((char) (i+'a'));
            } else if (count[i] > 0){
                flag = false;
            }
        }
        if (flag) {
            return s.length();
        } else {
            int res = 0, start = 0;
            while (start < s.length()) {
                if (set.contains(s.charAt(start))) {
                    int end = start + 1;
                    while (end < s.length()) {
                        if (!set.contains(s.charAt(end))) break;
                        end++;
                    }
                    res = Math.max(longestSubstring(s.substring(start, end), k), res);
                    start = end;
                } else {
                    start++;
                }
            }
            return res;
        }
    }

}
