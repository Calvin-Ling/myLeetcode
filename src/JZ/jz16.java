package JZ;

/**
 * 16.数值的整数次方
 * 实现函数double Power(double base, int exponent)，求base的exponent次方。不得使用库函数，同时不需要考虑大数问题。
 * 示例 1:
 *
 * 输入: 2.00000, 10
 * 输出: 1024.00000
 * 示例 2:
 *
 * 输入: 2.10000, 3
 * 输出: 9.26100
 * 示例 3:
 *
 * 输入: 2.00000, -2
 * 输出: 0.25000
 * 解释: 2-2 = 1/22 = 1/4 = 0.25
 * 说明:
 * -100.0 < x < 100.0
 * n 是 32 位有符号整数，其数值范围是 [−231, 231 − 1] 。
 *
 * 解法：快速幂解法：https://leetcode-cn.com/problems/shu-zhi-de-zheng-shu-ci-fang-lcof/solution/mian-shi-ti-16-shu-zhi-de-zheng-shu-ci-fang-kuai-s/
 * @author Calvin
 * @version 1.0
 * @date 2020/8/30 14:24
 */
public class jz16 {
    public double myPow(double x, int n) {
        if(n == 0) return 1;
        double res = 1.0;
        long b = n;//后面会进行n = -n的操作，可能会超出int范围,-2147483648
        if(n < 0){
            x = 1/x;b=-b;
        }
        while(b > 0){
            if ((b&1) == 1) res *= x;
            x *= x;
            b = b >> 1;
        }
        return res;
    }
}
