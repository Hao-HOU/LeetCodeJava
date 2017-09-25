package com.acehouhao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author houhao
 */
public class P539MinimumTimeDifference {
    public static void main(String[] args) {
        List<String> timePoints = new ArrayList<>();
        timePoints.add("23:55");
        timePoints.add("00:00");
        timePoints.add("00:06");
        timePoints.add("11:02");
        timePoints.add("11:05");
        System.out.println(findMinDifference(timePoints));
        System.out.println(findMinDifferencePro(timePoints));
    }

    //自己的解法，调用了一次Arrays.sort()，计算最小分钟数的时候又采用了双层循环，复杂度略高！！！
    public static int findMinDifference(List<String> timePoints) {
        int[] minutes = new int[timePoints.size()];
        int i = 0;
        for (String s : timePoints) {
            String[] sp = s.split(":");
            minutes[i] = Integer.valueOf(sp[0]) * 60 + Integer.valueOf(sp[1]);
            i++;
        }
        Arrays.sort(minutes);
        int min = minutes[0] + 24 * 60 - minutes[minutes.length - 1];
        for (int j = 0; j < minutes.length; j++) {
            for (int k = j + 1; k < minutes.length; k++) {
                min = Math.min(min, Math.abs(minutes[k] - minutes[j]));
            }
        }

        return min;
    }

    //参考他人的思路，桶排序，单层循环求最小差值。
    public static int findMinDifferencePro(List<String> timePoints) {
        boolean[] minutes = new boolean[24 * 60];
        for (String s : timePoints) {
            String[] sp = s.split(":");
            int index = Integer.valueOf(sp[0]) * 60 + Integer.valueOf(sp[1]);
            if (minutes[index]) {
                return 0;
            }
            minutes[index] = true;
        }

        int first = Integer.MAX_VALUE;
        int last = 0;
        int min = Integer.MAX_VALUE;
        int pre = 0;
        for (int i = 0; i < minutes.length; i++) {
            if (minutes[i]) {
                if (first == Integer.MAX_VALUE) {
                    first = i;
                    pre = i;
                } else {
                    min = Math.min(min, i - pre);
                    pre = i;
                }
                last = i;
            }
        }
        min = Math.min(min, first + 24 * 60 - last);
        return min;
    }
}
