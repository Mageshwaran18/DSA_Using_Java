package Dynamic_Programming;
import java.util.*;

/* LeetCode:- 62 https://leetcode.com/problems/unique-paths/description/ */
/* Refer DSA notes */

class unique_path
{
    public static int uniquePaths(int r, int c) {
        
        int dp[][] = new int[r][c];
        for(int i = 0 ; i < r ; i++)
        {
            dp[i][0]=1;
        }
        for(int i = 0 ; i < c ; i++)
        {
            dp[0][i]=1;
        }

        for(int i = 1 ; i < r ; i++)
        {
            for(int j = 1 ; j < c ; j++)
            {
                dp[i][j] = dp[i-1][j];
                dp[i][j] += dp[i][j-1];
            }
        }

        return dp[r-1][c-1];

    }

    public static void main(String[] args) {
        int rows = 3;
        int columns = 7;
        int result = uniquePaths(rows, columns);
        System.out.println("Number of unique paths: " + result);
    }
}