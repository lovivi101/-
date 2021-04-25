import org.junit.Test;

import java.util.*;

/**
 * @description:
 * 1817. 查找用户活跃分钟数
 * https://leetcode-cn.com/problems/finding-the-users-active-minutes/
 * @author: hjx
 * @time: 2021年04月05日 12:12
 */
public class Finding_the_Users_Active_Minutes {
    public int[] findingUsersActiveMinutes(int[][] logs, int k) {

        logs = Remove_repeat(logs);
        HashMap<Integer , Integer> map = new HashMap<>();
        for (int i = 0; i < logs.length; i++) {
            if (map.containsKey(logs[i][0]))
            {
                int count = map.get(logs[i][0]);
                count+=1;
                map.put(logs[i][0],count);
            }
            else {
                map.put(logs[i][0],1);
            }
        }
        System.out.println(map.toString());
        int[] arr = new int[k];
        for (int i = 0; i < k; i++) {/*System.out.println(map.get(i));*/
            if (map.containsValue(i)){
                arr[i-1]++;
            }
        }
        return arr;
    }

    public int[][] Remove_repeat(int[][] arr){
        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0]==o2[0])
                    return o1[1]-o2[1];
                return o1[0]-o2[0];
            }
        });

        int n = arr.length;
        for (int i = 1; i < n; i++) {
            if (arr[i][0]==arr[i-1][0]&&arr[i][1]==arr[i-1][1]){
                for (int j = i; j < n-1; j++) {
                    arr[j] = arr[j+1];
                }
                n--;
            }
        }
        System.out.println(Arrays.deepToString(arr));
        int[][] arr1 = new int[n][2];
        for (int i = 0; i < n; i++) {
            arr1[i]=arr[i];
        }
        System.out.println(Arrays.deepToString(arr1));
        return arr1;
    }

    @Test
    public void test(){

        System.out.println();
        int[][] arr = {{305589003,4136},{305589004,4139},{305589004,4141},{305589004,4137},{305589001,4139},{305589001,4139}};
        int[][] arr11 = Remove_repeat(arr);

        System.out.println(Arrays.deepToString(arr11));
//        System.out.println(arr.length+" " +arr[0]);
        int[] arr1 = findingUsersActiveMinutes(arr, 6);
        System.out.println(Arrays.toString(arr1));
    }
}
