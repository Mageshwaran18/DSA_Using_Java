package Tree;

/* LeetCode :- 543 https://leetcode.com/problems/diameter-of-binary-tree/ */

/* The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root. */

// [ YOU ]

/*
 * Optimal Solution :- --> The longest path that could be possible between two nodes will be the node which is high in depth in left part and high in depth in right
 *                     --> In every node calculate the left depth and right depth and that can be the maximum depth too.
 *                     --> Just visualize it you can understand it easier.
 *                     --> T.C :- O ( V ) --> The number of vertices in the given tree.
 *                     --> S.C :- O ( 1 ).
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    
    TreeNode() {}
    
    TreeNode(int val) {
        this.val = val;
    }
    
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class diameter_of_a_tree {
    
    public static int solver(TreeNode root, int[] ans) {
        if (root == null) {
            return 0;
        }

        int left = solver(root.left, ans);
        int right = solver(root.right, ans);

        ans[0] = Math.max(ans[0], left + right);  
        return Math.max(left, right) + 1;
    }

    
    public static int  diameter_of_a_tree(TreeNode root)
    {
        int[] ans = new int[1]; 
        solver(root, ans);
        return ans[0];
    }
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        
        System.out.println("Diameter of the tree is: " + diameter_of_a_tree(root));
    }
}
