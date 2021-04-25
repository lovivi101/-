import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @description:
 *263. 丑数 II
 * https://leetcode-cn.com/problems/ugly-number-ii/
 * @author: hjx
 * @time: 2021年04月10日 9:20
 */

//-231 <= n <= 231 - 1
public class Ugly_Number_II {
    public boolean isUgly(long n) {

        if (n==0)return false;
        if (n==1)return true;
        int[] arr = {2,3,5};
        for (int i = 0; i < arr.length; i++) {
            if (n%arr[i]==0){
                n = n/arr[i];
                if (n==1){
                    return true;
                }
                i=-1;
            }
        }
        return false;
    }

    public int nthUglyNumber(int n){
        int[] dp = new int[n + 1];
        dp[1] = 1;
        int p2 = 1, p3 = 1, p5 = 1;
        for (int i = 2; i <= n; i++) {
            int num2 = dp[p2] * 2, num3 = dp[p3] * 3, num5 = dp[p5] * 5;
            dp[i] = Math.min(Math.min(num2, num3), num5);
            if (dp[i] == num2) {
                p2++;
            }
            if (dp[i] == num3) {
                p3++;
            }
            if (dp[i] == num5) {
                p5++;
            }
        }
        System.out.println(Arrays.toString(dp));
        return dp[n];
    }
    @Test
    public void test(){
        Scanner scanner = new Scanner(System.in);




        List list = new ArrayList();

        Integer i = 0;
        int temp = 0;
        while (temp<=1690){
            if (isUgly(i.longValue())){
                list.add(i);
                temp++;
            }
            i++;
        }
        System.out.println(list.size());
        System.out.println(list.toString());
    }

    @Test
    public void test1(){
        int[] dp = new int[1690 + 1];
        dp[1] = 1;
        int p2 = 1, p3 = 1, p5 = 1;
        for (int i = 2; i <= 1690; i++) {
            int num2 = dp[p2] * 2, num3 = dp[p3] * 3, num5 = dp[p5] * 5;
            dp[i] = Math.min(Math.min(num2, num3), num5);
            if (dp[i] == num2) {
                p2++;
            }
            if (dp[i] == num3) {
                p3++;
            }
            if (dp[i] == num5) {
                p5++;
            }
        }
        System.out.println(Arrays.toString(dp));
    }
}
