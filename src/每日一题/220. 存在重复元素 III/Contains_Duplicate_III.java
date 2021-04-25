import org.junit.Test;

import java.util.TreeSet;

/**
 * @description:
 * 220. 存在重复元素 III
 * https://leetcode-cn.com/problems/contains-duplicate-iii/
 * @author: hjx
 * @time: 2021年04月17日 15:58
 */
public class Contains_Duplicate_III {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        int n = nums.length;
        TreeSet<Long> set = new TreeSet<Long>();
        for (int i = 0; i < n; i++) {
            Long ceiling = set.ceiling((long) nums[i] - (long) t);
            if (ceiling != null && ceiling <= (long) nums[i] + (long) t) {
                return true;
            }
            set.add((long) nums[i]);
            if (i >= k) {
                set.remove((long) nums[i - k]);
            }
        }
        return false;


   /*     if (nums.length==0)
            return false;

        if (t==0)
            return true;

        int length = nums.length;
        for (int i = 0; i < length ; i++) {
            for (int j = i-1; Math.abs(i-j)<=k&&j>=0; j--) {
                if (Math.abs(nums[i]-nums[j])<=t)
                    return true;
            }
            for (int j = i+1; Math.abs(i-j)<=k&&j<length; j++) {
                if (Math.abs(nums[i]-nums[j])<=t)
                    return true;
            }
        }
        return false;*/
    }

    @Test
    public void test(){
//        {-3,3,-6}
        int[] arr = {-3,3,-6};
        int k = 2;
        int t = 3;
        System.out.println(containsNearbyAlmostDuplicate(arr,k,t));
    }
}
