package SlidingWindow_and_TwoPointers.Strivers;

/* LeetCode :- 1248 https://leetcode.com/problems/count-number-of-nice-subarrays/description/ */

/*
 * 
 * Brute Force :- --> Generate all the possible subarrays and count the number of subarrays that statisfy the specific condition 
 *                --> T.C :- O ( n^2 )
 *                --> S.C :- O ( 1 )
 * 
 * Optimal Approach :- --> The sum is the successor of the binary subarray with sum k 
 *                     --> You can relate two problem like even numbers are zero and odd numbers are one 
 *                     --> [ Hint ] :- (Find the number of subarrays with odd count <= k )- (Find the number of subarrays with odd count <= k-1)
 *                     --> T.C :- O ( 2*2n )
 *                     --> S.C :- O ( 1 )  
 * 
 */

public class count_no_of_nice_subarrays {

    public static int brute_force(int[] nums,int k )
    {
        int ans = 0;
        for(int i = 0 ; i < nums.length ; i++)
        {
            int count = 0;
            for(int j = i ; j < nums.length ; j++)
            {
                if(nums[j]%2!=0)
                {
                    count++;
                }
                if(count==k)
                {
                    ans++;
                }
            }

        }

        return ans;
    }

    public static int help(int []nums , int k )
    {
        int count = 0;
        int left = 0;
        int ans = 0;
        for(int right = 0; right < nums.length ; right++)
        {
            if(nums[right]%2!=0)
            {
                count++;
            }

            while(count>k)
            {
                if(nums[left]%2!=0)
                {
                    count--;
                }
                left++;
            }
            ans+=right-left+1;
        }
        return ans;
    }
    public static int optimal(int[] nums, int k) {

        return help(nums,k)-help(nums,k-1);
        
    }
    
    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 1, 1};
        int k = 3;
        
        System.out.println("Brute Force Result: " + brute_force(nums, k));
        System.out.println("Optimal Result: " + optimal(nums, k));
    }
}
