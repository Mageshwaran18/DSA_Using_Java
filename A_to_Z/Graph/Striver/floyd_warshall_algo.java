package Graph.Striver;
import java.util.*;

/* GFG :- https://www.geeksforgeeks.org/problems/implementing-floyd-warshall2042/1 */
/* Refer the DSA notes */

class floyd_warshall_algo
{
    public static void shortestDistance(int[][] dp) {
        
        int n = dp.length;
        
        for(int i = 0 ; i < n ; i++)
        {
            for(int j = 0 ; j < n ; j++)
            {
                if(dp[i][j]==-1)
                {
                    dp[i][j]=(int)1e9;
                }
            }
        }
        
        for(int k = 0 ; k < n ; k++)
        {
            for(int i = 0 ; i < n ; i++)
            {
                for(int j = 0 ; j < n ; j++)
                {
                    dp[i][j]=Math.min(dp[i][k]+dp[k][j],dp[i][j]);
                }
            }
        }
        
        // to detect the negative cycles in the given graph
        for(int i = 0 ; i < n ; i++)
        {
            if(dp[i][i]<0)
            {
                System.out.println("We have found a negative cycle");
                return ;
            }
        }
        
        
        for(int i = 0 ; i < n ; i++)
        {
            for(int j = 0 ; j < n ; j++)
            {
                if(dp[i][j]==1e9)
                {
                    dp[i][j]=-1;
                }
            }
        }
        
        return ;
    }

    public static void main(String[] args) {
        // Example graph represented as adjacency matrix
        int[][] graph = {
            {0, -1, 4, -1},
            {-1, 0, 3, -1},
            {-1, -1, 0, 1},
            {-1, 2, -1, 0}
        };
        
        shortestDistance(graph);
    }
}
