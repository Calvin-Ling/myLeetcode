package code;

/**
 * 647.回文子串
 * 给定一个字符串，你的任务是计算这个字符串中有多少个回文子串。
 * 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串。
 * 示例 1：
 *
 * 输入："abc"
 * 输出：3
 * 解释：三个回文子串: "a", "b", "c"
 * 示例 2：
 *
 * 输入："aaa"
 * 输出：6
 * 解释：6个回文子串: "a", "a", "a", "aa", "aa", "aaa"
 *
 * 难度：中等
 * 分类：子串
 * 思路1：动规：dp[i][j] = (j-i<3||dp[i+1][j-1])&&s[i] == s[j]，时间复杂度O(n^2),空间复杂度O(n^2)
 * 思路2：中心拓展，枚举每一个可能的回文中心，然后用两个指针分别向左右两边拓展，
 *       当两个指针指向的元素相同的时候就拓展，否则停止拓展。如下代码细节处理回文长度为奇数和偶数的情况。时间O(n^2)，空间O(1)
 * 思路3：Manacher 算法 时间O(n),空间O(n)
 * @author Calvin
 * @version 1.0
 * @date 2020/8/19 10:46
 */
public class lc647 {
    public int countSubstrings(String s) {
        if (s == null || s.length() == 0) return 0;
        int res = 0,n = s.length();
        boolean[][] dp = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }
        for (int i = n-1; i >= 0; i--) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = (j-i < 3 || dp[i+1][j-1])&&s.charAt(i) == s.charAt(j);
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                res += dp[i][j] ? 1 : 0;
            }
        }
        return res;
    }

//    public int countSubstrings(String s) {
//        int n = s.length(), ans = 0;
//        for (int i = 0; i < 2 * n - 1; ++i) {
//            int l = i / 2, r = i / 2 + i % 2;
//            while (l >= 0 && r < n && s.charAt(l) == s.charAt(r)) {
//                --l;
//                ++r;
//                ++ans;
//            }
//        }
//        return ans;
//    }

//    public int countSubstrings(String s) {
//        int n = s.length();
//        StringBuffer t = new StringBuffer("$#");
//        for (int i = 0; i < n; ++i) {
//            t.append(s.charAt(i));
//            t.append('#');
//        }
//        n = t.length();
//        t.append('!');
//
//        int[] f = new int[n];
//        int iMax = 0, rMax = 0, ans = 0;
//        for (int i = 1; i < n; ++i) {
//            // 初始化 f[i]
//            f[i] = i <= rMax ? Math.min(rMax - i + 1, f[2 * iMax - i]) : 1;
//            // 中心拓展
//            while (t.charAt(i + f[i]) == t.charAt(i - f[i])) {
//                ++f[i];
//            }
//            // 动态维护 iMax 和 rMax
//            if (i + f[i] - 1 > rMax) {
//                iMax = i;
//                rMax = i + f[i] - 1;
//            }
//            // 统计答案, 当前贡献为 (f[i] - 1) / 2 上取整
//            ans += f[i] / 2;
//        }
//
//        return ans;
//    }
}
