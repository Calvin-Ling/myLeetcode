package code;

/**
 * 60.第k个排列
 * 按大小顺序列出所有排列情况，并一一标记，当 n = 3 时, 所有排列如下：
 *
 * "123"
 * "132"
 * "213"
 * "231"
 * "312"
 * "321"
 * 给定 n 和 k，返回第 k 个排列。
 *
 * 说明：
 *
 * 给定 n 的范围是 [1, 9]。
 * 给定 k 的范围是[1,  n!]。
 * 示例 1:
 *
 * 输入: n = 3, k = 3
 * 输出: "213"
 * 示例 2:
 *
 * 输入: n = 4, k = 9
 * 输出: "2314"
 *
 *
 * @author Calvin
 * @version 1.0
 * @date 2020/9/5 10:51
 */
public class lc60 {
    boolean[] isSelect = new boolean[10];
    StringBuilder sb = new StringBuilder();
    public String getPermutation(int n, int k) {
        while (n > 1){
            int i,j,fac = factorial(n-1);
            for (i = 1; i <= n; i++) {
                if (k <= i*fac) break;
            }
            k -= (i-1)*fac;
            for (j = 1; j < 10; j++) {
                if (!isSelect[j]) {
                    i--;
                    if (i == 0) break;
                }
            }
            sb.append(j+"");
            isSelect[j] = true;
            n--;
        }
        for (int i = 1; i < 10; i++) {
            if (!isSelect[i]){
                sb.append(i+"");break;
            }
        }
        return sb.length() == 0 ? "1" : sb.toString();
    }

    public int factorial(int n){
        int res = 1;
        for (int i = n; i >= 1; i--) {
            res *= i;
        }
        return res;
    }
}
