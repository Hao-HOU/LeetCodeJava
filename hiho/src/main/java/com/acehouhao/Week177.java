package com.acehouhao;

import java.util.Scanner;

/**
 * @author houhao
 */
public class Week177 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int M = in.nextInt();
        int[][] points = new int[M][4];

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < 4; j++) {
                points[i][j] = in.nextInt();
            }
        }


        for (int i = 0; i < M; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.println(points[i][j]);
            }
        }


        in.close();
    }
}
