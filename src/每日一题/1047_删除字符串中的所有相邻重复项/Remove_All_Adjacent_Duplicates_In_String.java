import org.junit.Test;

import java.util.Scanner;
import java.util.Stack;

/**
 * @description: Leetcode  1047. 删除字符串中的所有相邻重复项
 * 样例 abbaca
 * 结果 ca
 * 而消除一对相邻重复项可能会导致新的相邻重复项出现，如从字符串
 * abba 中删除 bb 会导致出现新的相邻重复项 aa 出现。
 * 因此我们需要保存当前还未被删除的字符。一种显而易见的数据结构呼之欲出：栈。
 * 我们只需要遍历该字符串，如果当前字符和栈顶字符相同，我们就贪心地将其消去，否则就将其入栈即可。
 *
 * @author: hjx
 * @time: 2021年03月20日 10:42
 */
public class Remove_All_Adjacent_Duplicates_In_String {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
    }

    public String removeDuplicates(String S) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < S.length(); i++) {
            if (stack.empty()){
                stack.push(S.charAt(i));
            }
            else {
//                System.out.println(stack.peek());
                if (stack.peek()==S.charAt(i)){
//                    System.out.println("delete :"+stack.peek()+" "+S.charAt(i));
                    stack.pop();
                }
                else {
                    stack.push(S.charAt(i));
                }
            }
        }
        String str = "";
        while (!stack.empty()){
//            System.out.println(str);
            str+=stack.pop();
        }
        StringBuffer stringBuffer = new StringBuffer(str);

        return stringBuffer.reverse().toString();
    }

    //优化代码  使用StringBuffer可变数组模拟栈
    public String removeDuplicates1(String S) {
        StringBuffer Str = new StringBuffer();
        int top = -1;
        for (int i = 0; i < S.length(); i++) {
            char ch = S.charAt(i);
            if (top>=0 && Str.charAt(top)==ch){
                Str.deleteCharAt(top);
                top--;
            }
            else {
                Str.append(ch);
                top++;
            }
            System.out.println(top);
            System.out.println(Str);
        }
        return Str.toString();
    }

    @Test
    public void test(){
        Scanner scanner = new Scanner(System.in);
        String S = scanner.nextLine();
        System.out.println(removeDuplicates(S));
        System.out.println(removeDuplicates1(S));
    }
}
