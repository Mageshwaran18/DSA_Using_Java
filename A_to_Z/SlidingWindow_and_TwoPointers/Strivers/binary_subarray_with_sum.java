package SlidingWindow_and_TwoPointers.Strivers;
import java.util.*;

/* LeetCode :- 930 https://leetcode.com/problems/binary-subarrays-with-sum/description/ */

/* 
 * Brute Force :- --> Asusual Generating all the subarrays for the given array 
 *                --> And count the number of subarrays that statisfy the condition ( given sum = goal )
 *                --> T.C :- O( n^2 )
 *                --> S.C :- O( 1 )
 * 
 * Better Approach :- --> As same as the subarray sum equals k.
 *                    --> Where we will be using the hashmap to do that 
 *                    --> T.C :- O ( N )
 *                    --> S.C :- O ( N )
 * 
 * Optimal Approach :- --> The better approach is having the extra space , we used that because the subarray sum equals k have both +ve,-ve elements
 *                     --> So we can reduce the space complexity from O( N ) to O ( N )
 *                     --> Refer DSA Note - 2
 *                     --> T.C :- O ( 2 * 2N )
 *                     --> S.C :- O ( 1 )              
 */

public class binary_subarray_with_sum {

    public static int brute(int []nums , int goal)
    {
        int ans = 0;
        int n = nums.length;
        for(int i = 0 ; i < n ; i++)
        {
            int sum = 0;
            for(int j = i ; j < n ; j++)
            {
                sum+=nums[j];
                if(sum==goal)
                {
                    ans++;
                }
            }
        }
        return ans;
    }

    public static int better(int [] nums , int goal)
    {
        int ans = 0;
        int sum = 0;
        int rem = 0;
        HashMap<Integer,Integer> hm = new HashMap<>();
        hm.put(0,1);
        for(int i = 0 ; i < nums.length ; i++)
        {
            sum += nums[i];
            rem = sum - goal;
            if(hm.get(rem)!=null)
            {
                ans+=hm.get(rem);
            }            
            hm.put(sum,hm.getOrDefault(sum,0)+1);
        }
        return ans;

    }
    
    public static int optimal(int [] nums,int goal)
    {
        if(goal<0)
        {
            return 0;
        }
        int sum = 0;
        int cnt = 0;
        int left = 0;
        for(int right = 0 ;right < nums.length ; right++)
        {
            sum += nums[right];
            while(sum > goal)
            {
                sum -= nums[left];
                left++;
            }
            cnt += right-left+1;
        }
        return cnt;
    }

    public static int numSubarraysWithSum(int[] nums, int goal) {
        int ans =optimal(nums,goal)-optimal(nums,goal-1);
        return ans;
    }
    
    public static void main(String[] args) {
        int[] nums = {1, 0, 0, 1, 1, 0};
        int goal = 2;
        
        System.out.println("Brute Force Result: " + brute(nums, goal));
        System.out.println("Better Approach Result: " + better(nums, goal));
        System.out.println("Optimal Approach Result: " + numSubarraysWithSum(nums, goal));
    }
}
