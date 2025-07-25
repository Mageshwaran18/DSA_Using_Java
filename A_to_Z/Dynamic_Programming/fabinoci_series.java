package Dynamic_Programming;
import java.util.*;
public class fabinoci_series {

    public static int fabinoci_series_recursion(int n)
    {
        if(n<=1)
        {
            return 0;
        }
        else if(n==2)
        {
            return 1;
        }

        return fabinoci_series_recursion(n-1)+fabinoci_series_recursion(n-2);
    }

    public static int  fabinoci_series_memoization(int n , int [] memo)
    {
        if(n<=1)
        {
            memo[n] = 0;
            return 0;
        }
        
        else if(n==2)
        {
            memo[n] = 1;
            return 1;
        }

        else if(memo[n]!=0)
        {
            return memo[n];
        }

        int res = fabinoci_series_memoization(n-1,memo)+fabinoci_series_memoization(n-2,memo);
        memo[n] = res;
        return res;
    }

    public static int fabinoci_series_tabulation(int n)
    {
        int dp[] = new int[n+1];
        dp[0]=0;
        dp[1]=0;
        dp[2]=1;
        for(int i = 3 ; i <= n ; i++)
        {
            dp[i]=dp[i-1]+dp[i-2];
        }

        return dp[n];

    }

    public static int fabinoci_series_2_variables(int n)
    {
        if(n<=1)
        {
            return 0;
        }
        else if(n ==2)
        {
            return 1;
        }
        int prev = 0; 
        int cur = 1;
        int next = 0;
        for(int i = 3 ; i<=n ;i++)
        {
            next = cur + prev;
            prev = cur;
            cur = next;
        }

        return next;
    }
    
    public static void main(String[] args) {

        // Fabinoci Series :- 0    1   1    2    3    5    8    13   21
        // n_th term       :- 1st 2nd  3rd  4th  5th  6th  7th  8th  9th

        int n = 50; // Example input
        int[] memo = new int[n + 1];
        int result1 = fabinoci_series_memoization(n, memo);
        int result2 = fabinoci_series_recursion(n);
        int result3 = fabinoci_series_tabulation(n);
        int result4 = fabinoci_series_2_variables(n);
        System.out.println("Fibonacci number at position  " + n + " using dp ( Memoization ) : " + result1);
        System.out.println("Fibonacci number at position  " + n + " using dp ( Tabulation ) : " + result3);
        System.out.println("Fibonacci number at position  " + n + " using 2 variables : " + result4);
        System.out.println("Fibonacci number at position  " + n + " using recursion : " + result2);
    }
}