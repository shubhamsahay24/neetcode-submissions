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
    public int kthSmallest(TreeNode root, int k) {
        
        Stack<TreeNode> st = new Stack<>();
        int count=0;
        while(root!=null || !st.isEmpty()) {
            if(root!=null) {
                st.push(root);
                root = root.left;
            } else {
                TreeNode temp = st.pop();
                count++;
                if(count==k)
                    return temp.val;
                root = temp.right;
            }
        }
        return -1;
    }

    private void inOrder(TreeNode root, List<Integer> list) {
        if(root==null) {
            return;
        }

        inOrder(root.left, list);
        list.add(root.val);
        inOrder(root.right, list);
    }
}
