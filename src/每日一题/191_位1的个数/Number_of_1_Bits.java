import org.junit.Test;

import java.util.Scanner;

/**
 * @description:
 * @author: hjx
 * @time: 2021年03月22日 9:25
 */
public class Number_of_1_Bits {
    public int hammingWeight(int n) {
        int res = 0;
        int temp = n;
        for (int i = 0; i < 32; i++) {
            if ((temp & 1) == 1) {
                res++;
            }
            temp >>= 1;
        }
        return res;
    }

    @Test
    public void test(){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(hammingWeight(n));
    }
}
