import org.junit.Test;

import java.util.Arrays;

/**
 * @description:
 * 1816. 截断句子
 * https://leetcode-cn.com/problems/truncate-sentence/
 * @author: hjx
 * @time: 2021年04月05日 11:49
 */
public class Truncate_Sentence {
    public String truncateSentence(String s, int k) {
        String s1= "";
        String[] s2 = s.split(" ");
//        System.out.println(s2);
        for (int i = 0; i < s2.length; i++) {
            if (i<k){
                s1=s1+s2[i]+" ";
            }
            else {
                break;
            }
        }
        return s1.trim();

        //trim()
        //返回一个字符串，其值为此字符串，并删除任何前导和尾随空格。
    }

    @Test
    public void test(){
        String s = "Hello how are you Contestant";
        String[] s2 = s.split(" ");
        System.out.println(Arrays.deepToString(s2));
        System.out.println(truncateSentence(s, 4));
    }
}
