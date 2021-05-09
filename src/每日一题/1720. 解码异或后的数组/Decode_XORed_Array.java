import org.junit.Test;

import java.util.Arrays;

/**
 * @description:
 * 1720. 解码异或后的数组
 * https://leetcode-cn.com/problems/decode-xored-array/
 *
 * 位逻辑运算符：
 * &:
 * 位与运算符，只有两个操作数都是true，结果才是true。
 * | :
 * 位或运算符，只有两个操作数都是false，结果才是false。
 * ~：
 * 位非运算符：如果位为0，结果是1，如果位为1，结果是0.
 * ^:
 * 位异或运算：两个数转为二进制，然后从高位开始比较，如果相同则为0，不相同则为1。
 *
 * 位同或运算：两个数转为二进制，然后从高位开始比较，如果相同则为1，不相同则为0。java中并没有同或运算符，可以通过异或转换得到。同或运算 = 异或运算  ^  1
 *
 * 逻辑运算符：
 * &&:
 * 逻辑与运算，也是只有两个操作数都是true，结果才是true。但是如果左边操作数为false，就不计算右边的表达式，直接得出false。类似于短路了右边。
 * ||:
 * 逻辑或运算，也是只有两个操作数都是false，结果才是false。但是如果左边操作数为true，就不计算右边的表达式，直接得出true。类似于短路了右边。
 * !：
 * 逻辑非运算，对操作数取反。
 * @author: hjx
 * @time: 2021年05月06日 8:34
 */
public class Decode_XORed_Array {
    public int[] decode(int[] encoded, int first) {
        int[] arr = new int[encoded.length+1];
        arr[0] = first;
        for (int i = 0; i < encoded.length; i++) {
            arr[i+1] = encoded[i]^arr[i];
        }
        return arr;
    }

    @Test
    public void test(){
        int[] encoded = {6,2,7,3};
        int first = 4;
        System.out.println(Arrays.toString(decode(encoded,first)));
    }
}
