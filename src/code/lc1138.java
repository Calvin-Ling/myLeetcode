package code;

import java.util.HashMap;

public class lc1138 {
    static char[][] map = new char[][] {
            {'a', 'b', 'c', 'd', 'e'},
            {'f', 'g', 'h', 'i', 'j'},
            {'k', 'l', 'm', 'n', 'o'},
            {'p', 'q', 'r', 's', 't'},
            {'u', 'v', 'w', 'x', 'y'},
            {'z', '0', '0', '0', '0'}
    };
    static HashMap<Character, int []> coordinate = new HashMap<>();
    static {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                coordinate.put(map[i][j], new int[] {i,j});
            }
        }
    }
    public String alphabetBoardPath(String target) {
        StringBuilder res = new StringBuilder();
        int[] now = new int[] {0,0};
        for (int k = 0; k < target.length(); k++) {
            char ch = target.charAt(k);
            int[] targetCdn = coordinate.get(ch);
            res.append(getMoveInstruction(now, targetCdn));
            res.append("!");
            now = targetCdn;
        }
        return res.toString();
    }

    private String getMoveInstruction(int[] now, int[] target) {
        StringBuilder res = new StringBuilder();
        int a = now[0], b = now[1], c = target[0], d = target[1];
        char x = b < d ? 'R' : 'L';
        char y = a < c ? 'D' : 'U';
        int detaX = Math.abs(b-d), detaY = Math.abs(a-c);
        while (detaX > 0 || detaY > 0) {
            boolean canXmove = detaX > 0;
            canXmove = canXmove && ((b < d && map[a][b+1] != '0') || (b >= d && map[a][b-1] != '0'));
            if (canXmove) {
                res.append(x);
                b += (b < d ? 1 : -1);
                detaX--;
            } else {
                res.append(y);
                a += (a < c ? 1 : -1);
                detaY--;
            }
        }
        return res.toString();
    }
}
