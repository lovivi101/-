/**
 * @description:
 * 33. 搜索旋转排序数组
 * https://leetcode-cn.com/problems/search-in-rotated-sorted-array/
 * @author: hjx
 * @time: 2021年04月07日 8:48
 */
public class Search_in_Rotated_Sorted_Array {
    public int search(int[] nums, int target) {

        int length = nums.length ;
        int right = length - 1 ;
        int left = 0 ;
        int mid ;
        if (length == 0) {
            return -1;
        }
        if (length == 1) {
            return nums[0] == target ? 0 : -1;
        }
        while (right>=left){
            mid = (right+left)/2;
            if (nums[mid]==target){
                return mid;
            }
            if (nums[mid]>=nums[0]){
                if (nums[0]<=target && target <nums[mid]){
                    right = mid - 1 ;
                }
                else left = mid + 1 ;
            }else {
                if (nums[mid] < target && target <= nums[length-1]){
                    left = mid + 1;
                }
                else right = mid - 1 ;
            }
        }
        return -1;
    }
}
