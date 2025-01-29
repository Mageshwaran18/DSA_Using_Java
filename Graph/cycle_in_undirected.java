package Graph;

import java.util.ArrayList;

public class cycle_in_undirected {

    public static boolean dfs(int cur , int parent , ArrayList<ArrayList<Integer>> adj,boolean visited[])
    {
        visited[cur] = true;
        for(int node: adj.get(cur))
        {
            if(!visited[node])
            {
                if(dfs(node,cur,adj,visited))
                {
                    return true;
                }
            }
            else if(node!=parent)
            {
                return true;
            }
        }
        return false;
    }


    public static boolean cycle_in_undirected(ArrayList<ArrayList<Integer>> adj)
    {
        int n = adj.size();
        boolean visited[] = new boolean[n];
        for(int i = 0 ;i < n ; i++) // to avoid if there is two unconnected graphs were given 
        {
            if(!visited[i])
            {
                if(dfs(i,-1,adj,visited))
                {
                    return true;
                }
            }
        }
        return false;
    }

    
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int numVertices = 5;
        for (int i = 0; i < numVertices; i++) {
            adj.add(new ArrayList<>());
        }

        // Add edges to the graph
        // Graph structure:
        // 0 - 1 - 2
        //     |   |
        //     4 - 3
        adj.get(0).add(1);
        adj.get(1).add(0);
        adj.get(1).add(2);
        adj.get(2).add(1);
        adj.get(2).add(3);
        adj.get(3).add(2);
        adj.get(3).add(4);
        adj.get(4).add(3);
        adj.get(4).add(1); // This edge creates a cycle
        adj.get(1).add(4);

        // Check if the graph contains a cycle
        boolean hasCycle = cycle_in_undirected(adj);
        System.out.println("The graph contains a cycle: " + hasCycle);
        }
    
}