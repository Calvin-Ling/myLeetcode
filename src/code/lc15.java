package code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class lc15 {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        int i = 0;
        while (i < nums.length){
            int l = i + 1, r = nums.length - 1;
            if (nums[i] > 0) break;
            while (l < r) {
                int s = nums[i] + nums[l] + nums[r];
                if (s > 0) r--;
                else if (s < 0) l++;
                else {
                    List<Integer> list = new ArrayList<>(3);
                    Collections.addAll(list, nums[i], nums[l], nums[r]);
                    res.add(list);
                    l++;r--;
                    while (l < r && nums[l] == nums[l-1]) l++;
                    while (l < r && nums[r] == nums[r+1]) r--;
                }
            }
            i++;
            while (i < nums.length && nums[i] == nums[i-1]) i++;
        }
        return res;
    }
}
