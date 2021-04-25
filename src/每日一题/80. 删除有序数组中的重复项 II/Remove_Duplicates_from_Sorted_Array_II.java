import org.junit.Test;

/**
 * @description:
 * 80. 删除有序数组中的重复项 II
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array-ii/
 * @author: hjx
 * @time: 2021年04月06日 8:21
 */
public class Remove_Duplicates_from_Sorted_Array_II {
    public int removeDuplicates(int[] nums) {
        int count = 0 ;
        int temp = nums[0];
        int n = nums.length ;
        for (int i = 0; i < n; i++) {
            if (nums[i]==temp){
                count++;
            }
            else {
                temp = nums[i];
                count = 1 ;
            }
            if (count>2){
                for (int j = i; j < n-1; j++) {
                    nums[j]=nums[j+1];
                }
                n--;
                i--;
            }
        }
        return n ;
    }
    @Test
    public void test(){
        int[] nums = {0,0,1,1,1,1};
        int length = removeDuplicates(nums);
        for (int i = 0; i < length; i++) {
            System.out.println(nums[i]);
        }
    }
}
