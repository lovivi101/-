import org.junit.Test;

/**
 * @description:
 *
 * 当一个字符串满足如下条件时，我们称它是 美丽的 ：
 *
 * 所有 5 个英文元音字母（'a' ，'e' ，'i' ，'o' ，'u'）都必须 至少 出现一次。
 * 这些元音字母的顺序都必须按照 字典序 升序排布（也就是说所有的 'a' 都在 'e' 前面，所有的 'e' 都在 'i' 前面，以此类推）
 * 比方说，字符串 "aeiou" 和 "aaaaaaeiiiioou" 都是 美丽的 ，但是 "uaeio" ，"aeoiu" 和 "aaaeeeooo" 不是美丽的 。
 *
 * 给你一个只包含英文元音字母的字符串 word ，请你返回 word 中 最长美丽子字符串的长度 。如果不存在这样的子字符串，请返回 0 。
 *
 * 子字符串 是字符串中一个连续的字符序列。
 *
 *示例 1：
 *
 * 输入：word = "aeiaaioaaaaeiiiiouuuooaauuaeiu"
 * 输出：13
 * 解释：最长子字符串是 "aaaaeiiiiouuu" ，长度为 13 。
 * 示例 2：
 *
 * 输入：word = "aeeeiiiioooauuuaeiou"
 * 输出：5
 * 解释：最长子字符串是 "aeiou" ，长度为 5 。
 * 示例 3：
 *
 * 输入：word = "a"
 * 输出：0
 * 解释：没有美丽子字符串，所以返回 0 。
 * @author: hjx
 * @time: 2021年04月25日 10:55
 */
public class Longest_Substring_Of_All_Vowels_in_Order {
    public int longestBeautifulSubstring(String word) {

        if (word.length()<5) return 0;
        int length = 0 ;
        int count = 1;
        int Char_nums = 1;
        for (int i = 1; i < word.length(); i++) {
            if (word.charAt(i)>=word.charAt(i-1)) count++;
            if (word.charAt(i)>word.charAt(i-1)) Char_nums++;
            if (word.charAt(i)<word.charAt(i-1)){
                count = 1;
                Char_nums = 1 ;
            }
            if (Char_nums==5) {
                length = Math.max(length,count);
            }
        }
        return length;

       /* int length = word.length();
        boolean[] flag = new boolean[26];
        boolean flag1 = true ;
        int n = Integer.MIN_VALUE;
        char temp = 'a';
        StringBuffer str = new StringBuffer("");
        for (int i = 0; i < length; i++) {
            if (word.charAt(i)>=temp){
                str.append(word.charAt(i));
                flag[word.charAt(i)-'a'] = true;
                temp = word.charAt(i);
            }
            if (word.charAt(i)<temp||i==length-1){
                if (!flag['a'-'a']){
                    flag1 = false;
                }
                if (!flag['e'-'a']){
                    flag1 = false;
                }
                if (!flag['i'-'a']){
                    flag1 = false;
                }
                if (!flag['o'-'a']){
                    flag1 = false;
                }
                if (!flag['u'-'a']){
                    flag1 = false;
                }
                if (flag1==true){
                    n = Math.max(str.length() , n);
                }
                str = new StringBuffer("a");
                flag1 = true;
                if (word.charAt(i)=='a'){
                    flag['a'-'a'] = true;
                }else {
                    flag['a'-'a'] = false;
                }
                flag['e'-'a'] = false;
                flag['i'-'a'] = false;
                flag['o'-'a'] = false;
                flag['u'-'a'] = false;
                temp = 'a';
            }
        }
        return n==Integer.MIN_VALUE?0:n;*/
    }
    @Test
    public void test(){
        String s = "aeiaaioaaaaeiiiiouuuooaauuaeiu";
        System.out.println(longestBeautifulSubstring(s));
//        System.out.println(s1.length());
    }
}
