import org.junit.Test;

import java.util.Stack;

/**
 * @description:
 * @author: hjx
 * @time: 2021年04月01日 8:17
 */
public class Clumsy_Factorial {
    public int clumsy(int N) {
        Stack<Integer> stack = new Stack<Integer>();
        int sum = 0;
        int ans = 0;
        for (int i = N; i > 0; i-=4) {
            int temp;
            int temp1 = 0;
            if (i>=4){
                temp = i*(i-1)/(i-2);
                temp1 = (i-3);
            }
            else if(i==3){
                temp = i*(i-1)/(i-2);
            }
            else if (i==2){
                temp = i*(i-1);
            }
            else {
                temp = i;
            }
            if (stack.empty()){
                stack.push(temp+temp1);
                continue;
            }
            stack.push(-temp+temp1);
        }
       /* for (int i = N ; i > 0; i-- ) {
            if (stack.empty()){
                stack.push(i);
                continue;
            }
            ans ++ ;
            if (ans%4==1){
                int num = stack.pop()*i ;
                stack.push(num);
            }
            else if (ans%4==2){
                int num = stack.pop()/i ;
                stack.push(num);
            }
            else if (ans%4==3){
                stack.push(i);

            }
            else {
                stack.push(-i);
            }
        }*/
        while (!stack.empty()){
            System.out.println(stack.peek());
            sum+=stack.pop();
        }
        return sum ;
    }



    @Test
    public void test(){
        int n = 10 ;
        System.out.println(clumsy(n));
    }
}
