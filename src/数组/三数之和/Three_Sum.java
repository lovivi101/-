package 三数之和;

import org.junit.Test;

import java.util.*;

/**
 * @description:
 * 15. 三数之和
 * https://leetcode-cn.com/problems/3sum/
 * @author: hjx
 * @time: 2021年04月17日 8:43
 */
public class Three_Sum {
    public List<List<Integer>> threeSum(int[] nums) {


        List<List<Integer>> list = new ArrayList<>();

        boolean flag1 = false, flag2 = false ;
//        boolean[] flag = new boolean[nums.length];
        int length = nums.length;
        for (int i = 0; i < length-3; i++) {

            int right = length-1 ;
            for (int j = i+1; j < length-2; j++) {
                while (j<right&&(nums[i]+nums[j]+nums[right]>0))
                {
                    right--;
                }
                if (nums[i]+nums[j]+nums[right]==0){
                    List<Integer> list1 = new ArrayList<>();

                }
            }
        }
        return list;
    }
    @Test
    public void test(){
        int[] nums = {-1,0,1,2,-1,-4} ;
        System.out.println(threeSum(nums).toString());
    }
}
