import org.junit.Test;

import java.util.ArrayList;

/**
 * @description:
 * 897. 递增顺序搜索树
 * https://leetcode-cn.com/problems/increasing-order-search-tree/
 * @author: hjx
 * @time: 2021年04月25日 8:37
 */
public class Increasing_Order_Search_Tree {
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
    ArrayList<Integer> arr = new ArrayList<>();
    public TreeNode increasingBST(TreeNode root) {
        MIdlle(root);
        TreeNode head = new TreeNode(0);
        TreeNode treeNode = head;

        for (int i = 1; i < arr.size(); i++) {
//            TreeNode left = null;
            TreeNode right = new TreeNode(arr.get(i).intValue());
//            TreeNode treeNode1 = new TreeNode(arr.get(0).intValue() , left , right);
            treeNode.right = right;
            treeNode = treeNode.right;
        }
        return head.right;
    }
    public void MIdlle(TreeNode root){
        if (root==null)
            return;
        MIdlle(root.left);
        arr.add(root.val);
        MIdlle(root.right);
    }

    @Test
    public void test(){

    }
}


