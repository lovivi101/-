import org.junit.Test;

/**
 * @description:
 * 633. 平方数之和
 * https://leetcode-cn.com/problems/sum-of-square-numbers/
 * @author: hjx
 * @time: 2021年04月28日 8:26
 */
public class Sum_of_Square_Numbers {
    public boolean judgeSquareSum(int c) {

        int i = 1 ;
        int j = (int) Math.sqrt(c);
        long sum = 0 ;
        while (i<=j){
            sum = (long) (Math.pow(i,2)+Math.pow(j,2));
            if (sum>c){
                j--;
            }
            if (sum<c){
                i++;
            }
            if (sum==c){
                return true;
            }
        }
        return false;
    }

    @Test
    public void test(){
        System.out.println(judgeSquareSum(106));
    }
}
