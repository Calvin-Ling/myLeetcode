package code;

public class lc57 {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int startIndex = -1, endIndex = intervals.length;
        boolean findS = false, findEnd = false, isStartPre = false, isEndPre = false;
        for (int i = 0; i < intervals.length; i++) {
            int[] curr = intervals[i];
            if (!findS && newInterval[0] <= curr[1]) {
                findS = true;
                startIndex = i;
                isStartPre = newInterval[0] < curr[0];
            }
            if (!findEnd && newInterval[1] <= curr[1]) {
                findEnd = true;
                endIndex = i;
                isEndPre = newInterval[1] < curr[0];
            }
        }
        if (!findS) {
            int len = intervals.length + 1;
            int[][] ints = new int[len][2];
            for (int i = 0; i < len; i++) {
                ints[i] = i < intervals.length ? intervals[i] : newInterval;
            }
            return ints;
        }
        if (!findEnd) {
            int len = startIndex + 1;
            int[] end = new int[2];
            end[1] = newInterval[1];
            end[0] = isStartPre ? newInterval[0] : intervals[startIndex][0];
            int[][] res = new int[len][2];
            for (int i = 0; i < len; i++) {
                res[i] = i < len - 1 ? intervals[i] : end;
            }
            return res;
        }
        int len = startIndex + 1 + intervals.length - 1 - endIndex + (isEndPre ? 1 : 0);
        int[][] res = new int[len][2];
        for (int i = 0, end = endIndex; i < len; i++) {
            if (i < startIndex) res[i] = intervals[i];
            else if (i == startIndex) {
                int[] c = new int[2];
                c[0] = isStartPre ? newInterval[0] : intervals[startIndex][0];
                c[1] = isEndPre ? newInterval[1] : intervals[endIndex][1];
                end = isEndPre ? endIndex : endIndex + 1;
                res[i] = c;
            } else {
                res[i] = intervals[end++];
            }
        }
        return res;
    }
}
