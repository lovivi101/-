/**
 * @description:
 * 938. 二叉搜索树的范围和
 * https://leetcode-cn.com/problems/range-sum-of-bst/
 * @author: hjx
 * @time: 2021年04月27日 8:30
 */
public class Range_Sum_of_BST {


    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
        }
    }

    public TreeNode CreateTree(int[] arr){

        TreeNode root = new TreeNode();

        for (int i = 0; i < arr.length; i++) {
            root.val = arr[i];
        }
        return root;
    }
    int sum = 0 ;
    public int rangeSumBST(TreeNode root, int low, int high) {

        sumDFS(root,low,high);

        return sum ;

    }

    public void sumDFS(TreeNode node , int low , int high){
        if (node==null){
            return;
        }
        if (node.val<=high&&node.val>=low){
            sum+=node.val;
        }
        sumDFS(node.left,low,high);
        sumDFS(node.right,low,high);
    }
}
