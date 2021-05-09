import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @description:5750. 人口最多的年份
 * 给你一个二维整数数组 logs ，其中每个 logs[i] = [birthi, deathi] 表示第 i 个人的出生和死亡年份。
 *
 * 年份 x 的 人口 定义为这一年期间活着的人的数目。第 i 个人被计入年份 x 的人口需要满足：x 在闭区间 [birthi, deathi - 1] 内。注意，人不应当计入他们死亡当年的人口中。
 *
 * 返回 人口最多 且 最早 的年份。
 *
 *
 *
 * 示例 1：
 *
 * 输入：logs = [[1993,1999],[2000,2010]]
 * 输出：1993
 * 解释：人口最多为 1 ，而 1993 是人口为 1 的最早年份。
 * 示例 2：
 *
 * 输入：logs = [[1950,1961],[1960,1971],[1970,1981]]
 * 输出：1960
 * 解释：
 * 人口最多为 2 ，分别出现在 1960 和 1970 。
 * 其中最早年份是 1960 。
 * @author: hjx
 * @time: 2021年05月09日 10:34
 */
public class Maximum_Population_Year {
    public int maximumPopulation(int[][] logs) {

        /*//暴力算法
        int temp = 0 ;
        int MaxYear = 0;
        for (int i = 1950; i <= 2050; i++) {
            int count = 0;
            for (int[] log : logs) {
                if (i>=log[0]&&i<log[1]){
                    count++;
                }
            }
            if (count>temp){
                MaxYear = i;
                temp = count;
            }
        }
        return MaxYear;*/

        //差分数组
        int[] arr = new int[101];
        for (int[] log : logs) {
            arr[log[0]-1950]++;
            arr[log[1]-1950]--;
        }
        int count = 0;
        int temp = 0 ;
        int MinYear = 0;
        for (int i = 1 ; i<=100 ; i++){
            count+=arr[i];
            if (count>temp){
                temp = count;
                MinYear = i ;
            }
        }
        return MinYear+1950;
    }


    @Test
    public void test(){
        int[][] logs = {{1950, 1961},{
            1960, 1971
        },{
            1970, 1981
        }};
        System.out.println(maximumPopulation(logs));
    }

}
