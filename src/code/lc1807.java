package code;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/*给你一个字符串 s ，它包含一些括号对，每个括号中包含一个 非空 的键。

        比方说，字符串 "(name)is(age)yearsold" 中，有 两个 括号对，分别包含键 "name" 和 "age" 。
        你知道许多键对应的值，这些关系由二维字符串数组 knowledge 表示，其中 knowledge[i] = [keyi, valuei] ，表示键 keyi 对应的值为 valuei 。

        你需要替换 所有 的括号对。当你替换一个括号对，且它包含的键为 keyi 时，你需要：

        将 keyi 和括号用对应的值 valuei 替换。
        如果从 knowledge 中无法得知某个键对应的值，你需要将 keyi 和括号用问号 "?" 替换（不需要引号）。
        knowledge 中每个键最多只会出现一次。s 中不会有嵌套的括号。

        请你返回替换 所有 括号对后的结果字符串。



        来源：力扣（LeetCode）
        链接：https://leetcode.cn/problems/evaluate-the-bracket-pairs-of-a-string
        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/
public class lc1807 {
    public String evaluate(String s, List<List<String>> knowledge) {
        HashMap<String, String> map = new HashMap<>();
        for (List<String> stringList : knowledge) {
            String key = stringList.get(0), value = stringList.get(1);
            map.put(key, value);
        }
        StringBuilder sb = new StringBuilder();
        int start = 0;
        while (start < s.length()){
            if (s.charAt(start) == '(') {
                int end = s.indexOf(")", start);
                String key = s.substring(start + 1, end);
                sb.append(map.get(key) == null ? "?" : map.get(key));
                start = end + 1;
            } else {
                sb.append(s.charAt(start));
                start++;
            }
        }
        return sb.toString();
    }
}
