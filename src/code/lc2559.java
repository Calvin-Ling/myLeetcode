package code;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/*
https://leetcode.cn/problems/count-vowel-strings-in-ranges/
 */
public class lc2559 {
    public int[] vowelStrings(String[] words, int[][] queries) {
        int[] dp = new int[words.length];
        Set<Character> set = new HashSet<>();
        Collections.addAll(set, 'a', 'e', 'i', 'o', 'u');
        int i =0;
        for (String word : words) {
            dp[i] = (i == 0 ? 0 : dp[i-1]) + (set.contains(word.charAt(0)) && set.contains(word.charAt(word.length()-1)) ? 1:0);
            i++;
        }
        i = 0;
        int[] res = new int[queries.length];
        for (int[] query : queries) {
            int start = query[0], end = query[1];
            res[i] = dp[end] - (start == 0 ? 0 : dp[start-1]);
            i++;
        }
        return res;
    }
}
