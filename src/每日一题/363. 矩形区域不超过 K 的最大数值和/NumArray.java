import java.util.Arrays;

/**
 * @description:
 * 303. 区域和检索 - 数组不可变
 * https://leetcode-cn.com/problems/range-sum-query-immutable/
 * @author: hjx
 * @time: 2021年04月22日 9:30
 */
public class NumArray {

    int[] nums;
    int[] sum ;
    int length ;

    public NumArray(int[] nums) {
        this.nums = nums ;
        sum = new int[nums.length+1];
        sum[0]=0;
        length = nums.length;
        for (int i = 0; i < length; i++) {
            sum[i+1]=sum[i]+nums[i];
        }
//        System.out.println(Arrays.toString(sum));
    }

    public int sumRange(int left, int right) {
        return sum[right]-sum[left-1];
    }
}
