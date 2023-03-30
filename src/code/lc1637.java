package code;

import java.util.ArrayList;
import java.util.Collections;

/*
https://leetcode.cn/problems/widest-vertical-area-between-two-points-containing-no-points/
 */
public class lc1637 {
    public int maxWidthOfVerticalArea(int[][] points) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int[] p:
             points) {
            list.add(p[0]);
        }
        Collections.sort(list);
        int res = 0, last = -1;
        for (Integer integer : list) {
            if (last >= 0) {
                res = Math.max(Math.abs(integer - last), res);
            }
            last = integer;
        }
        return res;
    }
}
