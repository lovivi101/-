import java.util.Stack;

/**
 * @description:5751. 下标对中的最大距离
 * 一个数组的 最小乘积 定义为这个数组中 最小值 乘以 数组的 和 。
 *
 * 比方说，数组 [3,2,5] （最小值是 2）的最小乘积为 2 * (3+2+5) = 2 * 10 = 20 。
 * 给你一个正整数数组 nums ，请你返回 nums 任意 非空子数组 的最小乘积 的 最大值 。由于答案可能很大，请你返回答案对  109 + 7 取余 的结果。
 *
 * 请注意，最小乘积的最大值考虑的是取余操作 之前 的结果。题目保证最小乘积的最大值在 不取余 的情况下可以用 64 位有符号整数 保存。
 *
 * 子数组 定义为一个数组的 连续 部分。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,3,2]
 * 输出：14
 * 解释：最小乘积的最大值由子数组 [2,3,2] （最小值是 2）得到。
 * 2 * (2+3+2) = 2 * 7 = 14 。
 * 示例 2：
 *
 * 输入：nums = [2,3,3,1,2]
 * 输出：18
 * 解释：最小乘积的最大值由子数组 [3,3] （最小值是 3）得到。
 * 3 * (3+3) = 3 * 6 = 18 。
 * 示例 3：
 *
 * 输入：nums = [3,1,5,6,4,2]
 * 输出：60
 * 解释：最小乘积的最大值由子数组 [5,6,4] （最小值是 4）得到。
 * 4 * (5+6+4) = 4 * 15 = 60 。
 *
 *
 * 提示：
 *
 * 1 <= nums.length <= 105
 * 1 <= nums[i] <= 107
 * @author: hjx
 * @time: 2021年05月09日 10:39
 */
public class Maximum_Subarray_Min_Product {
    public int maxSumMinProduct(int[] nums) {
        int length = nums.length;
        int[] left = new int[length];
        int[] right = new int[length];
        for (int i = 0; i < right.length; i++) {
            right[i] = length-1;
        }

        Stack<Integer> s = new Stack<>();
        for (int i = 0; i < length; i++) {
            while (!s.empty()&&nums[s.peek()]>=nums[i]){
                right[s.peek()] = i-1;
                s.pop();
            }
            if (!s.empty()){
                left[i] = s.peek()+1;
            }
            s.push(i);
        }

        long[] arr = new long[length+1];
        for (int i = 1; i <= length; i++) {
            arr[i] = arr[i-1] + nums[i-1];
        }
        long Max = 0 ;
        for (int i = 0; i < length; i++) {
            Max = Math.max(Max,(arr[right[i]+1]-arr[left[i]])*nums[i]);
        }
        long mod = 1000000007;
        return (int) (Max%mod);
    }
}
