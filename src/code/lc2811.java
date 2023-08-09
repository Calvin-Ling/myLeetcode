package code;

import java.util.List;

public class lc2811 {
    public boolean canSplitArray(List<Integer> nums, int m) {
        if (nums.size() < 3) return true;
        int len = nums.size();
        for (int i = 0; i < len - 1; i++) {
            if (nums.get(i) + nums.get(i + 1) >= m) return true;
        }
        return false;
    }
}
