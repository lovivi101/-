import org.junit.Test;

import java.util.Arrays;

/**
 * @description:
 * 88. 合并两个有序数组
 * https://leetcode-cn.com/problems/merge-sorted-array/
 * @author: hjx
 * @time: 2021年04月05日 22:18
 */
public class Merge_Sorted_Array {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int i = m , j =0; i < nums1.length&&j<n; i++ ,j++) {
            nums1[i]=nums2[j];
        }
//        System.out.println(Arrays.toString(nums1));
        Arrays.sort(nums1);
        System.out.println(Arrays.toString(nums1));
    }

    @Test
    public void test(){
        int[] nums1 = {1};
        int m = 1;
        int[] nums2 = {};
        int n = 0;
        merge(nums1,3,nums2,3);
    }
}
