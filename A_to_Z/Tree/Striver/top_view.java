package Tree.Striver;

/* Refer DSA notes https://www.geeksforgeeks.org/problems/top-view-of-binary-tree/1 */

import java.util.*;

public class top_view {

    static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
            left=null;
            right=null;
        }
    }

    static class Pair{

        int ve_li ;
        Node node;

        Pair(int ve_li,Node node)
        {
            this.ve_li=ve_li;
            this.node=node;
        }

    }

    public static ArrayList<Integer> topView(Node root) {
        
        ArrayList<Integer> ans = new ArrayList<>();
        Queue<Pair> q = new LinkedList<>();
        TreeMap<Integer,Integer> tm  = new TreeMap<>();
        q.add(new Pair(0,root));
        tm.put(0,root.data);
        while(!q.isEmpty())
        {
            Pair cur = q.poll();
            int cur_ver = cur.ve_li;
            Node cur_nod = cur.node;
            if(cur_nod.left!=null)
            {
                int new_ver = cur_ver -1;
                if(!tm.containsKey(new_ver))
                {
                    tm.put(new_ver,cur_nod.left.data);
                }
                q.add(new Pair(new_ver,cur_nod.left));
            }
            if(cur_nod.right!=null)
            {
                int new_ver = cur_ver + 1;
                if(!tm.containsKey(new_ver))
                {
                    tm.put(new_ver,cur_nod.right.data);
                }
                q.add(new Pair(new_ver,cur_nod.right));
            }
        }

        for(Map.Entry<Integer,Integer> entry : tm.entrySet())
        {
            ans.add(entry.getValue());
        }
        return ans;
        
    }
    
    public static void main(String[] args) {
        // Create a sample binary tree
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.right = new Node(4);
        root.left.right.right = new Node(5);
        root.right.left = new Node(6);
        
        // Get the top view of the tree
        ArrayList<Integer> result = topView(root);
        
        // Print the result
        System.out.println("Top view of the binary tree: " + result);
    }
}
