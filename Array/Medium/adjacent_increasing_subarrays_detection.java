package Array.Medium;

import java.util.*;

/* LeetCode :-3349 https://leetcode.com/problems/adjacent-increasing-subarrays-detection-i/ */

public class adjacent_increasing_subarrays_detection {
    public boolean check(List<Integer>nums, int start , int k)
    {
        for(int i = start ; i  < start+k-1 ; i++)
        {
            if(nums.get(i) >= nums.get(i+1))
            {
                return false;
            }
        }
        return true;
    }
    
    public boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
        
        int n = nums.size();
        if(k==1)
        {
            return true;
        }

        for(int i = 0 ; i <= n -2*k ; i++)
        {
            if(check(nums,i,k) && check(nums,i+k,k))
            {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        adjacent_increasing_subarrays_detection solution = new adjacent_increasing_subarrays_detection();
        
        // Test case 1
        List<Integer> nums1 = Arrays.asList(1, 2, 3, 2, 3, 4);
        int k1 = 3;
        System.out.println("Test case 1: " + solution.hasIncreasingSubarrays(nums1, k1));
        
        // Test case 2
        List<Integer> nums2 = Arrays.asList(1, 3, 2, 4, 5, 6);
        int k2 = 2;
        System.out.println("Test case 2: " + solution.hasIncreasingSubarrays(nums2, k2));
        
        // Test case 3
        List<Integer> nums3 = Arrays.asList(1, 2, 3, 4);
        int k3 = 1;
        System.out.println("Test case 3: " + solution.hasIncreasingSubarrays(nums3, k3));
    }
}