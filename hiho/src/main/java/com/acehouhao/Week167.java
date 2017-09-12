package com.acehouhao;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author houhao
 */
public class Week167 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] p = new int[n+1];
        for (int i = 1; i <= n; i++) {
            p[i] = in.nextInt();
        }
        System.out.println(numOfRearrangements(n, p));

        in.close();
    }

    public static int numOfRearrangements(int n, int[] p) {
        int times = 1;
        boolean flag = true;
        List<Integer> integerList = new ArrayList<>();

        while (flag) {
            flag = false;
            for (int i = 1; i <= n; i++) {
                if (p[i] == 0) {
                    continue;
                }
                if (p[i] == i) {
                    integerList.add(1);
                    p[i] = 0;
                } else {
                    int cnt = 0;
                    int index = i;
                    while (i <= n && p[i] != index) {
                        p[i] = 0;
                        cnt++;
                        i++;
                    }
                    if (p[i] == index) {
                        cnt++;
                        p[i] = 0;
                    }
                    integerList.add(cnt);
                }
                flag = true;
            }
        }

        if (integerList.size() == 1) {
            times = integerList.get(0);
        } else {
            int[] r = new int[integerList.size()];
            for (int i = 0; i < r.length; i++) {
                r[i] = integerList.get(i);
            }

            times = multiple(r, 0);
        }


        return times;
    }

    public static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        int c = a % b;
        return gcd(b, c);
    }
    public static int multiple(int a[],int count){
        //count表示从0开始，因为数组是从0开始的（后面也是这样）也就是从第一个数开始

        int divstorX=gcd(a[count],a[count+1]);
        //求第count-1个数与第count个数的最大公约数

        int multipleX=a[count]/divstorX*a[count+1];
        //求这2个数的最小公倍数
        //这句不能是int multipleX=a[count]*a[count+1]/divstorX；
        //虽然结果是一样的，但是先把2个int相乘可能会超过int的范围，所以先除，在乘，可以防止越界

        a[count+1]=multipleX;
        //把2个数的最小公倍数赋值给后面那个数也就是第count+2个数

        count++;    //使标记转到第count+2个数

        if(count!=a.length-1){    //如果count不是在倒数第二个数
            return multiple(a,count);
            //在求第count+1个数开始与第count+2个数的最小公倍数
        }

        return multipleX;    //求完之后返回这个数组的最小公倍数
    }
}
