package Graph.Striver;

/* LeetCode :- 785 https://leetcode.com/problems/is-graph-bipartite/description/ */

/* In a disconnected graph if one graph is not bipartite , then the entire graph will not be a bipatite  */
/* 
 * T.C :-   O(V + E)
            Why?
            Each node is visited once → O(V)
            Each edge is visited twice (once from each endpoint) → O(E)
 * 
 */

public class bipartite {

    public static boolean dfs_helper(int i,int [][] graph,char par , char child , boolean[] visited , char[] clr)
    {
        clr[i]=child;
        visited[i]=true;
        for(int neigh : graph[i])
        {
            if(visited[neigh] && clr[neigh]==child)
            {
                return false;
            }
            else if(!visited[neigh])
            {
                if(!dfs_helper(neigh,graph,child,par,visited,clr))
                {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean bipartite(int[][] graph) {

        int n = graph.length;
        char [] clr = new char[n];
        boolean visited[] = new boolean[n];
        char par = 'r';
        char child = 'y';
        return dfs_helper(0,graph,par,child,visited,clr);
        
    }

    public static void main(String[] args) {
        int[][] graph = {{1,2,3},{0,2},{0,1,3},{0,2}};
        bipartite solution = new bipartite();
        boolean result = solution.bipartite(graph);
        System.out.println("Is the graph bipartite? " + result);
    }
}