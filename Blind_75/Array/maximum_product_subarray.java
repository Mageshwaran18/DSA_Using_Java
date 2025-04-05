import java.util.*;

/* LeetCode :- 152 https://leetcode.com/problems/maximum-product-subarray/description/ */

/* Refer DSA note for better understanding   
 * 
 * Brute force Approach -> Create all possible subarrays using three for loops. And find the maximum product among them.
 *                      -> T.C :- O(n^3)
 * Better Approach -> Create all the possible subarrays using two for loops. And find the maximum product among them.
 *                      -> T.C :- O(n^2)
 * Optimal Approach -> Have an intuition on when we will get maximum, what could be the approach
 *                  -> It's combination of Sliding window + prefix & suffix
 *                  -> T.C :- O(n)
*/
public class maximum_product_subarray {

    public static int maxProduct(int[] nums) {
        int maxi = Integer.MIN_VALUE;
        int pre = 1;
        int suf = 1;
        int n = nums.length;
        for(int i = 0 ; i < n ; i++ )
        {
            pre = pre * nums[i];
            suf = suf * nums[n-i-1];
            maxi = Math.max(maxi,Math.max(pre,suf));
            if(pre==0)
            {
                pre = 1;
            }
            else if (suf==0)
            {
                suf = 1;
            }
        }
        return maxi;
    }

    public static void main(String[] args) {
        int[] nums = {2,3,-2,4};
        System.out.println("Maximum product subarray: " + maxProduct(nums));
        
        int[] nums2 = {-2,0,-1};
        System.out.println("Maximum product subarray: " + maxProduct(nums2));
    }
    
    
}
