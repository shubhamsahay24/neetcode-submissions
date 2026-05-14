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

    int ind=0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return constructTree(preorder, inorder, map, 0, preorder.length-1);
        
    }

    private TreeNode constructTree(int[] preorder, int[] inorder, Map<Integer, Integer> map, int l, int r) {

      /*  if(ind==preorder.length) {
            return null;
        } */
        if(l>r)
            return null;
        
        int root = preorder[ind++];
        int inorderInd = map.get(root);

        TreeNode left = constructTree(preorder, inorder, map, l, inorderInd-1);
        TreeNode right = constructTree(preorder, inorder, map, inorderInd+1, r);

        return new TreeNode(root, left, right);
    }
}
