package JZ;

/**
 * 65位运算实现两个数的加法
 * @author Calvin
 * @version 1.0
 * @date 2020/9/9 14:17
 */
public class jz65 {
    public int add(int a, int b) {
        while(b != 0) { // 当进位为 0 时跳出
            int c = (a & b) << 1;  // c = 进位
            a ^= b; // a = 非进位和
            b = c; // b = 进位
        }
        return a;
    }
}
