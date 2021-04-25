import org.junit.Test;

import java.util.Arrays;

/**
 * @description:
 * 给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组的新长度。
 *
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 * 输入：nums = [1,1,2]
 * 输出：2, nums = [1,2]
 * 解释：函数应该返回新的长度 2 ，并且原数组 nums 的前两个元素被修改为 1, 2 。不需要考虑数组中超出新长度后面的元素。
 * @author: hjx
 * @time: 2021年04月17日 17:11
 */
public class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length==0)
            return 0;
        int left = 0 ;
        int right = 0;
//        int length = nums.length;
        for (int i = 0; i < nums.length; i++) {
//            System.out.println(i);
            if (nums[left]!=nums[right]){
                nums[left+1]=nums[right];
                left++;
            }
            right++;
        }
        return left+1;
    }

    @Test
    public void test(){
        int[] nums = {0,0,0,0,0,1,1,1,2,2,3,3,4,4,5};
        System.out.println(nums.length);
        System.out.println(Arrays.toString(nums));
        System.out.println(removeDuplicates(nums));
        System.out.println(Arrays.toString(nums));
    }
}
