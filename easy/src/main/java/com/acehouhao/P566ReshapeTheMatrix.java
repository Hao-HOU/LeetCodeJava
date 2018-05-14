package com.acehouhao;

/**
 * @author houhao
 */
public class P566ReshapeTheMatrix {
    public static void main(String[] args) {
        int[][] nums = {{1, 2, 3}, {4, 5, 6}};
        int[][] res = matrixReshape(nums, 3 , 2);
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[0].length; j++) {
                System.out.print(res[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int[][] matrixReshape(int[][] nums, int r, int c) {
        if (nums == null || (nums.length * nums[0].length != r * c)) {
            return nums;
        }

        int[][] res = new int[r][c];
        int count = r * c;
        for (int i = 0; i < count; i++) {
            res[i / c][i % c] = nums[i / nums[0].length][i % nums[0].length];
        }

        return res;
    }
}
