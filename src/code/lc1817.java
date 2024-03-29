package code;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*给你用户在 LeetCode 的操作日志，和一个整数 k 。日志用一个二维整数数组 logs 表示，其中每个 logs[i] = [IDi, timei] 表示 ID 为 IDi 的用户在 timei 分钟时执行了某个操作。

        多个用户 可以同时执行操作，单个用户可以在同一分钟内执行 多个操作 。

        指定用户的 用户活跃分钟数（user active minutes，UAM） 定义为用户对 LeetCode 执行操作的 唯一分钟数 。 即使一分钟内执行多个操作，也只能按一分钟计数。

        请你统计用户活跃分钟数的分布情况，统计结果是一个长度为 k 且 下标从 1 开始计数 的数组 answer ，对于每个 j（1 <= j <= k），answer[j] 表示 用户活跃分钟数 等于 j 的用户数。

        返回上面描述的答案数组 answer 。

        来源：力扣（LeetCode）
        链接：https://leetcode.cn/problems/finding-the-users-active-minutes
        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/
public class lc1817 {
    public int[] findingUsersActiveMinutes(int[][] logs, int k) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        int[] res = new int[k];
        for (int[] log : logs) {
            int id = log[0], minutes = log[1];
            Set<Integer> set = map.getOrDefault(id, new HashSet<>());
            if (!set.contains(minutes)) {
                int count = set.size();
                if (count > 0 && res[count-1] > 0) res[count-1]--;
                res[count]++;
                set.add(minutes);
                map.put(id, set);
            }
        }
        return res;
    }
}
