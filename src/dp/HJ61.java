package dp;

/**
 * 放苹果
 * 题目描述
 * 把M个同样的苹果放在N个同样的盘子里，允许有的盘子空着不放，问共有多少种不同的分法？（用K表示）5，1，1和1，5，1 是同一种分法。
 * 输入
 * 每个用例包含二个整数M和N。0<=m<=10，1<=n<=10。
 * 样例输入
 * 7 3
 * 样例输出
 * 8
 *
 * * 计算放苹果方法数目
 * * 输入值非法时返回-1
 * * 1 <= m,n <= 10
 * * @param m 苹果数目
 * * @param n 盘子数目数
 * * @return 放置方法总
 * @author Calvin
 * @version 1.0
 * @date 2020/8/7 18:20
 */
public class HJ61 {
    public int count(int m, int n){
        if (m<0||m>10||n<1||n>10) return -1;
        int[][] dp = new int[m+1][n+1];
        for (int i = 0; i <= n; i++) {
            dp[0][i] = 1;
        }
        for (int i = 0; i <= m; i++) {
            dp[i][1] = 1;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 2; j <= n; j++) {
                dp[i][j] = dp[i][j-1] + (i < j?0:dp[i-j][j]);
            }
        }
        return dp[m][n];
    }
}
