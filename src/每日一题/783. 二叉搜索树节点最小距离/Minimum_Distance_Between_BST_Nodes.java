import org.junit.Test;

/**
 * @description:
 *783. 二叉搜索树节点最小距离
 * https://leetcode-cn.com/problems/minimum-distance-between-bst-nodes/
 *
 * 根据二叉搜素树的性质
 * 二叉查找树的性质：
 *
 * 1.左子树上所有结点的值均小于或等于它的根结点的值。
 *
 * 2.右子树上所有结点的值均大于或等于它的根结点的值。
 *
 * 3.左、右子树也分别为二叉排序树。
 * @author: hjx
 * @time: 2021年04月13日 10:20
 */
public class Minimum_Distance_Between_BST_Nodes {
    int min;
    public int minDiffInBST(TreeNode root) {
        min = Integer.MAX_VALUE;
        BFS(root);
        return min;
    }
    public void BFS(TreeNode node ){
        if (node.left==null&&node.right==null)
            return;
        else if (node.left==null){
            min = Math.min(node.right.val - node.val, min);
            BFS(node.right);
        }
        else if (node.right==null){
            min = Math.min(node.left.val - node.val, min);
            BFS(node.left);
        }
        else {
            min = Math.min(Math.min(node.val - node.left.val, node.right.val - node.val), min);
            BFS(node.left);
            BFS(node.right);
        }

    }

    @Test
    public void test(){
        int[] arr = {1,0,48, Integer.parseInt(null), Integer.parseInt(null),12,49};
        TreeNode root = new TreeNode();
        root.Create_Tree(arr);



        System.out.println(minDiffInBST(root));
    }
}

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
     void Create_Tree(int[] arr){

         for (int i : arr) {
             addNode(i);
         }
     }
     void addNode(int num){
         if (num < this.val) {
             if (this.left != null) {
                 this.left.addNode(num);
             } else {
                 this.left = new TreeNode(num);
             }
             return;
         }

         if (this.right != null) {
             this.right.addNode(num);
         } else {
             this.right = new TreeNode(num);
         }
         return;
     }
  }