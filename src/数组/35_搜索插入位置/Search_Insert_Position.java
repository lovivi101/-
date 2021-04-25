import org.junit.Test;

import java.util.Scanner;

/**
 * @description:
 * @author: hjx
 * @time: 2021年03月23日 13:55
 */
public class Search_Insert_Position {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("target :");
            int target = scanner.nextInt();
            int[] arr = {1,3,5,7,9,11,13};
            System.out.println(SearchInsert1(arr, target));
        }
    }


    public static int SearchInsert1(int[] nums , int target){
        int length = nums.length;
        int right = 0 ;
        int left = length-1;
        int mid = (right+left)/2;
        int ans = 0;
        while(right<=left){
/*          System.out.println("right:"+right+" left:"+left);
            System.out.println("mid:"+mid+" :" +"nums[mid]:"+nums[mid]);
            */
            mid = (right+left)/2;
            if (nums[mid]<=target){
                ans = mid ;
                right =  mid+1 ;
            }
            else {
                left = mid -1 ;
            }
        }
        return ans ;
    }

/*    @Test
    public void test(){
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("target :");
            int target = scanner.nextInt();
            int m = scanner.nextInt();
            int[] arr = new int[m];

            for (int i = 0; i < m; i++) {
                arr[i] = scanner.nextInt();
            }
            System.out.println(searchInsert(arr, target));
        }
    }*/
}
