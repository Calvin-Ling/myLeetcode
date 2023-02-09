package code;

import java.util.*;

/*
https://leetcode.cn/problems/alert-using-same-key-card-three-or-more-times-in-a-one-hour-period/
 */
public class lc1604 {
    public List<String> alertNames(String[] keyName, String[] keyTime) {
        HashSet<String> res = new HashSet<>();
        HashMap<String, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < keyName.length; i++) {
            String name = keyName[i], timeStr = keyTime[i];
            if (res.contains(name)) continue;
            int time = Integer.parseInt(timeStr.substring(0, timeStr.indexOf(":"))) * 60
                    + Integer.parseInt(timeStr.substring(timeStr.indexOf(":")+1));
            List<Integer> list = map.getOrDefault(name, new LinkedList<>());
            int insertPos;
            for (insertPos = 0; insertPos < list.size() && list.get(insertPos) < time; insertPos++);
            list.add(insertPos, time);
            boolean bingo = (insertPos - 2) >= 0 && (time - list.get(insertPos - 2)) <= 60;
            bingo = bingo
                    || ((insertPos - 1) >= 0 && (insertPos + 1) < list.size()
                        && (list.get(insertPos + 1) - list.get(insertPos - 1)) <= 60)
                    || ((insertPos + 2) < list.size()
                    && (list.get(insertPos + 2) - time) <= 60);
            if (bingo) res.add(name);
            map.put(name, list);
        }
        List<String> list = new ArrayList<>(res);
        Collections.sort(list);
        return list;
    }
}
