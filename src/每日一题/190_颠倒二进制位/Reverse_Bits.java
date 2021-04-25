import org.junit.Test;

import java.util.Scanner;

/**
 * @description:
 * @author: hjx
 * @time: 2021年03月29日 7:55
 */


/*        与（&）运算  与运算进行的是这样的算法：
                0&0=0,0&1=0,1&0=0,1&1=1

        非（~）运算 非运算即取反运算，在二进制中1变0,0变1
        110101进行非运算后为
        001010即101

        或（|）运算
        或运算进行的是这样的算法：

        0|0=0,0|1=1,1|0=1,1|1=1
        异或（^）运算
        异或运算通俗地讲就是一句话
        同为假，异为真
        所以它是这样的算法:

        0^0=0,0^1=1,1^0=1,1^1=0*/
public class Reverse_Bits {
    public int reverseBits(int n) {
        int rev = 0;
        for (int i = 0; i < 32 && n != 0; ++i) {
            rev |= (n & 1) << (31 - i);
            n >>>= 1;
        }
        return rev;
    }
    @Test
    public void test(){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(reverseBits(n));
    }
}
