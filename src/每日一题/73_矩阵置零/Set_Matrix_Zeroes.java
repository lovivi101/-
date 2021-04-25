import org.junit.Test;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @description:
 * @author: hjx
 * @time: 2021年03月21日 17:32
 */
public class Set_Matrix_Zeroes {
    // 空间复杂度 O(mn)  时间复杂度 (mnm)
    public void setZeroes(int[][] matrix) {

        System.out.println(matrix.length);
        System.out.println(matrix[0].length);
        boolean[][] arr = new boolean[matrix.length][matrix[0].length];
        boolean[][] mark= new boolean[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j]==0){
                    mark[i][j]=true;
                }
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (mark[i][j]){
                    Set_zero(matrix  , i , j);
                }
            }
        }
        System.out.println(Arrays.deepToString(matrix));
    }

    public void Set_zero(int[][] matrix , int i , int j){
        for (int k = 0 ; k < matrix[i].length ; k++){
            matrix[i][k]=0;
        }
        for (int k = 0 ; k < matrix.length; k++) {
            matrix[k][j]=0;
        }
    }


    //O(1)空间复杂度 使用原数组的第一列和第一行 标记
    public void setZeroes1(int[][] matrix){
        boolean flagCur = false ;
        boolean flagRow = false ;
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[0][i]==0){
                flagCur = true ;
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0]==0){
                flagCur = true ;
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j]==0){
                    matrix[i][0] = matrix[0][j] = 0;
                }
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][0]==0||matrix[0][j]==0){
                    matrix[i][j]=0;
                }
            }
        }
        if (flagCur){
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][0]=0;
            }
        }
        if (flagRow){
            for (int i = 0; i < matrix[0].length; i++) {
                matrix[0][i]=0;
            }
        }
        System.out.println(Arrays.deepToString(matrix));
    }

    @Test
    public void test(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("m:");
        int m = scanner.nextInt();
        System.out.println("n:");
        int n = scanner.nextInt();
        int[][] arr = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j]= scanner.nextInt();
            }
        }
        setZeroes1(arr);
    }

    @Test
    public void test1(){
        boolean[][] arr = new boolean[2][2];
        int[][] arr1 = new int[2][2];
        System.out.println(Arrays.deepToString(arr));//二维数组的打印
        System.out.println(Arrays.toString(arr1));
    }
}
