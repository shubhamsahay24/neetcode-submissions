/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {  
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {

        StringBuilder sb1 = new StringBuilder();
        preOrder(root, sb1);
        StringBuilder sb2 = new StringBuilder();
        preOrder(subRoot, sb2);
      //  System.out.println(sb1.toString());
       // System.out.println(sb2.toString());
        return sb1.toString().contains(sb2.toString());
    }

// 
    private void preOrder(TreeNode root, StringBuilder sb) {
        if(root==null) {
            sb.append("#");
            return;
        }
        sb.append(root.val);
        preOrder(root.left, sb);
        preOrder(root.right, sb);
    }
}
