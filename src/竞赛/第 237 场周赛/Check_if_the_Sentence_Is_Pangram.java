import org.junit.Test;

/**
 * @description:
 * 1832. 判断句子是否为全字母句
 * https://leetcode-cn.com/problems/check-if-the-sentence-is-pangram/
 * @author: hjx
 * @time: 2021年04月22日 18:48
 */
public class Check_if_the_Sentence_Is_Pangram {
    public boolean checkIfPangram(String sentence) {
        if (sentence.length()<26)
            return false;
        boolean[] flag = new boolean[26];
        int length = sentence.length();
        for (int i = 0; i < length; i++) {
            flag[sentence.charAt(i)-'a'] = true;
        }
        for (int i = 0; i < 26; i++) {
            if (!flag[i])
                return false ;
        }
        return true;
    }

    @Test
    public void test(){
        String sentence = "thequickbrownfoxjumpsoverthelazydog";
        System.out.println(checkIfPangram(sentence));
    }
}
