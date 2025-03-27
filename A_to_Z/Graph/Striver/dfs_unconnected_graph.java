package Graph.Striver;

import java.util.ArrayList;

public class dfs_unconnected_graph {

    public static void helper(int parent , ArrayList<Integer> ans, boolean[] visited , ArrayList<ArrayList<Integer>> adj )
    {
            ans.add(parent);
            visited[parent]=true;
            for(int temp : adj.get(parent))
            {
                if(!visited[temp])
                {
                    helper(temp,ans,visited,adj);
                }
            }
    }
    // Function to return a list containing the DFS traversal of the graph.
    public static  ArrayList<Integer> dfsOfGraph(ArrayList<ArrayList<Integer>> adj) {
        
        ArrayList<Integer> ans = new ArrayList<>();
        boolean [] visited = new boolean[adj.size()];
        for(int i = 0 ; i < adj.size() ; i++)
        {
            if(!visited[i])
            {
                helper(i,ans,visited,adj);
            }
            
        }
        
        return ans;
    }
    
    public static void main(String[] args) {
        // Create a sample graph
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        
        // Add vertices
        for(int i = 0; i < 5; i++) {
            adj.add(new ArrayList<>());
        }

        // Add edges
        adj.get(0).add(1);
        adj.get(0).add(2);
        adj.get(1).add(0);
        adj.get(2).add(0);
        adj.get(4).add(3);
        adj.get(3).add(4);
        
        /* Graph representation:
         
            0 ---- 1
            |      
            |     
            2      3 -- 4

            
        */
        
        // Perform DFS
        ArrayList<Integer> result = dfsOfGraph(adj);
        
        // Print the DFS traversal
        System.out.println("DFS Traversal: " + result);
    }
}
