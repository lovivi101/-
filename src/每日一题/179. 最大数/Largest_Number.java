import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @description:
 * 179. 最大数
 * https://leetcode-cn.com/problems/largest-number/
 * @author: hjx
 * @time: 2021年04月12日 8:20
 */
public class Largest_Number {
    public String largestNumber(int[] nums) {

        int length = nums.length ;
        String[] str = new String[length];
        for (int i = 0; i < length; i++) {
            str[i] = new Integer(nums[i]).toString();
        }

        Arrays.sort(str, (a,b)->{
            return (b+a).compareTo(a+b);
        });
        System.out.println(Arrays.toString(str));

        StringBuffer str1 = new StringBuffer("");
        for(String string : str){
            System.out.println(string);
            str1 = str1.append(string);
        }

        String s = str1.toString() ;

        return s.charAt(0)=='0'? "0" :s;
    }

    @Test
    public void test(){
        int[] arr = {0,0};
        System.out.println(largestNumber(arr));
    }
}
