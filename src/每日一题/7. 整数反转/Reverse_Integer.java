import org.junit.Test;

/**
 * @description:
 * 7. 整数反转
 * https://leetcode-cn.com/problems/reverse-integer/
 * @author: hjx
 * @time: 2021年05月03日 7:50
 */
public class Reverse_Integer {
    public int reverse(int x) {

        if (x==0)
            return 0;
        int sum = 0;
        int mark = 1;
        if (x<0){
            mark = -1;
            x = x * mark;
        }
        while (x>0){
            int temp = x%10;
            sum = sum*10+temp;
            if (sum>Integer.MAX_VALUE/10||sum<Integer.MIN_VALUE/10)
                return 0;
            x=x/10;
        }
        return sum*mark;
    }
    @Test
    public void test(){
        System.out.println(reverse(1534236469));
    }
}
