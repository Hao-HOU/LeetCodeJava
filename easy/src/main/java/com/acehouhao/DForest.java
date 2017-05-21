package com.acehouhao;

import java.util.Scanner;

/**
 * Created by Hao HOU on 2017/5/21.
 */
public class DForest {
    private static final int max = 50;
    private static int[] parent = new int[max];
    private static int[] leaf = new int[max];
    private static int[] deg = new int[max];
    private static int[] parlen = new int[max];
    private static int[] cut = new int[max];
    private static int[] dist = new int[max];


    static int greedy(int d) {
        int total = 0;
        for (int i = 1; i <= leaf[0]; i++) {
            if (leaf[i] != 1) {
                int par = parent[leaf[i]];
                int len = parlen[leaf[i]];
                if (cut[par] < 1 && dist[leaf[i]] + len > d) {
                    cut[par] = 1;
                    par = parent[par];
                    total++;
                } else if (cut[par] < 1 && dist[par] < dist[leaf[i]] + len){
                    dist[par] = len + dist[leaf[i]];
                }
                if (--deg[par] == 0) {
                    leaf[++leaf[0]] = par;
                }
            }
        }
        return total;
    }

    public static void main(String[] args) {
        int n, d;
        Scanner in = new Scanner(System.in);
        System.out.println("输入树的顶点数：");
        n = in.nextInt();
        int a, len;
        leaf[0] = 0;
        for (int i = 1; i <= n; i++) {
            deg[i] = in.nextInt();
            if (deg[i] == 0) {
                leaf[++leaf[0]] = i;
            } else {
                for (int j = 0; j < deg[i]; j++) {
                    a = in.nextInt();
                    len = in.nextInt();
                    parent[a] = i;
                    parlen[a] = len;
                }
            }
        }

        System.out.println("输入d：");
        d = in.nextInt();

        System.out.println("最小分离集s顶点树为：" + greedy(d));

    }
}
