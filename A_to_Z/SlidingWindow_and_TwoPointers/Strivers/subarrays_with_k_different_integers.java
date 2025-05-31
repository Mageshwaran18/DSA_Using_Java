package SlidingWindow_and_TwoPointers.Strivers;

import java.util.HashMap;
import java.util.Scanner;

/*LeetCode :- 992 https://leetcode.com/problems/subarrays-with-k-different-integers/description/ */

/* 
 * Brute Force :- --> Generate all the possible subarrays and count the number of the subarrays match with the condition 
 *                --> Use Hashmap to check whether the subarray is valid or not 
 *                --> T.C :- O( N^2 ) [ to generate all the possible subarrays ]
 *                --> S.C :- O( K ) [ at max in the same time hashmap can contains k unique elements in that ]
 * 
 * Optimal Approach :- --> The issue we face during the solving of problem using  sliding window concept is we don't exactly know when to move the right and when to move the left 
 *                     --> So if the problem is about subarrays and you don't know when to move left and right pointers exactly then try the K and K-1 approach
 *                     --> It's a sum successor to the count_no_of_nice_subarrays.
 *                     --> Hint :- [ Find the no.of subarrays lesser or equal to k ] - [ Find the no.of subarrays lesser or equal to k-1 ]
 *                     --> O ( 2*N ) --> To Find the no.of subarrays lesser or equal to k .O( K ) for hashmap. So , 
 *                     --> T.C :- O ( 2*2N ) [ total time complexity ]
 *                     --> S.C :- O ( 2*K ) [ total space complexity ]                     
 *                  
 */

public class subarrays_with_k_different_integers {

    public static  int brute_force(int[] nums, int k) {
        
        int count = 0;
        for(int i = 0 ; i < nums.length ; i++)
        {
            HashMap<Integer,Integer> hm = new HashMap<>();
            for(int j = i ; j < nums.length ; j++)
            {
                hm.put(nums[j],hm.getOrDefault(nums[j],0)+1);
                if(hm.size()==k)
                {
                    count++;
                }
                else if(hm.size()>k)
                {
                    break;
                }
            }
        }
        return count;
    }

     public static int less_or_equal(int []nums,int k)
    {
        int left = 0 ;
        int cnt = 0;
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int right = 0 ; right < nums.length ; right++)
        {
            int temp = nums[right];
            hm.put(temp,hm.getOrDefault(temp,0)+1);
            while(hm.size()>k)
            {
                int rem = nums[left];
                hm.put(rem,hm.get(rem)-1);
                if(hm.get(rem)==0)
                {
                    hm.remove(rem);
                }
                left++;
            }
            cnt+= right-left+1;
        }
        return cnt;
    }

    public static int optimal_approach(int[] nums, int k) {
        return less_or_equal(nums,k)-less_or_equal(nums,k-1);
    }

    public static void main(String[] args) {

        int nums[] = {2,1,1,1,3,4,3,2};
        int k = 3;
        System.out.println("Using Brute Force: " + brute_force(nums, k));
        System.out.println("Using Optimal Approach: " + optimal_approach(nums, k));
    }
}
