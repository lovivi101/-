import org.junit.Test;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @description:
 * https://leetcode-cn.com/problems/search-a-2d-matrix/
 * @author: hjx
 * @time: 2021年03月30日 8:46
 */
public class Search_a_2D_Matrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int length = matrix.length;
        int length1 = matrix[0].length;
        int temp = 0;
        for (int i = 0; i < length ; i++) {
            if (matrix[i][length1-1]>=target){
                temp = i;
                break;
            }
        }
/*        if (temp==0) return Spit_search(matrix[temp],target);
        if (isSort(matrix[temp])&&matrix[temp][0]>matrix[temp-1][length1-1])*/
        return Spit_search(matrix[temp],target);
//        return false;
    }
/*
    public boolean isSort(int[] arr){
        for (int i = 1; i < arr.length; i++) {
            if (arr[i]<arr[i-1]){
                return false;
            }
        }
        return true;
    }*/

    public boolean Spit_search(int[] arr , int target){
        int length = arr.length;
        int left = 0 ;
        int right = length-1 ;
        int mid ;
        while (left<=right){
            mid = (left+right)/2;
            System.out.println(mid);
            if (arr[mid]==target){
                return true;
            }
            else if(arr[mid]<target){
                left = mid+1 ;
            }
            else {
                right = mid-1 ;
            }
        }
        return false ;
    }

    @Test
    public void test(){
        Scanner scanner = new Scanner(System.in);
//        int[][] arr = new int[][] ;
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[][] arr = new int[n][m] ;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = scanner.nextInt();
            }
        }
        System.out.println(Arrays.deepToString(arr));
        while (scanner.hasNext()){
            int target = scanner.nextInt();
            System.out.println(searchMatrix(arr, target));
        }
    }
}
