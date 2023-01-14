package code;

/*给你两个下标从 0 开始的字符串 s 和 target 。你可以从 s 取出一些字符并将其重排，得到若干新的字符串。

        从 s 中取出字符并重新排列，返回可以形成 target 的 最大 副本数。



        来源：力扣（LeetCode）
        链接：https://leetcode.cn/problems/rearrange-characters-to-make-target-string
        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/
public class lc2287 {
    public int rearrangeCharacters(String s, String target) {
        int res = 0;
        while (true) {
            for (int i = 0; i < target.length(); i++) {
                if (s.indexOf(target.charAt(i)) > -1) {
                    String t = target.substring(i, i+1);
                    s = s.replaceFirst(t, "0");
                } else {
                    return res;
                }
            }
            res++;
        }
    }
}
