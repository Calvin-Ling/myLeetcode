package code;

public class lc1828 {
    public int[] countPoints(int[][] points, int[][] queries) {
        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int cirX = queries[i][0], cirY = queries[i][1], cirR = queries[i][2];
            for (int[] point : points) {
                int x = point[0], y = point[1];
                if (((x-cirX)*(x-cirX) + (y-cirY)*(y-cirY)) <= (cirR*cirR)) {
                    res[i]++;
                }
            }
        }
        return res;
    }
}
