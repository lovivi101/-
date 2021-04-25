import org.junit.Test;

import java.util.ArrayList;

/**
 * @description:
 * 5738. K 进制表示下的各位数字总和
 *
 * 给你一个整数 n（10 进制）和一个基数 k ，请你将 n 从 10 进制表示转换为 k 进制表示，计算并返回转换后各位数字的 总和 。
 *
 * 转换后，各位数字应当视作是 10 进制数字，且它们的总和也应当按 10 进制表示返回。
 *
 * 示例 1：
 *
 * 输入：n = 34, k = 6
 * 输出：9
 * 解释：34 (10 进制) 在 6 进制下表示为 54 。5 + 4 = 9 。
 * 示例 2：
 *
 * 输入：n = 10, k = 10
 * 输出：1
 * 解释：n 本身就是 10 进制。 1 + 0 = 1 。
 * @author: hjx
 * @time: 2021年04月25日 10:31
 */
public class The_sum_of_all_digits_in_k_system {
    public int sumBase(int n, int k) {
        ArrayList<Integer> arr = new ArrayList<>();
        while(n>0){
            int num1 = n%k;
            arr.add(num1);
            n = n/k;
            System.out.println(n);
        }
        int sum = 0 ;
        for (int i = 0; i <arr.size(); i++) {
            sum = sum + arr.get(i);
        }
        return sum ;
    }

    @Test
    public void test(){
       int n = 34 ;
       int k = 6;
       System.out.println(sumBase(n,k));
    }
}
