import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @author: hjx
 * @time: 2021年04月30日 8:20
 */
public class Single_Number_II {
    public int singleNumber(int[] nums) {


        //朴素算法 先排序在操作
        // N(nlogn)
/*        if (nums.length==1)
            return nums[0];
        Arrays.sort(nums);
        if (nums[0]!=nums[1]){
            return nums[0];
        }
        if (nums[nums.length-1]!=nums[nums.length-2]){
            return nums[nums.length-1];
        }
        int count = 3 ;
        for (int i = 1; i < nums.length-1; i++) {
            if (nums[i]==nums[i-1]){
                count--;
            }
            else {
                if (nums[i]!=nums[i+1]){
                    return nums[i];
                }
                count=3;
            }
        }
        return -1 ;*/

        //进阶算法
        //N(n)
        if (nums.length==1)
            return nums[0];
        Map<Integer , Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)){
                map.put(num , map.get(num)+1);
            }
            else map.put(num,1);
        }
        //遍历map
        for (Integer integer : map.keySet()) {
            if (map.get(integer)==1) return integer.intValue();
        }
        return -1;

    }

    @Test
    public void test(){
        int[] nums = {0,1,0,1,0,1,99};
        System.out.println(singleNumber(nums));
    }

}
