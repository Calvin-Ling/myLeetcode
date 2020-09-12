package code;

/**
 * 201.给定范围 [m, n]，其中 0 <= m <= n <= 2147483647，返回此范围内所有数字的按位与（包含 m, n 两端点）。
 * 分类：二进制，数学
 * 难度：中等
 * 思路：问题的本质是求解m和n的最长公共前缀，
 * m：S S S 0 X X X X
 * n：S S S 1 X X X X
 * S代表相等，X表示未知
 * 结果应为：
 *  S S S 0 0 0 0 0
 * @author Calvin
 * @version 1.0
 * @date 2020/8/23 21:49
 */
public class lc201 {
    public int rangeBitwiseAnd(int m, int n) {
        if(m==n)
            return m;
        int res=m^n;//首先进行异或操作
        int count=0;
        //从最高位开始，统计0的个数，即S的个数
        for (int i=31;i>=0;--i){
            if (res>>i==1)
                break;
            else
                count++;
        }
        count=31-count;
        return (m>>count)<<count;
    }
}
