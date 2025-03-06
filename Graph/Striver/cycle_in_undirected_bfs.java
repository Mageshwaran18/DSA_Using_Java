package Graph.Striver;
import java.util.*;


/* GFG :-  https://www.geeksforgeeks.org/problems/detect-cycle-in-an-undirected-graph/1 */


/* The same logic of DFS used for detecting the cycle is used in BFS 
 * 
 *  If the neighbour of the node is visited and it's not the parent of the node ,
 *  then it means there is a cycle detected.
 * 
 */

public class cycle_in_undirected_bfs {

        class pair 
    {
        int par;
        int node;
        
        pair(int par,int node)
        {
            this.par = par;
            this.node = node;
        }
        
    }
    
    public boolean bfs_helper(ArrayList<ArrayList<Integer>> adj,Queue<pair> q, boolean[] visited)
    {
        while(!q.isEmpty())
        {
            pair temp = q.poll();
            int par = temp.par;
            int node = temp.node;
            if(visited[node])
            {
                continue;
            }
            else
            {
                visited[node]=true;
                for(int neigh : adj.get(node))
                {
                    if(!visited[neigh])
                    {
                        q.add(new pair(node,neigh));
                    }
                    else if(neigh!=par)
                    {
                        return true;
                    }
                }
            }
        }
        
        return false;
    }
    
    
    public boolean isCycle(ArrayList<ArrayList<Integer>> adj) {
        
        Queue<pair> q = new LinkedList<>();
        boolean visited [] = new boolean[adj.size()];
        cycle_in_undirected_bfs obj = new cycle_in_undirected_bfs();

        // The loop is to handle the unconnected graphs too

        for(int i = 0 ; i < adj.size() ; i++)
        {
            if(!visited[i])
            {
                q.add(new pair(-1,i));
                if(obj.bfs_helper(adj,q,visited))
                {
                    return true;
                }
            }
            q.clear();
        }
        
        return false;
    }
    
    public static void main(String[] args) {
        cycle_in_undirected_bfs graph = new cycle_in_undirected_bfs();
        
        // Create sample adjacency list
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int V = 5; // number of vertices
        
        for(int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        
        // Add edges
             /* Graph structure:
              0 --- 1 ----2
                    |     |
                    |     |
                    4 --- 3
        
                This creates a cycle: 1-2-3-4-1
             */
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
        boolean hasCycle = graph.isCycle(adj);
        System.out.println("Does the graph contain a cycle? " + hasCycle);
    }
    
}
