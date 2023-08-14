package code;

public class lc833 {
    public String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
        sorted(indices, sources, targets);
        StringBuilder res = new StringBuilder();
        int idx = 0;
        for (int i = 0; i < indices.length; i++) {
            int strStart = indices[i];
            if (strStart > idx) {
                res.append(s, idx, strStart);
                idx = strStart;
            }
            int len = sources[i].length();
            int strEnd = Math.min((strStart + len), s.length());
            boolean exist = sources[i].equals(s.substring(strStart, strEnd));
            if (exist) {
                res.append(targets[i]);
                idx = strStart + len;
            }
        }
        if (s.length() > idx) {
            res.append(s, idx, s.length());
        }
        return res.toString();
    }

    private void sorted(int[] indices, String[] sources, String[] targets) {
        for (int i = 0; i < indices.length; i++) {
            for (int j = i + 1; j < indices.length; j++) {
                if (indices[i] > indices[j]) {
                    int tmp = indices[j];
                    indices[j] = indices[i];
                    indices[i] = tmp;

                    String s = sources[j];
                    sources[j] = sources[i];
                    sources[i] = s;

                    String t = targets[j];
                    targets[j] = targets[i];
                    targets[i] = t;
                }
            }
        }
    }
}
