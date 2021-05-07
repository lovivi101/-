import org.junit.Test;

/**
 * @description:
 * @author: hjx
 * @time: 2021年05月07日 7:57
 */
public class XOR_Operation_in_an_Array {
    public static int xorOperation(int n, int start) {
        int sum = 1;
        for (int i = 0; i < n; i++) {
            int temp = start+2*i;
            sum^=temp;
        }
        return sum;
    }

    public static void main(String[] args) {
        int n = 5 ;
        int start = 0;
        System.out.println(xorOperation(n,start));
    }

}