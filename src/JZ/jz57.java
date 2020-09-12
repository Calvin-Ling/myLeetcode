package JZ;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 57.
 * 输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。
 *
 * 序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：target = 9
 * 输出：[[2,3,4],[4,5]]
 * 示例 2：
 *
 * 输入：target = 15
 * 输出：[[1,2,3,4,5],[4,5,6],[7,8]]
 *  
 *
 * 限制：
 *
 * 1 <= target <= 10^5
 *
 * 解法：对于目标target，若其为连续m个整数之和，则存在起始数x，有：
 *
 * x + (x + 1) + ... + (x + m - 1) == target => m * x + m * (m - 1) / 2 == target
 *
 * 根据这个等式，遍历m，找到符合的x即可获得相关序列
 * @author Calvin
 * @version 1.0
 * @date 2020/9/6 16:29
 */
public class jz57 {
    public int[][] findContinuousSequence(int target) {

        List<int[]> result = new ArrayList<>();
        int m = 1;

        while(target>0)
        {
            target -= m++;
            if(target>0 && target%m == 0)
            {
                int[] array = new int[m];
                for(int k = target/m, j = 0; k < target/m+m; k++,j++)
                {
                    array[j] = k;
                }
                result.add(array);
            }
        }
        Collections.reverse(result);
        return result.toArray(new int[0][]);
    }
}
