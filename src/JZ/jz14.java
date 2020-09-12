package JZ;

/**
 * 14.剪绳子
 * 给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），
 * 每段绳子的长度记为 k[0],k[1]...k[m-1] 。请问 k[0]*k[1]*...*k[m-1] 可能的最大乘积是多少？
 * 例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 *
 * 解法：“算术几何均值不等式”：(n1+n2+n3...na)/a >= (n1*n2*n3...na)^(1/a) 当且仅当n1=n2=...=na时成立。
 * 即：当 n1=n2=...=na=x时，取的最大值：x^a = x^(n/x)。
 * 即求 y = x^(1/x) 的极大值。两边取对数，对x求导，发现在[e,+无穷)单调递减，(-无穷,e）单调递增，所以在e处取得极大值，但x要为整数
 * 且2<e<3，带入3，取得的值更大，故最好是剪成长度为3的绳子，其次是为2，再是为1。
 * @author Calvin
 * @version 1.0
 * @date 2020/8/30 13:22
 */
public class jz14 {
    public int cuttingRope(int n){
//        if (n <= 3) return n-1;
//        int a = n/3,b = n%3;
//        if (b == 0) return (int)Math.pow(3,a);
//        if (b == 1) return (int)Math.pow(3,a-1)*4;
//        return (int)Math.pow(3,a)*2;
        if(n <= 3) return n-1;
        int a = n/3,b = n%3;
        long res = 1;
        if(b == 1) a--;
        while(a>0){
            res = (res*3)%1000000007;
            a--;
        }
        if(b == 0) return (int)res;
        if(b == 1) return (int)((res*4)%1000000007);
        return (int)((res*2)%1000000007);
    }
}
