package code;

/**
 * 130.给定一个二维的矩阵，包含 'X' 和 'O'（字母 O）。
 * 找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。
 * 示例:
 * X X X X
 * X O O X
 * X X O X
 * X O X X
 * 运行你的函数后，矩阵变为：
 * X X X X
 * X X X X
 * X X X X
 * X O X X
 * 解释:
 * 被围绕的区间不会存在于边界上，换句话说，任何边界上的 'O' 都不会被填充为 'X'。
 * 任何不在边界上，或不与边界上的 'O' 相连的 'O' 最终都会被填充为 'X'。
 * 如果两个元素在水平或垂直方向相邻，则称它们是“相连”的。
 * 难度：中等
 * 分类：矩阵
 * 思路：边界的'O'开始dfs，标记，最后把没有标记的'O'换为'X'。
 * @author Calvin
 * @version 1.0
 * @date 2020/8/11 13:13
 */
public class lc130 {
    public void solve(char[][] board){
        int n = board.length;
        if (n == 0) return;
        int m = board[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 'O') board[i][j] = 'Z';
            }
        }
        for (int i = 0; i < n; i++) {
            dfs(board,i,0);
            dfs(board,i,m-1);
        }
        for (int i = 0; i < m; i++) {
            dfs(board,0,i);
            dfs(board,n-1,i);
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 'Z') board[i][j] = 'X';
            }
        }
    }

    public void dfs(char[][] board,int x,int y){
        if (x < 0 || y < 0|| x >= board.length || y >= board[0].length || board[x][y] != 'Z') return;
        board[x][y] = 'O';
        dfs(board,x-1,y);
        dfs(board,x+1,y);
        dfs(board,x,y-1);
        dfs(board,x,y+1);
    }
}
