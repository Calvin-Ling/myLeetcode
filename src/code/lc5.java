package code;

/**
 * 5.最长回文子串
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 * 示例1：
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * 示例2：
 * 输入: "cbbd"
 * 输出: "bb"
 *
 * 难度：中等
 * 分类：字符串
 * 思路一：利用StringBuffer的reverse()方法，判断是否为回文，暴力递归
 * 思路二：动态规划。
 */
public class lc5 {
    public String longestPalindrome(String s) {
        /**
         * 暴力递归法
         */

//        if (s.length() == 0){
//            return "";
//        }
//        StringBuffer solution = new StringBuffer();
//        solution.append(s);
//        if (s.equals(solution.reverse().toString()))
//            return solution.toString();
//        String s1 = longestPalindrome(s.substring(0,s.length()-1));
//        String s2 = longestPalindrome(s.substring(1));
//        return s1.length() > s2.length()? s1 : s2;

        /**
         * 动态规划法
         * 状态：dp[i][j]表示子串s[i...j]是否为回文子串
         * 状态转移方程：dp[i][j] = (s[i] == s[j]) and (j-i<3 or dp[i+1][j-1])
         */
        int len = s.length();
        if (len < 2){
            return s;
        }

        int maxLen = 1;
        int begin =0;
        boolean[][] dp = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }

        //由于dp[i][j]要参考dp[i+1][j-1],所以先升序填列，再升序填行
        for (int j = 1; j < len; j++) {
            for (int i = 0; i < j; i++) {
                dp[i][j] = (s.charAt(i) == s.charAt(j)) && (j-i<3 || dp[i+1][j-1]);
                String s1 = s.substring(i,j+1);
                if (dp[i][j] && j-i+1 > maxLen){
                    begin = i;
                    maxLen = j-i+1;
                }
            }
        }

        return s.substring(begin,begin+maxLen);
    }
}
