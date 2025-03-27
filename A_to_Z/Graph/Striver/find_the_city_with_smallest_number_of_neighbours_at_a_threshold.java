package Graph.Striver;
import java.util.*;

/* LeetCode :- 1334 https://leetcode.com/problems/find-the-city-with-the-smallest-number-of-neighbors-at-a-threshold-distance/description/ */

/* My appraoch :- A complete application of floyd warshall algo will work and to return the answer make some changes */

public class find_the_city_with_smallest_number_of_neighbours_at_a_threshold {

        public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int dp[][] = new int[n][n];
        for(int temp[] : edges)
        {
            dp[temp[0]][temp[1]]=temp[2];
            dp[temp[1]][temp[0]]=temp[2];
        }
        for(int i = 0 ; i < n ; i++)
        {
            for(int j = 0 ; j < n ; j++)
            {
                if(dp[i][j]==0)
                {
                    dp[i][j]=(int)1e9;
                }
            }
            dp[i][i]=0;
        }
        for(int k = 0 ; k < n ; k++)
        {
            for(int i = 0 ; i < n ; i++)
            {
                for(int j = 0 ; j < n ; j++)
                {
                    dp[i][j]=Math.min(dp[i][j],dp[i][k]+dp[k][j]);
                }
            }
        }
        
        for(int i = 0 ; i < n ; i++)
        {
            System.out.println(Arrays.toString(dp[i]));
        }

        int arr[] = new int[n];
        for(int i = 0 ; i < n ; i++)
        {
            for(int j = 0 ; j < n ; j++)
            {
                if(dp[i][j]<=distanceThreshold)
                {
                    arr[i]++;
                }
            }
        }
        int nc = arr[0];
        int ans = 0;
        for(int i = 1 ; i < n ; i++)
        {
            if(arr[i]<nc)
            {
                ans = i;
                nc = arr[i];
            }
            else if(arr[i]==nc)
            {
                ans = Math.max(ans,i);
            }
        }
        return ans;
    }
    
}
