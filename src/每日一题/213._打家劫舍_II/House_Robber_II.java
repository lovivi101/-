import org.junit.Test;

/**
 * @description:
 * @author: hjx
 * @time: 2021年04月15日 10:38
 */
public class House_Robber_II {
    public int rob(int[] nums) {

        if (nums.length==1) return nums[0];
        if (nums.length==2) return Math.max(nums[0] , nums[1]);
        int length = nums.length;
        int[] dp1 = new int[nums.length+1];
        int[] dp2 = new int[nums.length+1];
        dp1[1] = dp2[1] = nums[0] ;
        dp1[2] = dp2[2] = Math.max(nums[0] , nums[1]);
        for (int i = 3; i <= length-1; i++) {
            dp1[i] = Math.max(dp1[i-1] , dp1[i-2]+nums[i-1]);
        }
        for (int i = 2; i < length-1; i++) {
            dp2[i] = Math.max(dp2[i-1] , dp2[i-2]+nums[i-1]);
        }
        return Math.max(dp1[length-1] , dp2[length-2]);
    }

    @Test
    public void test(){
        int[] arr = {1,2,1,1};
        System.out.println(rob(arr));
    }
}

