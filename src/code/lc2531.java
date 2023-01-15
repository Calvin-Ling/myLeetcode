package code;

import java.util.Arrays;

/*给你两个下标从 0 开始的字符串 word1 和 word2 。

        一次 移动 由以下两个步骤组成：

        选中两个下标 i 和 j ，分别满足 0 <= i < word1.length 和 0 <= j < word2.length ，
        交换 word1[i] 和 word2[j] 。
        如果可以通过 恰好一次 移动，使 word1 和 word2 中不同字符的数目相等，则返回 true ；否则，返回 false 。



        来源：力扣（LeetCode）
        链接：https://leetcode.cn/problems/make-number-of-distinct-characters-equal
        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/
public class lc2531 {
    public boolean isItPossible(String word1, String word2) {
        int[] count1 = new int[26];
        int[] count2 = new int[26];
        for (int i = 0; i < word1.length(); i++) {
            count1[word1.charAt(i) - 'a']++;
        }
        for (int i = 0; i < word2.length(); i++) {
            count2[word2.charAt(i) - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < 26; j++) {
                if (count1[i] > 0 && count2[j] > 0) {
                    count1[i]--;
                    count1[j]++;
                    count2[i]++;
                    count2[j]--;
                    if (getCount(count1) == getCount(count2)) {
                        return true;
                    }
                    count1[i]++;
                    count1[j]--;
                    count2[i]--;
                    count2[j]++;
                }
            }
        }
        return false;
    }

    private int getCount(int[] nums) {
        int res = 0;
        for (int num : nums) {
            res += (num > 0 ? 1 : 0);
        }
        return res;
    }
}
