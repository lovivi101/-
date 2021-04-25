import org.junit.Test;

import java.util.Scanner;
import java.util.Stack;
import java.util.regex.Pattern;

/**
 * @description:
 * @author: hjx
 * @time: 2021年03月20日 8:56
 */
public class Evaluate_Reverse_Polish_Notation {
    public static int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack();
        Integer sum = 0;
        for (int i = 0; i < tokens.length; i++) {

/*            if (!stack.empty()){
                System.out.println(stack.peek());
            }*/

            if (tokens[i].equals("+")){
                if(!stack.empty()){
                    Integer num1 = stack.pop();
                    Integer num2 = stack.pop();
                    stack.push(num1+num2);
//                    System.out.println(num1+"+"+num2+"="+stack.peek());
                }
            }
            else if (tokens[i].equals("-")){
                if(!stack.empty()){
                    Integer num1 = stack.pop();
                    Integer num2 = stack.pop();
                    stack.push(num1-num2);
//                    System.out.println(num1+"-"+num2+"="+stack.peek());
                }
            }
            else if (tokens[i].equals("*")){
                if(!stack.empty()){
                    Integer num1 = stack.pop();
                    Integer num2 = stack.pop();
                    stack.push(num1*num2);
//                    System.out.println(num1+"*"+num2+"="+stack.peek());
                }
            }
            else if (tokens[i].equals("/")){
                if(!stack.empty()){
                    Integer num1 = stack.pop();
                    Integer num2 = stack.pop();
                    stack.push(num2/num1);
//                    System.out.println(num2+"/"+num1+"="+stack.peek());
                }
            }
            else if(isDigit(tokens[i])){
                stack.push(Integer.parseInt(tokens[i]));
            }
        }
        return stack.pop().intValue();
    }
    public static boolean isDigit(String str){
        Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");
        return pattern.matcher(str).matches();
    }

    @Test
    public void test(){
        System.out.println(isDigit("+"));
//        Scanner scanner = new Scanner(System.in);
        String[] str = {"2","1","+","3","*"};
        System.out.println(evalRPN(str));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] strings = scanner.nextLine().split(",");
        System.out.println(evalRPN(strings));
    }
}
