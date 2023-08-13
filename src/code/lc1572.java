package code;

public class lc1572 {
    public int diagonalSum(int[][] mat) {
        int res = 0;
        for (int i = 0; i < mat.length; i++) {
            res += mat[i][i];
            if (mat.length - 1 - i != i) res += mat[i][mat.length - 1 - i];
        }
        return res;
    }
}
