package SlidingWindow_and_TwoPointers.Strivers;
import java.util.*;

/* LeetCode :- 1004 https://leetcode.com/problems/max-consecutive-ones-iii/ */

/* Optimal Approach :- --> Its same like the shrinking window concept , find the valid condition for the window 
 *                     --> Based on the condition expand or shrink the window 
 *                     --> The condition for the window is " The window can have at most 2 zeros only"
 *                     
 *                     --> T.C :- O( 2n ) -> as at worst case both the pointers will be moving till the end of the window.
 */


public class max_consecutive_one_III {

    public static int longestOnes(int[] nums, int k) {

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
    
    public static void main(String args[])
    {
        int[] nums = {1,1,1,0,0,0,1,1,1,1,0};
        int k = 2;
        System.out.println("Maximum consecutive ones: " + longestOnes(nums, k));
        
        int[] nums2 = {0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1};
        k = 3;
        System.out.println("Maximum consecutive ones: " + longestOnes(nums2, k));
    }
    
}
