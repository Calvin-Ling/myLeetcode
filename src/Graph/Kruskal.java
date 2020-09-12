package Graph;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/**
 * 实现权值和最大的MST
 * 测试：
 * 5 5
 * 1 2 1
 * 1 5 1
 * 3 5 1
 * 2 4 1
 * 4 5 2
 * 返回5
 * @author Calvin
 * @version 1.0
 * @date 2020/8/11 21:26
 */
public class Kruskal {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int n = sc.nextInt();
            int m = sc.nextInt();
            Edge[] edges = new Edge[n];
            for (int i = 0; i < m; i++) {
                int u1 = sc.nextInt(),v1 = sc.nextInt(),w1 = sc.nextInt();
                edges[i] = new Edge(u1,v1,w1);
            }
            System.out.println(solution(n,edges));
        }
    }
    public static int solution(int n,Edge[] edges){
        int m = edges.length;
        Arrays.sort(edges, Collections.reverseOrder());
        for (int i = 0; i < m; i++) {
            System.out.println(edges[i].u+" "+edges[i].v+" "+edges[i].weight);
        }
        System.out.println();
        int[] vetex = new int[n];
        for (int i = 0; i < n; i++) {
            vetex[i] = i;
        }
        int res = 0;
        for (int i = 0; i < m; i++) {
            if (vetex[edges[i].u-1] != vetex[edges[i].v-1]){
                res += edges[i].weight;
                int target = vetex[edges[i].u-1];
                for (int j = 0; j < n; j++) {
                    if (vetex[j] == target) vetex[j] = vetex[edges[i].v-1];
                }
            }
            for (int j = 0; j < n; j++) {
                System.out.print(vetex[j]+" ");
            }
            System.out.println();
        }
        return res;
    }
}

class Edge implements Comparable<Edge>{
    int u,v;
    int weight;

    Edge(int u,int v,int weight){
        this.u = u;
        this.v = v;
        this.weight = weight;
    }

    @Override
    public int compareTo(Edge o) {
        return this.weight - o.weight;
    }
}
