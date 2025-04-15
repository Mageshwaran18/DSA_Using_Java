package SlidingWindow_and_TwoPointers;

/* LeetCode :- 713 https://leetcode.com/problems/subarray-product-less-than-k/description/ */

/* Optimal Approach :- --> It's just an normal sliding window approach , easy to implement as we know the constraints for the window 
 * 					   --> The number of elements in the window is need to be added to the cnt . ( Refer DSA Notes )
*/

public class subarray_product_less_than_k {
    public static  void subarray_product_less_than_k(int[] nums , int k)
	{
		int l = 0 ; 
        int pro = 1 , cnt = 0;
        for(int r = 0 ; r < nums.length ; r++)
        {
            pro*=nums[r];
            while(pro >= k)
            {
                pro/=nums[l];
                l++;
            }
            cnt+=(r-l+1);
		}

		System.out.println(cnt);
    }
    
    public static void main(String[] args) {
        int[] nums = {10, 5, 2, 6};
        int k = 100;
        subarray_product_less_than_k(nums, k);
    }
}
