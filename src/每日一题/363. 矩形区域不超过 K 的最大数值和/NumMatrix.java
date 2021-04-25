import org.junit.Test;

import java.util.Arrays;

/**
 * @description:
 * 304. 二维区域和检索 - 矩阵不可变
 * https://leetcode-cn.com/problems/range-sum-query-2d-immutable/
 *
 * 二维前缀和
 * @author: hjx
 * @time: 2021年04月22日 9:09
 */
public class NumMatrix {

    int[][] matrix ;
    int row ;
    int column ;
    int[][] sum ;

//    public NumMatrix(int[][] matrix) {
//        this.matrix = matrix;
//        row = matrix.length;
//        column = matrix[0].length;
//        sum = new int[row+1][column+1];
//        for (int i = 0; i < row; i++) {
//            for (int j = 0; j < column; j++) {
//                sum[i][j+1] = sum[i][j]+matrix[i][j];
//            }
////            sum[i+1][0]=sum[i][row];
//        }
//
////        System.out.println(Arrays.deepToString(sum));
//    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum1 = 0;
        for (int i = row1; i <= row2 ; i++) {
            sum1 += (sum[i][col2+1]-sum[i][col1]);
        }
        return sum1 ;
    }

    @Test
    public void test(){
        int[][] matrix = {
        {3, 0, 1, 4, 2},
        {5, 6, 3, 2, 1},
        {1, 2, 0, 1, 5},
        {4, 1, 0, 1, 7},
        {1, 0, 3, 0, 5}
        };
        int row1 = matrix.length;
        int column1 = matrix[0].length;
//        System.out.println(row1+" "+column1);
        sum = new int[row1+1][column1+1];
        for (int i = 0; i < row1; i++) {
            for (int j = 0; j < column1; j++) {
                sum[i][j+1] = sum[i][j]+matrix[i][j];
            }
            sum[i+1][0]=sum[i][row1];

        }
//        System.out.println(Arrays.deepToString(sum));
        for (int i = 0; i <= row1; i++) {
            for (int j = 0; j <= column1; j++) {
                System.out.printf("%d " , sum[i][j]);
            }
            System.out.println("");
        }
        System.out.println(sumRegion(1, 1, 2, 2));
    }
}
