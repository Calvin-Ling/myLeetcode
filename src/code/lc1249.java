package code;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class lc1249 {
    public String minRemoveToMakeValid(String s) {
        Stack<Integer> stack = new Stack<>();
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                stack.add(i);
            } else if (ch == ')') {
                if (stack.isEmpty()) set.add(i);
                else stack.pop();
            }
        }
        set.addAll(stack);
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            res.append(set.contains(i) ? "" : s.charAt(i));
        }
        return res.toString();
    }
}
