package Array.Easy;


/* GfG :- https://www.geeksforgeeks.org/problems/longest-sub-array-with-sum-k0809/1  */

/*
 * Optimal Approach --> * Sliding window 
 *                      * Shrinking and expanding window technique 
 *                      * Remember to assign the sum as long 
 *                      * Determine the valid window condition and shrink the window based on the condition
 *                      * Time Complexity --> O(n)
 */
public class longest_subarray_with_sum_k{
    public static int longestSubarrayWithSumK(int []a, long k) {

        int left = 0 ; 
        int res = 0 ;
        int n = a.length;
        long summ = 0;
        for(int right = 0 ; right < n ; right++)
        {
            summ+=a[right];
            while ( summ > k)
            {
                summ -= a[left];
                left++;
            }
            if(summ==k)
            {
                res=Math.max(res,right-left+1);
            }
        }
        return res;
    
        
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 1, 3};
        long k = 3;
        int result = longestSubarrayWithSumK(arr, k);
        System.out.println("Length of longest subarray with sum " + k + ": " + result);
    }
}