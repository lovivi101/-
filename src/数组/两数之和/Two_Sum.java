import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * 1. 两数之和
 * https://leetcode-cn.com/problems/two-sum/
 * @author: hjx
 * @time: 2021年04月25日 9:28
 */
public class Two_Sum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer , Integer> map = new HashMap<>();
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            if (map.containsKey(target-nums[i])){
                return new int[]{ map.get(target-nums[i]),i};
            }
            map.put(nums[i] , i);
        }
        return null;

    }

    @Test
    public void test(){
        int[] arr = {2,7,11,15};

        System.out.println(Arrays.toString(twoSum(arr , 9)));
    }
}
