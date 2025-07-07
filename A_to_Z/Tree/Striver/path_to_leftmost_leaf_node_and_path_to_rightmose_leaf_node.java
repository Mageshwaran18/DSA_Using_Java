package Tree.Striver;
import java.util.*;

/*
 * Path to leftmost leaf node -> I will start from the left and i will go only in the left side and end till reaching the leaf node.
 *                               I can go to right only if the cur node has no node in it's left and the current node is not a leaf node.
 * Path to rightmost leaf ndoe -> I will start from the right of the root node and i will go only in the right and end till reaching the leaf node.
 *                              I can go to left only if the cur node has no node in it's right and the current node is not a leaf node.
 */
public class path_to_leftmost_leaf_node_and_path_to_rightmose_leaf_node {
    
    static class TreeNode
    {
        int data;
        TreeNode left;
        TreeNode right;

        TreeNode(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public List<String> path_to_leftmost_leaf(TreeNode root)
    {
        List<String> ans = new ArrayList<>();
        TreeNode cur = root;
        while(cur!=null)
        {
            ans.add(new String(cur.data+"->"));
            if(cur.left!=null)
            {
                cur = cur.left;
            }
            else
            {
                cur = cur.right;
            }
        }
        return ans;
    }

    public List<String> path_to_rightmost_leaf(TreeNode root)
    {
        List<String> ans = new ArrayList<>();
        TreeNode cur = root;
        while(cur!=null)
        {
            ans.add(new String(cur.data+"->"));
            if(cur.right!=null)
            {
                cur = cur.right;
            }
            else
            {
                cur = cur.left;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        path_to_leftmost_leaf_node_and_path_to_rightmose_leaf_node solution = new path_to_leftmost_leaf_node_and_path_to_rightmose_leaf_node();
        // Create a sample tree
        //      1
        //    /   \
        //   2     3
        //  / \   / \
        // 4   5 6   7
        //      \      \
        //        9      10
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        root.left.right.right = new TreeNode(9);
        root.right.right.right = new TreeNode(10);


        // Get path to leftmost leaf
        List<String> leftPath = solution.path_to_leftmost_leaf(root);
        System.out.println("Path to leftmost leaf: " + String.join("", leftPath));

        // Get path to rightmost leaf
        List<String> rightPath = solution.path_to_rightmost_leaf(root);
        System.out.println("Path to rightmost leaf: " + String.join("", rightPath));
    }
}
