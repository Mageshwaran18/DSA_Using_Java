package Prefix_Sum;
/*
 * Brute Force --> Find all the subarrays, calculate its sum and find the maximum
 *             --> Pseudo code: for(i = 0 to n) {
 *                                    cnt = 0
 *                                    for(j = i to n) {
 *                                        cnt += arr[j]
 *                                        if(cnt > max) {
 *                                            max = cnt
 *                                        }
 *                                    }
 *                                }
 *           --> Time Complexity: O(n^2), Space Complexity: O(1)
 * Optimal Approach --> It's a modified version of Kadane's algorithm.
 *                  --> Traverse the array, maintain a running sum and compare it to max,
 *                  --> If the current sum becomes negative, reset it to 0
 *                  --> This is because if the current sum is negative, adding it to any future element
 *                      will only decrease that sum, so it's better to start fresh
 */

 class maximum_sum_contiguous_subarray
{
    public static int maximum_sum_contiguous_subarray(int []arr)
    {
    
        int max = Integer.MIN_VALUE , cur = 0;
        int start_index = 0 , li=0,ri=0;
        for(int i = 0 ; i < arr.length ; i++)
        {
            if(cur==0)
            {
                start_index = i; // When ever cur = 0 then it's the point where it's the array is being started.
            }
            cur+=arr[i];
            if(cur>=max)
            {
                max = cur;
                li = start_index;
                ri=i;
                
            }
            if(cur < 0)
            {
                cur = 0;
            }
        }
        for(int i = li ; i<= ri ; i++)
        {
            System.out.print(arr[i] +" ");
        }
        System.out.println();
        return max;
    }

    public static void main(String[] args) {
        int[] arr = {-2, -3, 4, -1, -2, 1, 5, -3};
        int maxSum = maximum_sum_contiguous_subarray(arr);
        System.out.println("Maximum contiguous sum is: " + maxSum);
    }
}
