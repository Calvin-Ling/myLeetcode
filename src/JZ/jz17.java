package JZ;

import java.util.LinkedList;
import java.util.List;

/**
 * 17.打印从1到最大的n位数
 * 考虑大数
 * 使用全排列
 * @author Calvin
 * @version 1.0
 * @date 2020/8/30 15:16
 */
public class jz17 {
    List<String> res;
    StringBuilder sb;
    boolean flag = true;
    char[] num = {'0','1','2','3','4','5','6','7','8','9'};
    public List<String> printNumbers(int n) {
        res = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            sb = new StringBuilder();
            flag = true;
            func(i,0);
        }
        return res;
    }

    public void func(int x,int index){
        if (index == x) {
            res.add(sb.toString());return;
        }
        if (flag){
            for (int i = 1; i <= 9; i++) {
                sb.append(num[i]);
                flag = false;
                func(x,index+1);
                sb.deleteCharAt(sb.length()-1);
            }
        }else {
            for (int i = 0; i <= 9; i++) {
                sb.append(num[i]);
                func(x,index+1);
                sb.deleteCharAt(sb.length()-1);
            }
        }
    }
}
