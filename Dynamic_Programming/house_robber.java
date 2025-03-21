package Dynamic_Programming;

/* LeetCode :- 198 https://leetcode.com/problems/house-robber/description/ */

/* Refer the DSA notes */

public class house_robber {

    public int rob(int[] nums)
    {
        int n = nums.length;
        int dp[] = new int[n+1];
        dp[0] = 0;
        dp[1] = nums[0];
        for(int i = 2 ; i <=n ; i++)
        {
            dp[n]=Math.max(dp[i-1],dp[i-2]+nums[i-1]);
        }
        return dp[n];
    }

    public static void main(String[] args) {
        house_robber solution = new house_robber();
        int[] nums = {1, 2, 3, 1};
        System.out.println("Maximum amount that can be robbed: " + solution.rob(nums));
    }
}