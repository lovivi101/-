/**
 * @description:
 * 26. 删除有序数组中的重复项
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/
 * @author: hjx
 * @time: 2021年04月18日 9:28
 */
public class Remove_Duplicates_from_Sorted_Array {
    public int removeDuplicates(int[] nums) {
        if (nums.length==0)
            return 0;
        int left = 0 ;
        int right = 0;
//        int length = nums.length;
        for (int i = 0; i < nums.length; i++) {
            if (nums[left]!=nums[right]){
                nums[left+1]=nums[right];
                left++;

            }
            right++;
        }
        return left+1;
    }
}
