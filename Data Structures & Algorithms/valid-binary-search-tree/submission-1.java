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
    public boolean isValidBST(TreeNode root) {
        
        return isValid(root, -1001, 1001);
    }

    // maintaining range [-1001, 1001]
    private boolean isValid(TreeNode root, int min, int max) {
        
        if(root==null)
            return true;

        if(!(root.val > min && root.val < max)) {
            return false;
        }

        boolean left = isValid(root.left, min, root.val);
        boolean right = isValid(root.right, root.val, max);

        return left && right;
    }
}
