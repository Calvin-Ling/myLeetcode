package code;

import java.util.Arrays;

/**
 * 214.最短回文串
 * 给定一个字符串 s，你可以通过在字符串前面添加字符将其转换为回文串。找到并返回可以用这种方式转换的最短回文串。
 *
 * 示例 1:
 *
 * 输入: "aacecaaa"
 * 输出: "aaacecaaa"
 * 示例 2:
 *
 * 输入: "abcd"
 * 输出: "dcbabcd"
 *
 * 难度：困难
 * 分类：字符串、KMP
 * 思路一：暴力，会超时
 * 思路二：KMP求最长回文前缀
 * @author Calvin
 * @version 1.0
 * @date 2020/8/29 8:16
 */
public class lc214 {
    public String shortestPalindrome(String s) {
        return method1(s);
    }
    
    public String method1(String s){
        int n = s.length();
        int[] fail = new int[n];
        Arrays.fill(fail, -1);
        for (int i = 1; i < n; ++i) {
            int j = fail[i - 1];
            while (j != -1 && s.charAt(j + 1) != s.charAt(i)) {
                j = fail[j];
            }
            if (s.charAt(j + 1) == s.charAt(i)) {
                fail[i] = j + 1;
            }
        }
        int best = -1;
        for (int i = n - 1; i >= 0; --i) {
            while (best != -1 && s.charAt(best + 1) != s.charAt(i)) {
                best = fail[best];
            }
            if (s.charAt(best + 1) == s.charAt(i)) {
                ++best;
            }
        }
        String add = (best == n - 1 ? "" : s.substring(best + 1));
        StringBuffer ans = new StringBuffer(add).reverse();
        ans.append(s);
        return ans.toString();
    }
    
    public String method2(String s){//暴力超时
        int n = s.length();
        if (n == 0) return s;
        int i;
        for (i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder(s.substring(0,n-i));
            if (sb.toString().equals(sb.reverse().toString())) break;
        }
        i = n - i - 1;
        if (i == n-1) return s;
        StringBuilder sb = new StringBuilder(s.substring(i+1,n));
        return sb.reverse().append(s).toString();
    }
}
