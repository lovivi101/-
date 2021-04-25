import org.junit.Test;

/**
 * @description:
 * 27. 移除元素
 * https://leetcode-cn.com/problems/remove-element/
 * @author: hjx
 * @time: 2021年04月19日 9:02
 */
public class Remove_Element {
    public int removeElement(int[] nums, int val) {
        int left = 0;
        int right = 0;
        int length = nums.length;
        for (int i = 0; i < nums.length; i++) {
            if (nums[right]==val){
                length--;
                right++;
                continue;
            }
            nums[left] = nums[right];
            left++;
            right++;
        }
        return length;
    }

    @Test
    public void test(){
        int[] arr =
//                {3,2,2,3};
        {0,1,2,2,3,0,4,2};
        int val = 2;
        int n = removeElement(arr, val);
        System.out.println(n);
        for (int i = 0; i < n; i++) {
            System.out.printf("%d " , arr[i]);
        }
    }
}
