package code;

import java.util.*;

public class lc78 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        res.add(new LinkedList<>());
        for (int i = 0; i < nums.length; i++) {
            int s = res.size();
            for (int j = 0; j < s; j++) {
                List<Integer> t = new ArrayList<>(res.get(j));
                t.add(nums[i]);
                res.add(t);
            }
        }
        return res;
    }
}
