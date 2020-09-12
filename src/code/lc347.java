package code;

import java.util.HashMap;
import java.util.PriorityQueue;

/**
 * 347.前k个高频元素
 * 给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
 * 实例一：
 * 输入: nums = [1,1,1,2,2,3], k = 2
 * 输出: [1,2]
 * 实例二：
 * 输入: nums = [1], k = 1
 * 输出: [1]
 * 提示：
 * 你可以假设给定的 k 总是合理的，且 1 ≤ k ≤ 数组中不相同的元素的个数。
 * 你的算法的时间复杂度必须优于 O(n log n) , n 是数组的大小。
 * 题目数据保证答案唯一，换句话说，数组中前 k 个高频元素的集合是唯一的。
 * 你可以按任意顺序返回答案。
 *
 * 难度：中等
 * 分类：数组
 * 思路：将前k个元素及出现次数放入map，利用升序优先队列保留前k个元素。
 */
public class lc347 {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num:nums) {
            map.put(num,map.getOrDefault(num,0)+1);
        }

        //升序排列
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>((n1,n2) -> map.get(n1) - map.get(n2));

        for (int num: map.keySet()) {
            heap.add(num);
            if (heap.size() > k){//一旦大于k，队首元素出列
                heap.poll();
            }
        }

        int[] topK = new int[k];
        int index = 0;
        while (!heap.isEmpty()){
            topK[index++] = heap.poll();
        }
        return topK;
    }
}
