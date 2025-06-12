package SlidingWindow_and_TwoPointers;

// [ YOU ]


/* LeetCode :- 643 https://leetcode.com/problems/maximum-average-subarray-i/description/ */


/*
 * 
 * Optimal Approach :- --> It's typical sliding window problem , easy to solve . 
 *                     --> T.C :- O ( N )
 *                     --> S.C :- O ( 1 )
 * 
 */
public class maximum_average_subarray_I {

    public static double findMaxAverage(int[] nums, int k) {
        
        int left = 0;
        int n = nums.length;
        double sum  = 0;
        double max_avg = 0;

        for(int i = 0 ; i < k ; i++)
        {
            sum+=nums[i];
        }

        max_avg = (sum/k)*1.0;

        for(int right = k ; right < n ; right++)
        {
            sum-=nums[left++];
            sum+=nums[right];
            max_avg = Math.max(max_avg,sum/k*1.0);
        }

        return max_avg;

    }

    public static void main(String[] args) {
        int[] nums = {1, 12, -5, -6, 50, 3};
        int k = 4;
        double result = findMaxAverage(nums, k);
        System.out.println("Maximum average of subarray: " + result);
    }
    
    
}
