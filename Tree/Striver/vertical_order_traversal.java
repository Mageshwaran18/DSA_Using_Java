package Tree.Striver;
import java.util.*;

/* LeetCode:- 987 https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree/ */

/*
 * It's more related to top view of the tree but in the top view of the tree only the first occuring digit of the vertical distance is added
 * But here we will add all the nodes in that vertical line.
 * 
 * Note :- If two nodes are in the same vertical line and same vertical level , then store them in the sorted manner .
 * 
 * 
 */

public class vertical_order_traversal {

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

    static class iPair
    {
        int vertical_line;
        int length;
        TreeNode node ;

        iPair(int vertical_line,TreeNode node,int length)
        {
            this.vertical_line=vertical_line;
            this.node = node;
            this.length=length;
        }
    }



    public static List<List<Integer>> verticalTraversal(TreeNode root) {

        // if required refer 5.3.25 dates ( if needed )

        // {vertical line ={level = { nodes }}
        // {3rd vertical line = { 4th level = { 4,5,6 } }} --> Nodes in the same level and vertical line and they were sorted 
        TreeMap<Integer,TreeMap<Integer,ArrayList<Integer>>> tm = new TreeMap<>();
        Queue<iPair> q = new LinkedList<>();
        q.add(new iPair(0,root,0));
        while(!q.isEmpty())
        {
            iPair poped = q.poll();
            int cur_length = poped.length;
            int cur_vertical_line = poped.vertical_line;
            TreeNode cur_node = poped.node;

            // Search the key , if the key is not found then perform the lambda function . 
            // Else return the value for that key 

            tm.computeIfAbsent(cur_vertical_line,k-> new TreeMap<>())// create level
              .computeIfAbsent(cur_length,k->new ArrayList<>())// create arraylist for that level 
              .add(cur_node.val);// add it to the arraylist of that level 
            
            if(cur_node.left!=null)
            {
                q.add(new iPair(cur_vertical_line-1,cur_node.left,cur_length+1));
            }
            if(cur_node.right!=null)
            {
                q.add(new iPair(cur_vertical_line+1,cur_node.right,cur_length+1));
            }
        }

        List<List<Integer>> ans = new ArrayList<>();
        for(Map.Entry<Integer,TreeMap<Integer,ArrayList<Integer>>> entry1 : tm.entrySet())
        {
            TreeMap<Integer,ArrayList<Integer>> cur_ver_nodes = entry1.getValue();
            List<Integer> temp = new ArrayList<>();
            for(Map.Entry<Integer,ArrayList<Integer>> entry2 : cur_ver_nodes.entrySet())
            {
                ArrayList<Integer> cur_len_nodes = entry2.getValue();
                Collections.sort(cur_len_nodes); // Sort the nodes in that level 
                temp.addAll(cur_len_nodes);
            }
            ans.add(new ArrayList<>(temp));
        }

        return ans;
    }

    public static void main(String[] args) {
        vertical_order_traversal solution = new vertical_order_traversal();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        List<List<Integer>> result = verticalTraversal(root);
        System.out.println("Vertical Order Traversal: " + result);
    }
}