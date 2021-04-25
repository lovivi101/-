/**
 * @description:
 * @author: hjx
 * @time: 2021年03月18日 22:05
 */



public class Reverse_Linked_List_II {
    public static void main(String[] args) {

    }
    public ListNode reverseBetween(ListNode head, int left, int right) {
        int length = Length_List(head);
        int[] arr = new int[length];
        for(int i = 0 ; i <length ; i++){
            if(i>=left-1&&i<=right-1){
                arr[length-i] = head.val;
            }
            else{
                arr[i] = head.val;
            }
            head = head.next;
        }
        ListNode node = new ListNode();
        ListNode node1 = node;
        for(int i=0; i<arr.length-1; i++){
            node1 = new ListNode(arr[i]);
            node1 = node1.next;
        }
        return node ;
    }
    public int Length_List(ListNode list){
        int length = 0;
        while(list!=null){
            length++;
            list = list.next;
        }
        return length;
    }
}
class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}