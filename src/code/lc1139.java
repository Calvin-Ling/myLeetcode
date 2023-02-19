package code;

/*
https://leetcode.cn/problems/largest-1-bordered-square/
 */
public class lc1139 {
    public int largest1BorderedSquare(int[][] grid) {
        if (grid.length == 1 && grid[0].length == 1) return grid[0][0];
        int res = 0, i = 0, j = 0;
        while (i < grid.length) {
            while (j < grid[0].length) {
                int a = getLongest1Border(grid, new int[] { i, j });
                if (a > res) {
                    res = a;
                    j++;
                } else {
                    j++;
                }
            }
            i++;
        }
        return res * res;
    }

    public int getLongest1Border(int[][] grid, int[] start) {
        int res = 0;
        for (int i = 0; i < Math.min(grid.length - start[0], grid[1].length - start[1]); i++) {
            if (grid[start[0] + i][start[1]] == 1 && grid[start[0]][start[1] + i] == 1) {
                boolean bingo = true;
                for (int j = 0; j < i+1; j++) {
                    if (grid[start[0] + i][start[1] + j] == 0
                            || grid[start[0] + j][start[1] + i] == 0) {
                        bingo = false;
                        break;
                    }
                }
                res = bingo ? (i+1) : res;
            } else
            return res;
        }
        return res;
    }
}
