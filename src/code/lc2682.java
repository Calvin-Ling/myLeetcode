package code;

import java.util.ArrayList;
import java.util.Collections;

public class lc2682 {
    public int[] circularGameLosers(int n, int k) {
        int[] people = new int[n];
        int idx = 0;
        for (int i = 0;; i++) {
            idx = ((idx + k * i) % n);
            if (people[idx] > 0) break;
            people[idx]++;
        }
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < people.length; i++) {
            if (people[i] == 0) {
                res.add(i+1);
            }
        }
        int[] ans = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            ans[i] = res.get(i);
        }
        return ans;
    }
}
