package com.acehouhao;

import java.util.Scanner;

/**
 * @author houhao
 */
public class P1039 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        String[] strings = new String[n];

        for (int i = 0; i < n; i++) {
            strings[i] = in.nextLine();
        }

        for (String str : strings) {
            System.out.println(str + ":" + eliminateCharacters(str));
        }
    }

    public static int eliminateCharacters(String str) {

        return 0;
    }
}
