package Tree;
/*LeetCode :- 112 https://leetcode.com/problems/path-sum/description/ */

/* [ YOU ] */

/*
 *  Optimal approach :- --> It's most similar to the maximum path sum.
 *                      --> T.C :- O ( N )
 *                      --> S.C :- O ( 1 )
 *                          
 */


public class path_sum {

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

    public static boolean helper(TreeNode root,int target,int sum)
    {
        if(root==null)
        {
            return false;
        }
        else if(root.left==null && root.right==null)
        {
            if(sum+root.val==target)
            {
                
                return true;
            }
            else
            {
                return false;
            }
        }
        boolean right[] = new boolean[1];
        right[0]=false;
        boolean left[] = new boolean[1];
        left[0]=false;
        if(root.left!=null)
        {
            left[0] = helper(root.left,target,sum+root.val);
        }
        if(root.right!=null)
        {
            right[0] = helper(root.right,target,sum+root.val);
        }
        return left[0] || right[0];
    }
    public static boolean hasPathSum(TreeNode root, int targetSum) {
        return helper(root,targetSum,0);
    }
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.left.right = null;
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right.right.right = new TreeNode(1);
        
        System.out.println(hasPathSum(root, 22));
    }

    
}
