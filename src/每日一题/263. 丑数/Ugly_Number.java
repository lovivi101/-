import org.junit.Test;

import java.util.Scanner;

/**
 * @description:
 *263. 丑数
 * https://leetcode-cn.com/problems/ugly-number/
 * @author: hjx
 * @time: 2021年04月10日 9:20
 */

//-231 <= n <= 231 - 1
public class Ugly_Number {
    public boolean isUgly(int n) {
        if (n==0)return false;
        int[] arr = {2,3,5};
        for (int i = 0; i < arr.length; i++) {
            if (n%arr[i]==0){
                n = n/arr[i];
                if (n==1){
                    return true;
                }
                i=-1;
            }
        }
        return false;
    }

    @Test
    public void test(){
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()){
            int n = scanner.nextInt();
            System.out.println(isUgly(n));
        }
    }
}
