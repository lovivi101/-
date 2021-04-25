import org.junit.Test;

import java.util.Arrays;
import java.util.TreeSet;

/**
 * @description:
 * 363. 矩形区域不超过 K 的最大数值和
 * https://leetcode-cn.com/problems/max-sum-of-rectangle-no-larger-than-k/
 * @author: hjx
 * @time: 2021年04月22日 8:16
 */
public class Max_Sum_of_Rectangle_No_Larger_Than_K {
    public int maxSumSubmatrix(int[][] matrix, int k) {
/*        int m = matrix.length;
        int n = matrix[0].length;
//        System.out.println(m);
//        System.out.println(n);
        int[][] sum = new int[m+1][n+1];
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < m; j++) {
                matrix[0][i]+=matrix[j][i];
            }
        }*/
        int ans = Integer.MIN_VALUE;
        int m = matrix.length, n = matrix[0].length;
        for (int i = 0; i < m; ++i) { // 枚举上边界
            int[] sum = new int[n];
            for (int j = i; j < m; ++j) { // 枚举下边界
                for (int c = 0; c < n; ++c) {
                    sum[c] += matrix[j][c]; // 更新每列的元素和
                }
                TreeSet<Integer> sumSet = new TreeSet<Integer>();
                sumSet.add(0);
                int s = 0;
                for (int v : sum) {
                    s += v;
                    Integer ceil = sumSet.ceiling(s - k);
                    if (ceil != null) {
                        ans = Math.max(ans, s - ceil);
                    }
                    sumSet.add(s);
                }
            }
        }
        return ans;

    }

    @Test
    public void test(){
        int[][] arr = {{1, 0, 1}, {0, -2, 3}};

        int k = 2 ;
        maxSumSubmatrix(arr,2);

    }
}
