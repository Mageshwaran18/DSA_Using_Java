package Dynamic_Programming;
import java.util.*;

/* LeetCode :- 322 https://leetcode.com/problems/coin-change/description/ */
/* Refer DSA notes */


class coin_change
{
    public int coinChange(int[] coins, int amount) {
        
        int dp[] = new int[amount+1];
        Arrays.fill(dp,amount+1);
        dp[0]=0;
        for(int i = 1 ; i <= amount ; i++)
        {
            for(int coin : coins)
            {
                if(i>=coin)
                {
                    dp[i]=Math.min(dp[i],dp[i-coin]+1);
                }
            }
        }

        return dp[amount];
    
    }

    public static void main(String[] args) {
        coin_change solution = new coin_change();
        int[] coins = {1, 2, 5};
        int amount = 11;
        int result = solution.coinChange(coins, amount);
        System.out.println("Minimum number of coins needed: " + result);
    }
}