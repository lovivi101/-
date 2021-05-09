import org.junit.Test;

/**
 * @description:
 * 740. 删除并获得点数
 * https://leetcode-cn.com/problems/delete-and-earn/
 * @author: hjx
 * @time: 2021年05月05日 9:17
 */
public class Delete_and_Earn {
    public int deleteAndEarn(int[] nums) {
        if (nums.length==1)
            return nums[0];
        int MaxNum = Integer.MIN_VALUE;
        for (int num : nums) {
            MaxNum= Math.max(MaxNum , num);
        }
        int[] sum = new int[MaxNum+1];
        for (int num : nums) {
            sum[num]+=num;
        }

        int temp1 = sum[1];
        int temp2 = Math.max(sum[1] , sum[2]);

        for (int i = 3; i < sum.length; i++) {
            int temp = temp2;
            temp2 = Math.max(temp2 , temp1+sum[i]);
            temp1 = temp ;
        }
        return temp2;

/*        int[] dp = new int[MaxNum+1];
        dp[1] = sum[1];
        dp[2] = Math.max(sum[2] , sum[1]);
        for (int i = 3; i < sum.length; i++) {
            dp[i] = Math.max(dp[i-1] , dp[i-2]+sum[i]);
        }
        return dp[MaxNum];*/
    }
    @Test
    public void test(){
        int[] arr = {3,4,2};
        System.out.println(deleteAndEarn(arr));
    }
}
