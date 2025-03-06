package Graph.Striver;
import java.util.*;

/* GFG :- https://www.geeksforgeeks.org/problems/shortest-path-in-undirected-graph/1 */
/* It simply the dijikstra algo but the input is in the different format change that into required format  */

/* Required format for the dijikstra to be applied [ [[node1,weight1],[node2,weight2]] --> 0 , [[node3,weight3],[node4,weight4]]--> 1 ] 
*  0---> the node and it's weight attached to the node 0 
*  1---> the node and it's weight attached to the node 1
*/




class shortest_path_in_directed_graph
{


    static class iPair
    {
        int node;
        int we;
        
        iPair(int node,int we)
        {
            this.we=we;
            this.node=node;
        }
    }

    public static  int[] shortestPath(int V, int E, int[][] edges) {
        
        
        int ans [] = new int[V];
        boolean visited[] = new boolean[V];
        HashMap<Integer,ArrayList<ArrayList<Integer>>> adj = new HashMap<>();
        PriorityQueue<iPair> q = new PriorityQueue<>((a,b)->a.we-b.we);
        for(int i  = 0 ;i < E ; i++)
        {
            ArrayList<Integer> edge = new ArrayList<>();
            edge.add(edges[i][1]);
            edge.add(edges[i][2]);
            adj.computeIfAbsent(edges[i][0],k-> new ArrayList<>()).add(edge);
            
        }
        Arrays.fill(ans,-1);
        ans[0]=0;
        q.add(new iPair(0,0));
        while(!q.isEmpty())
        {
            iPair poped = q.poll();
            int cur_no = poped.node;
            int cur_we = poped.we;
            visited[cur_no]=true;
            if(adj.containsKey(cur_no))
            {
                for(ArrayList<Integer> neigh : adj.get(cur_no))
                {
                    int neigh_no = neigh.get(0);
                    int neigh_we = neigh.get(1);
                    if(!visited[neigh_no])
                    {
                        int total = neigh_we+cur_we;
                        if(ans[neigh_no]==-1 || total < ans[neigh_no])
                        {
                            ans[neigh_no]=total;
                            q.add(new iPair(neigh_no,total));
                        }
                    }
                }
            }
        }
        
        return ans;
    }
    
    public static void main(String[] args) {
        int V = 6;
        int E = 7;
            /*
            Graphical representation of the directed weighted graph:

           2
       1 -----> 2
       ^        | \
       |        |  \ 3
     2 |        | 6 \
       |     2  |    v
       0 -----> 4 --> 5
         \      ^     |
                  \     |     |
           1    4     1
                    \   |     |
             v  |     v
                      4 ------ 3

            */
                    int[][] edges = {{0,1,2}, {0,4,1}, {4,5,4}, {4,2,2}, {1,2,3}, {2,3,6}, {5,3,1}};
        int[] result = shortestPath(V, E, edges);
        System.out.println(Arrays.toString(result));     
    }
}