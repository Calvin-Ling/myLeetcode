package JZ;

/**
 * 15.二进制中1的个数
 * 解法：巧用n&(n-1)
 * n-1 : 二进制数字n最右边的1变成0，这个1的右边的0都变成1
 * n & n-1 ： 二进制数字n最右边的1变成0，其他的都不变。
 * @author Calvin
 * @version 1.0
 * @date 2020/8/30 14:09
 */
public class jz15 {
    public int hammingWeight(int n) {
        int res = 0;
        while(n != 0) {
            res++;
            n &= n - 1;
        }
        return res;
    }
}
