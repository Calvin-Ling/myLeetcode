package code;

public class lc330 {
    public int minPatches(int[] nums, int n) {
        long tail = 0;
        int res = 0;
        for (int num : nums) {
            while (num > tail + 1) {
                tail += tail + 1;
                res++;
                if (tail >= n) {
                    return res;
                }
            }
            tail += num;
            if (tail >= n) {
                return res;
            }
        }
        while (tail < n && tail > 0) {
            tail += tail + 1;
            res++;
        }
        return res;
    }

}
