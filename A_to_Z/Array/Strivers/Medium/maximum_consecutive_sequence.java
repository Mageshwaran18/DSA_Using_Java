package Array.Strivers.Medium;
import java.util.*;

/* LeetCode :- 128 https://leetcode.com/problems/longest-consecutive-sequence/description/ */

/* Brute Force :- --> Consider Every element as the starting point
 *                --> For every starting point check whether the next number is present or not , if yes repeat the same step till it fails 
 *                --> T.C :- O( n^2 )  [ For every element we are searching the array entirely ]
 *                --> S.C :- O( 1 )
 * 
 * Better Approach :- --> Sort the given array and find the consecutive 
 *                    --> T.C :- O ( n log n ) [ for sorting ] + O ( N ) [ for finding the long length ].
 *                    --> S.C :- O ( 1 )
 */

public class maximum_consecutive_sequence {

    static class brute_force{

        public static boolean helper(int[] arr,int target)
        {
            for(int i = 0 ; i < arr.length ; i++)
            {
                if(arr[i]==target)
                {
                    return true;
                }
            }
            return false;
        }

        public static int brute_force(int[] arr)
        {
            int ans = 1;
            int n = arr.length;
            if(n==0){
                return 0;
            }
            for(int i = 0 ; i < n ; i++)
            {
                int temp = arr[i];
                int cnt = 1;
                while(helper(arr,temp+1))
                {
                    temp += 1;
                    cnt++;
                }
                ans=Math.max(ans,cnt);
            }

            return ans;
        } 
    }

    static class better_approach
    {
        public static int better_approach(int []nums)
        {
            int n = nums.length;
            int arr[] = nums.clone();
            if(n==0)
            {
                return 0;
            }
            Arrays.sort(arr);
            int st_num = Integer.MIN_VALUE;
            int ans = 1;
            int i = 0;
            // 0 0 1 2 3 4 5 10 6 7 8 9
            while(i < n )
            {
                int cnt = 1;
                while(i < n && st_num+1 == arr[i])
                {
                    cnt++;
                    st_num = arr[i];
                    i++;
                }
                ans = Math.max(ans,cnt);
                if(i>=n)
                {
                    break;
                }
                st_num = arr[i];
                i++;
            }
            return ans;
        }
    }

    public static void main(String args[])
    {
        int arr[] = {0,3,7,2,5,8,4,6,0,1};
        int bf = brute_force.brute_force(arr);
        int bef = better_approach.better_approach(arr);
        System.out.println(bf);
        System.out.println(bef);
    }
    
}
