package code;

/*一个句子是由一些单词与它们之间的单个空格组成，且句子的开头和结尾没有多余空格。比方说，"Hello World" ，"HELLO" ，"hello world hello world" 都是句子。每个单词都 只 包含大写和小写英文字母。

        如果两个句子 sentence1 和 sentence2 ，可以通过往其中一个句子插入一个任意的句子（可以是空句子）而得到另一个句子，那么我们称这两个句子是 相似的 。比方说，sentence1 = "Hello my name is Jane" 且 sentence2 = "Hello Jane" ，我们可以往 sentence2 中 "Hello" 和 "Jane" 之间插入 "my name is" 得到 sentence1 。

        给你两个句子 sentence1 和 sentence2 ，如果 sentence1 和 sentence2 是相似的，请你返回 true ，否则返回 false 。

        来源：力扣（LeetCode）
        链接：https://leetcode.cn/problems/sentence-similarity-iii
        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/
public class lc1813 {
    public boolean areSentencesSimilar(String sentence1, String sentence2) {
        if (sentence1.equals(sentence2)) return true;
        if (sentence1.length() == sentence2.length()) return false;
        String[] wordsForSortSen = sentence1.split(" ");
        String[] wordsForLongSen = sentence2.split(" ");
        String sortSen = sentence1;
        String longSen = sentence2;
        if (wordsForSortSen.length > wordsForLongSen.length) {
            String [] tmp = wordsForLongSen;
            wordsForLongSen = wordsForSortSen;
            wordsForSortSen = tmp;
            sortSen = sentence2;
            longSen = sentence1;
        }
        int index = 0;
        for (int i = 0; i < wordsForSortSen.length; i++) {
            index += (i == 0 ? 0 : 1);
            if (wordsForSortSen[i].equals(wordsForLongSen[i])) {
                index+=wordsForSortSen[i].length();
            } else {
                int longIndex = longSen.length() - sortSen.length() + index - 1;
                if (longIndex < 0 || longIndex > longSen.length()) return false;
                String baseStr = " " + sortSen.substring(index);
                return baseStr.equals(longSen.substring(longIndex));
            }
        }
        return true;
    }
}
