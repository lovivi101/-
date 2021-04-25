/**
 * @description:
 * 377. 组合总和 Ⅳ
 * https://leetcode-cn.com/problems/combination-sum-iv/
 * @author: hjx
 * @time: 2021年04月24日 9:25
 */
public class Combination_Sum_IV {
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 1; i <= target; i++) {
            for (int num : nums) {
                if (num <= i) {
                    dp[i] += dp[i - num];
                }
            }
        }
        return dp[target];
    }
}
