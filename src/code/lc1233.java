package code;

import java.util.*;
import java.util.stream.Collectors;

/*
https://leetcode.cn/problems/remove-sub-folders-from-the-filesystem/
 */
public class lc1233 {
    public List<String> removeSubfolders(String[] folder) {
        Set<String> set = Arrays.stream(folder).collect(Collectors.toSet());
        List<String> res = new LinkedList<>();
        for (String s : folder) {
            int start = 0;
            while (start >= 0) {
                int end = s.indexOf("/", start + 1);
                if (end == -1) {
                    res.add(s);
                    break;
                }
                String prefix = s.substring(0, end);
                if (set.contains(prefix)) {
                    break;
                }
                start = end;
            }
        }
        return res;
    }

}
