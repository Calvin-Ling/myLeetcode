package code;

import java.util.*;

/*给你两个整数 m 和 k ，以及数据流形式的若干整数。你需要实现一个数据结构，计算这个数据流的 MK 平均值 。

        MK 平均值 按照如下步骤计算：

        如果数据流中的整数少于 m 个，MK 平均值 为 -1 ，否则将数据流中最后 m 个元素拷贝到一个独立的容器中。
        从这个容器中删除最小的 k 个数和最大的 k 个数。
        计算剩余元素的平均值，并 向下取整到最近的整数 。
        请你实现 MKAverage 类：

        MKAverage(int m, int k) 用一个空的数据流和两个整数 m 和 k 初始化 MKAverage 对象。
        void addElement(int num) 往数据流中插入一个新的元素 num 。
        int calculateMKAverage() 对当前的数据流计算并返回 MK 平均数 ，结果需 向下取整到最近的整数 。

        来源：力扣（LeetCode）
        链接：https://leetcode.cn/problems/finding-mk-average
        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/
public class lc1825 {
    class MKAverage {
        private List<Integer> list = new LinkedList<>();
        private int size = 0;
        private int kill = 0;
        private int sum = 0;
        private Map<Integer, Integer> map = new HashMap<>();
        public MKAverage(int m, int k) {
            this.size = m;
            this.kill = k;
        }
        public void addElement(int num) {
            this.list.add(num);
            this.map.put(num, this.map.getOrDefault(num, 0) + 1);
            this.sum += num;
            if (this.list.size() == this.size + 1) {
                int del = this.list.remove(0);
                this.map.put(del, this.map.getOrDefault(del, 0) - 1);
                this.sum -= del;
            }
        }
        public int calculateMKAverage() {
            if (this.list.size() < this.size) return -1;
            PriorityQueue<Integer> maxQ = new PriorityQueue<>((o1, o2) -> o2 - o1);
            PriorityQueue<Integer> minQ = new PriorityQueue<>();
            for (int num:map.keySet()) {
                maxQ.offer(num);
                minQ.offer(num);
            }
            int count = 0, collectionSum = this.sum;
            while (count < this.kill && !maxQ.isEmpty()) {
                int num = maxQ.poll();
                int nCount = map.getOrDefault(num, 0);
                if (count + nCount < this.kill) {
                    count += nCount;
                    collectionSum -= num*nCount;
                } else {
                    collectionSum -= num*(this.kill - count);
                    break;
                }
            }
            count = 0;
            while (count < this.kill && !minQ.isEmpty()) {
                int num = minQ.poll();
                int nCount = map.getOrDefault(num, 0);
                if (count + nCount < this.kill) {
                    count += nCount;
                    collectionSum -= num*nCount;
                } else {
                    collectionSum -= num*(this.kill - count);
                    break;
                }
            }
            return collectionSum/(this.size - 2 * this.kill);
        }
    }
}
