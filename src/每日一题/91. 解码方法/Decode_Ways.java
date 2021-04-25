import org.junit.Test;

/**
 * @description:
 * 91. 解码方法
 * https://leetcode-cn.com/problems/decode-ways/
 * @author: hjx
 * @time: 2021年04月21日 9:45
 */
public class Decode_Ways {
    public int numDecodings(String s) {
        if (s.charAt(0)=='0')
            return 0;
        int length = s.length();
        /*int[] dp = new int[length+1] ;
        dp[0]=1;*/
        int count = 0;
        int temp1 = 1;
        int temp2 = 0;
        for (int i = 1; i <= length; i++) {

            count = 0 ;
            if (s.charAt(i-1)!='0'){
//                dp[i] = dp[i]+dp[i-1];
                count+=temp1 ;
            }
            if (i<=1) continue;
            int num = s.charAt(i-1)-'0'+(s.charAt(i-2)-'0')*10;
            if (s.charAt(i-2)!='0'&&num<=26){
//                dp[i] = dp[i]+dp[i-2];
                count+=temp2;
            }
            temp2 = temp1 ;
            temp1 = count ;
        }
//        return dp[length];
        return count ;
    }

    @Test
    public void test(){
        String s1 = "226";
        System.out.println(numDecodings(s1));
    }
}
