package code;

import java.util.HashSet;

/**
 * 128.最长连续序列
 * 给定一个未排序的整数数组，找出最长连续序列的长度。
 * 要求算法的时间复杂度为 O(n)。
 * 示例：
 * 输入: [100, 4, 200, 1, 3, 2]
 * 输出: 4
 * 解释: 最长连续序列是 [1, 2, 3, 4]。它的长度为 4。
 *
 * 难度：困难
 * 分类：哈希表、数组
 * 思路一：桶排序，找到nums中最大和最小的数，分别为max和min，用长度为max-min+1的数组，储存nums中的元素，索引为相对应的值，新数组的值记录出现的次数。
 * 遍历这个数组，找出最长连续序列的长度。
 * 思路二：放入哈希表，考虑以每个元素为最长连续序列的开始的数num（即要求num-1不在nums中），查找num+1、num+2……是否在表中，不在则退出循环。
 */
public class lc128 {
    public int longestConsecutive(int[] nums){
        int maxLen = 0;
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        for (int num : set){
            int currLen = 1;
            int currNum = num;
            if (!set.contains(num-1)){
                while (set.contains(currNum+1)){
                    currNum++;
                    currLen++;
                }
            }
            maxLen = Math.max(currLen,maxLen);
        }
        return maxLen;
    }
}
