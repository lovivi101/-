import org.junit.Test;

/**
 * @description:1482. 制作 m 束花所需的最少天数
 * https://leetcode-cn.com/problems/minimum-number-of-days-to-make-m-bouquets/
 * @author: hjx
 * @time: 2021年05月09日 8:09
 */
public class Minimum_Number_of_Days_to_Make_m_Bouquets {
    public int minDays(int[] bloomDay, int m, int k) {
        if (m*k>bloomDay.length) return -1;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < bloomDay.length; i++) {
            max = Math.max(bloomDay[i] , max);
            min = Math.min(bloomDay[i] , min);
        }
        if (m*k==bloomDay.length) {
            return max;
        }
        int mid = -1 ;
        while (min<max){
            int count = 0 ;
            mid = (max-min)/2 + min;
            int flag = 0;
            for (int j = 0; j < bloomDay.length; j++) {

                if (bloomDay[j]<=mid){
                    flag++;
                    if (flag==k){
                        count++;
                        flag=0;
                    }
                }
                else flag=0;
            }
            if (count>=m){
                max= mid;

            }
            else {
                min = mid+1;System.out.println(count);
            }
        }
        return min;
    }

    @Test
    public void test(){
        int[] bloomDay = {1,10,2,9,3,8,4,7,5,6};
        int m = 4 , k = 2;
        System.out.println(minDays(bloomDay,m,k));
    }
}
