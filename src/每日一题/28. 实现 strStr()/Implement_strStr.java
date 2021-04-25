import org.junit.Test;

/**
 * @description:
 * 28. 实现 strStr()
 * https://leetcode-cn.com/problems/implement-strstr/
 * KMP:
 * https://leetcode-cn.com/problems/implement-strstr/solution/shi-xian-strstr-by-leetcode-solution-ds6y/
 * @author: hjx
 * @time: 2021年04月20日 10:16
 */
public class Implement_strStr {
    /*public int strStr(String haystack, String needle) {
        if (needle.length()==0)
            return 0;
        if (haystack.length()==0)
            return -1;
        int i , j ;
        i = j = 0;
        int count = -1 ;
        int length1 = haystack.length();
        int length2 = needle.length();
//        boolean[] flag = new boolean[length1] ;
        while (i<length1&&j<length2){
            if (haystack.charAt(i)!=needle.charAt(j)){
                j=0;
                if (count>=0)
                    i = count ;
                count = -1;
//                flag[count] = false ;
            }
            else {
                if (count==-1){
                    count = i;
//                    flag[count] = true;
                }
                if (j==length2-1){
                    return count;
                }
                j++;
            }
            i++;
        }
        return -1;
    }*/

//    KMP算法
//    KMP的经典思想就是:
//    当出现字符串不匹配时，可以记录一部分之前已经匹配的文本内容，利用这些信息避免从头再去做匹配。

    public int strStr(String haystack, String needle){
        int n = haystack.length(), m = needle.length();
        if (m == 0) {
            return 0;
        }
        int[] pi = new int[m];
        for (int i = 1, j = 0; i < m; i++) {
            while (j > 0 && needle.charAt(i) != needle.charAt(j)) {
                j = pi[j - 1];
            }
            if (needle.charAt(i) == needle.charAt(j)) {
                j++;
            }
            pi[i] = j;
        }
        for (int i = 0, j = 0; i < n; i++) {
            while (j > 0 && haystack.charAt(i) != needle.charAt(j)) {
                j = pi[j - 1];
            }
            if (haystack.charAt(i) == needle.charAt(j)) {
                j++;
            }
            if (j == m) {
                return i - m + 1;
            }
        }
        return -1;
    }

    @Test
    public void test(){
        String s1 = "mississippi";
        String s2 = "issip";
        System.out.println(strStr(s1,s2));
    }
}
