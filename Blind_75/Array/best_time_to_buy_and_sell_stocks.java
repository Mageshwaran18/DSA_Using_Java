import java.util.*;

/* LeetCode :- 121 https://leetcode.com/problems/best-time-to-buy-and-sell-stock/ */

/* Hint :- Use finding next greatest element approach ( refer DSA notes )
 * T.C :- O(n)
 * S.C :- O(1) -> if inplaced is allowed 
 */

public class best_time_to_buy_and_sell_stocks {

    public int maxProfit(int[] prices) {
        
        int maxi = prices[prices.length-1];
        int ans = 0;
        for(int i = prices.length-1;i>=0;i--)
        {
            if(prices[i]<=maxi)
            {
                prices[i]=maxi-prices[i];
            }
            else
            {
                maxi=prices[i];
                prices[i]=0;
            }
            ans = Math.max(ans,prices[i]);
        }
        return ans;
    }

    public static void main(String[] args) {
        best_time_to_buy_and_sell_stocks solution = new best_time_to_buy_and_sell_stocks();
        int[] prices = {7,1,5,3,6,4};
        System.out.println("Maximum profit: " + solution.maxProfit(prices));
    }    

}
