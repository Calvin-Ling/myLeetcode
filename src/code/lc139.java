package code;

import java.util.*;

/**
 * 139.单词拆分
 * 题意：给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，
 *      判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。
 *      拆分时可以重复使用字典中的单词。
 *      你可以假设字典中没有重复的单词。
 * 难度：中等
 * 分类：链表，动态规划，递归
 * 思路：暴力递归
 * 方法一：递归回溯,容易超时，重复一定数量的子问题。
 * 方法二：记忆化回溯,使用memo数组来保存子问题的结果。每当访问到已经访问过的后缀串，直接用memo数组中的值返回而不是调用函数
 * 方法三：宽度优先搜索
 * 方法四：动态规划，
 */
public class lc139 {
    public boolean wordBreak1(String s, List<String> wordDict) {
        return wordBreak2(s,new HashSet(wordDict),0,new Boolean[s.length()]);
    }
    public boolean wordBreak0(String s, Set<String> wordDict, int start){
        //暴力递归
        if (start == s.length()){
            return true;
        }
        for (int end = start+1; end <= s.length(); end++) {
            if (wordDict.contains(s.substring(start,end)) && wordBreak0(s,wordDict,end)){
                return true;
            }
        }
        return false;
    }

    public boolean wordBreak2(String s,Set<String> wordDict, int start,Boolean[] memo){
        //注意memo的数据类型
        if (start == s.length()) {
            return true;
        }
        if (memo[start] != null) {
            return memo[start];
        }
        for (int end = start + 1; end <= s.length(); end++) {
            if (wordDict.contains(s.substring(start, end)) && wordBreak2(s, wordDict, end, memo)) {
                return memo[start] = true;
            }
        }
        return memo[start] = false;
    }

    public boolean wordBreak3(String s, List<String> wordDict) {
        Set<String> wordDictSet=new HashSet(wordDict);
        Queue<Integer> queue = new LinkedList<>();
        int[] visited = new int[s.length()];
        queue.add(0);
        while (!queue.isEmpty()) {
            int start = queue.remove();
            if (visited[start] == 0) {
                for (int end = start + 1; end <= s.length(); end++) {
                    if (wordDictSet.contains(s.substring(start, end))) {
                        queue.add(end);
                        if (end == s.length()) {
                            return true;
                        }
                    }
                }
                visited[start] = 1;
            }
        }
        return false;
    }

    public boolean wordBreak4(String s, List<String> wordDict){
        Set<String> wordDictSet=new HashSet(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        //对于subStr(0,i)，满足题意的要求是：存在一个j，使得subStr(0,j)和(j,i)这两个subStr(0,i)的子串都满足题意
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDictSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}
