package SlidingWindow_and_TwoPointers.Strivers;
import java.util.*;

/* LeetCode :- 1004 https://leetcode.com/problems/max-consecutive-ones-iii/ */

/* Better Approach :- --> Its same like the shrinking window concept , find the valid condition for the window 
 *                     --> Based on the condition expand or shrink the window 
 *                     --> The condition for the window is " The window can have at most 2 zeros only"
 *                     
 *                     --> T.C :- O( 2n ) -> as at worst case both the pointers will be moving till the end of the window.
 *
 * Optimal Approach :- --> Don't shrink the window ,instead move the entire window itself.
 *                     --> Move both left and right at the same time to move the entire window.
 *                     --> Refer DSA notes [ last page ]
 *                     --> T.C :- O( n )
 */


public class max_consecutive_one_III {

    public static int better_longestOnes(int[] nums, int k) {

        int left = 0;
        int sum = 0;
        int ans = Integer.MIN_VALUE;
        for(int right = 0 ; right < nums.length ; right++)
        {
            if(nums[right]==0)
            {
                sum++;
            }
            while(sum>k)
            {
                if(nums[left]==0)
                {
                    sum--;
                }
                left++;
            }
            ans = Math.max(ans,right-left+1);
        }

        return ans;
    }

    public static int optimal_longestOnes(int[] nums, int k)
    {
        int left = 0; 
        int cnt = 0;
        int ans = Integer.MIN_VALUE;
        for(int right = 0; right < nums.length ; right++)
        {
            if(nums[right]==0)
            {
                cnt++;
            }
            if(cnt>k)
            {
                if(nums[left]==0)
                {
                    cnt--;
                }
                left++;
            }

            if(cnt<=k)
            {
                ans = Math.max(ans,right-left+1);
            }
        }
        return ans;


    }
    
    public static void main(String args[])
    {
        int[] nums = {1,1,1,0,0,0,1,1,1,1,0};
        int k = 2;
        System.out.println("Maximum consecutive ones: " + better_longestOnes(nums, k));
        System.out.println("Maximum consecutive ones: " + optimal_longestOnes(nums, k));
    }
    
}
