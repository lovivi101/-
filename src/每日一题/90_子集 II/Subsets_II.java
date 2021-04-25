import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @description:
 * @author: hjx
 * @time: 2021年03月31日 8:33
 */
public class Subsets_II {
    List<List<Integer>> list1 = new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<Integer> list2 = new ArrayList<>();
        Arrays.sort(nums);
        dfs1(true , 0 ,nums , list2 );
        return list1;
    }


//    使用深度搜索
    public void dfs1(boolean flag , int cur , int[] arr , List<Integer> list2){
        if (cur==arr.length) {

            list1.add(new ArrayList<>(list2));
            return;
        }
        dfs1(true , cur+1 , arr,list2);

        if (flag&&cur>0&&(arr[cur-1]==arr[cur])){
            return;
        }
        list2.add(arr[cur]);
        dfs1(false , cur+1 , arr , list2);
        list2.remove(list2.size()-1);
    }

//    n << 1 相当于乘以2
//    n >> 1 相当于除以2
//    1 << n 相当于乘以2的n次方
//    1 >> n 相当于除以2的n次方
    @Test
    public void test(){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i]= scanner.nextInt();
        }
        System.out.println(subsetsWithDup(arr).toString());
    }
}
