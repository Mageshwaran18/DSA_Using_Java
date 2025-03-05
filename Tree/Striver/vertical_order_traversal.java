package Tree.Striver;
import java.util.*;

/* LeetCode:- 987 https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree/ */

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

        TreeMap<Integer,TreeMap<Integer,ArrayList<Integer>>> tm = new TreeMap<>();
        Queue<iPair> q = new LinkedList<>();
        q.add(new iPair(0,root,0));
        while(!q.isEmpty())
        {
            iPair poped = q.poll();
            int cur_length = poped.length;
            int cur_vertical_line = poped.vertical_line;
            TreeNode cur_node = poped.node;

            tm.computeIfAbsent(cur_vertical_line,k-> new TreeMap<>())
              .computeIfAbsent(cur_length,k->new ArrayList<>())
              .add(cur_node.val);
            
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
                Collections.sort(cur_len_nodes);
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