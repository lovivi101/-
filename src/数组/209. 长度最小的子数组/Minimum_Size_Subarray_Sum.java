import org.junit.Test;

import javax.management.loading.MLet;

/**
 * @description:
 * 209. 长度最小的子数组
 * https://leetcode-cn.com/problems/minimum-size-subarray-sum/
 * @author: hjx
 * @time: 2021年04月21日 16:05
 */
public class Minimum_Size_Subarray_Sum {
    public int minSubArrayLen(int target, int[] nums) {
//        暴力算法
//        O(n^2)
        /*int Minlength = Integer.MAX_VALUE;
        int sum = 0 ;
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            sum = 0 ;
            for (int j = i; j < length; j++) {
                sum+=nums[j];
                if (sum>=target){
                    Minlength = Math.min(Minlength,j-i+1);
                    break;
                }
            }
        }
        return Minlength==Integer.MAX_VALUE ? 0:Minlength;*/


//        滑动窗口 O(n)
        int left = 0 ;
        int right = 0;
        int length = nums.length;
        int sum = 0;
        int MIN_length = Integer.MAX_VALUE;
        while (right<length&&left<length){
            sum+=nums[right];
            if (sum>=target){
                while (sum>=target&&left<length){
                    MIN_length = Math.min(MIN_length,right-left+1);
                    sum-=nums[left] ;
                    left++;
                }
            }
            right++;
        }
        return MIN_length==Integer.MAX_VALUE ? 0:MIN_length;
    }

    @Test
    public void test(){
        int[] arr = {2,3,1,2,4,3};
        int target =7;
        System.out.println(minSubArrayLen(target , arr));
    }

}
