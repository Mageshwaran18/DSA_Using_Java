package Graph.Striver;
import java.util.*;


/* GFG :- https://www.geeksforgeeks.org/problems/distance-from-the-source-bellman-ford-algorithm/1 */

/* Refer the DSA notes */

class bellman_ford_algo
{
    static int[] bellmanFord(int V, int[][] edges, int src) {
    
        int dis[] = new int[V];
        Arrays.fill(dis,(int)1e8);
        dis[src]=0;
        for(int i = 0 ; i < V-1 ; i++)
        {
            for(int temp[] : edges)
            {
                int par = temp[0];
                int chi = temp[1];
                int wei = temp[2];
                
                // We want to check whether the parent is being updated or not
                
                // The condition dis[par] != (int)1e8 is necessary 
                // to ensure that we are only trying to relax edges from nodes that have already been reached.

                // if no relaxation is given then it would look like this,
                /*
                   if(dis[par]+wei<dis[chi]) --> 1e8 + 10 will lead to integer overflow and that causes the false updation in the weight.
                    {
                        dis[chi]=dis[par]+wei;
                    }
                 */
                if(dis[par]!= 1e8 && dis[par]+wei<dis[chi])
                {
                    dis[chi]=dis[par]+wei;
                }
            }
        }
        
         for(int temp[] : edges)
            {
                int par = temp[0];
                int chi = temp[1];
                int wei = temp[2];

                /*
                 * Relax edges from the node that are already reached.
                 */
                
                if(dis[par]!= 1e8 && dis[par]+wei<dis[chi])
                {
                    int neg_cycle[] = new int[1];
                    neg_cycle[0] = -1;
                    return neg_cycle;
                }
            }
        
        return dis;
    }
}
