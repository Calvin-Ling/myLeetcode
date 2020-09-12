package code;

import java.util.LinkedList;
import java.util.List;

/**
 * 51.N 皇后
 * @author Calvin
 * @version 1.0
 * @date 2020/9/3 8:50
 */
public class lc51 {
    int[] y;
    boolean[] flag;//标记是否被占用了
    List<List<String>> res;
    public List<List<String>> solveNQueens(int n) {
        res = new LinkedList<>();
        if (n == 0) return res;
        y = new int[n];
        flag = new boolean[n];
        for (int i = 0; i < n; i++) {
            y[i] = -1;
        }
        func(0);
        return res;
    }

    public void func(int step){
        if (step == y.length){
            List<String> list = new LinkedList<>();
            for (int i = 0; i < y.length; i++) {
                String str = "";
                for (int j = 0; j < y.length; j++) {
                    str += y[i] == j ? "Q" : ".";
                }
                list.add(str);
            }
            res.add(list);
        }
        for (int i = 0; i < flag.length; i++) {
            if (!flag[i]){
                int j;
                for (j = 0; j < step; j++) {
                    if (j+y[j] == step + i || j - y[j] == step - i) break;
                }
                if (j == step){
                    y[step] = i;
                    flag[i] = true;
                    func(step+1);
                    flag[i] = false;
                }
            }
        }
    }
}
