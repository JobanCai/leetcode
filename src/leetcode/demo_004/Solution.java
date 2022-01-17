package leetcode.demo_004;

/**
 * Created by Jerliner on 2022/1/17.
 */
public class Solution {

    // 矩阵由0,1组成，可以按照行或者列进行翻转，翻转后每行按照二级制数进行相加，求最大值
    // 思路:1.先将首列所有不为1的行进行翻转2.从第二列开始，判断0的个数是否大于一半，如是则翻转列3.将行进行二进制相加
    public static int matrixScore(int[][] grid) {
        int[] a = new int[grid[0].length];
        for (int i = 0; i < grid.length; i++) {

            boolean flag = grid[i][0] == 0;
            for (int j = 0; j < grid[i].length; j++) {
                if (flag) {// 整行进行异或操作
                    grid[i][j] = grid[i][j] ^ 1;
                }

                a[j] += grid[i][j];
            }

        }

        // 对列进行异或
        for (int i = 1; i < grid[0].length; i++) {
            if (a[i] <= grid.length / 2) { // 同一列中1的含量少于一半
                for (int j = 0; j < grid.length; j++) {
                    grid[j][i] = grid[j][i] ^ 1;
                }
            }
        }

        // 求和
        int result = 0;
        for (int i = 0; i < grid.length; i++) {
            StringBuilder res = new StringBuilder();
            for (int j = 0; j < grid[i].length; j++) {
                res.append(String.valueOf(grid[i][j]));
            }
            result = result + Integer.parseInt(res.toString(), 2);
        }

        return result;
    }

}
