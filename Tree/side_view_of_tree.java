package Tree;
import java.util.*;

/* LeetCode :- 199 https://leetcode.com/problems/binary-tree-right-side-view/ */

class side_view_of_tree
{

    public class TreeNode {
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
    public static List<Integer> rightSideView(TreeNode root) {

        List<Integer> res = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        if(root!=null)
        {
            q.add(root);
        }
        else
        {
            return res;
        }
        while(!q.isEmpty())
        {
            int l_size = q.size();
            for(int i = 0 ; i < l_size;i++)
            {
                TreeNode node =q.poll();
                if(node.left!=null)
                {
                    q.add(node.left);
                }
                if(node.right!=null)
                {
                    q.add(node.right);
                }
                if(i==l_size-1)
                {
                    res.add(node.val);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        side_view_of_tree tree = new side_view_of_tree();
        TreeNode root = tree.new TreeNode(1);
        root.left = tree.new TreeNode(2);
        root.right = tree.new TreeNode(3);
        root.left.right = tree.new TreeNode(5);
        root.right.right = tree.new TreeNode(4);
        
        List<Integer> result = rightSideView(root);
        System.out.println("Right side view of the tree: " + result);
    }
}