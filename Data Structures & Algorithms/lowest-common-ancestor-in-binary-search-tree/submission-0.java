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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        // If root itself is one of those other nodes, then this is the LCA
        if(root.val==p.val || root.val==q.val)
            return root;
        
        // If p & q both are wither sides of root node 
        // (i.e) root lies in between of p & q, then root is LCA.
        if(root.val > p.val && root.val < q.val)
            return root;
        if(root.val > q.val && root.val < p.val)
            return root;
        
        // If p & q lies at one sub-tree only (either left or right)
        // then go in that subtree.
        if(root.val > p.val && root.val > q.val) {
            return lowestCommonAncestor(root.left, p, q);
        } else {
            return lowestCommonAncestor(root.right, p, q);
        }
    }
}
