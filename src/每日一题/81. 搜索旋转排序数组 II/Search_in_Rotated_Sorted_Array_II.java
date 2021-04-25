import org.junit.Test;

import java.util.Arrays;

/**
 * @description:
 * 81. 搜索旋转排序数组 II
 * https://leetcode-cn.com/problems/search-in-rotated-sorted-array-ii/
 * @author: hjx
 * @time: 2021年04月07日 8:30
 */
public class Search_in_Rotated_Sorted_Array_II {
    public boolean search(int[] nums, int target) {
        Arrays.sort(nums);
        int length = nums.length ;
        int right = length - 1;
        int left = 0 ;
        int mid ;
        while (left<=right){
            mid = (right+left)/2;
            if (nums[mid]==target){
                return true;
            }
            else if (nums[mid]>target){
                right = mid - 1 ;
            }
            else {
                left = mid + 1 ;
            }
        }
        return false;
    }

    @Test
    public void test(){
        int[] arr = {2,5,6,0,0,1,2};
        System.out.println(search(arr, 0));
    }
}
