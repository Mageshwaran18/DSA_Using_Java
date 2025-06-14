package Tree;
/* LeetCode :- 124 https://leetcode.com/problems/binary-tree-maximum-path-sum/*/

// [YOU]

/*
 * Finds the maximum path sum in a binary tree using a modified Kadane's algorithm approach.
 * Similar to finding diameter, we consider paths that can split at any node.
 * 
 * Intuition:
 * 1. At each node, we have two choices:
 *    a) Include the node in the path and continue either left or right (for parent's path)
 *    b) Use the node as the root of a new path (combining left + node + right)
 * 
 * 2. For each node we track:
 *    - Maximum path sum through current node (left + node + right)
 *    - Maximum path sum ending at current node (max(left, right) + node)
 * 
 * 3. Similar to Kadane's, we ignore negative sums by using Math.max(0, sum)
 * 
 * Time Complexity: O(n) where n is number of nodes
 * Space Complexity: O(h) where h is height of tree (recursion stack)
*/


public class maximum_path_sum {

    static class TreeNode {
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

    
    public static int solver(TreeNode root, int[] ans) {
        if(root == null) {
            return 0;
        }

        // Get maximum path sum from left and right subtrees
        // If path sum is negative, we ignore it (similar to Kadane's)
        int right = Math.max(0, solver(root.right, ans));
        int left = Math.max(0, solver(root.left, ans));

        // Current path sum including split at current node
        int cur_node_sum = left + right + root.val;

        // Update global maximum (handles split paths)
        ans[0] = Math.max(ans[0], cur_node_sum);

        // Return maximum path sum ending at current node
        // (can only choose one path for parent nodes)
        return Math.max(right, left) + root.val;
    }

    /**
     * Main function to find maximum path sum in binary tree
     * Uses a single element array to track global maximum
     */
    public static int maxPathSum(TreeNode root) {
        int ans[] = new int[1];
        ans[0] = root.val;
        solver(root, ans);
        return ans[0];
    }
    public static void main(String[] args) {
        /*
                     10
                    /  \
                   2    10
                  / \     \
                20   1    -25
                          /  \
                         3    4
        */
        // Create a sample binary tree
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(2);
        root.right = new TreeNode(10);
        root.left.left = new TreeNode(20);
        root.left.right = new TreeNode(1);
        root.right.right = new TreeNode(-25);
        root.right.right.left = new TreeNode(3);
        root.right.right.right = new TreeNode(4);
        
        // Find maximum path sum
        int result = maxPathSum(root);
        System.out.println("Maximum path sum is: " + result);
    }
    
}