package Binary_Search;
import java.util.*;

/* LeetCode :- 153 https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/description/ */


/* Refer the DSA notes */
/* T.C :- O( log n ) */
class find_minimum_rotated_sorted_array
{

    public static int findMin(int[] nums) {

        int ans = Integer.MAX_VALUE;
        int low = 0;
        int high = nums.length-1;
        while(low<=high)
        {
            int mid = low + (high-low)/2;


            /*nums[low]<=nums[mid] left array is sorted
            nums[high]>=nums[mid] right array is sorted
            if both the left and right are sorted , then the entire array is sorted.
            nums[low]<=nums[high] array is sorted.*/

            // if that is the case then the arrays minimum value will be in the low position (or) the ans.

            if(nums[low]<=nums[high])
            {
                ans = Math.min(ans,nums[low]);
                break;
            }
            else if(nums[low]<=nums[mid])
            {
                ans = Math.min(ans,nums[low]);
                low = mid + 1;
            }
            else
            {
                ans = Math.min(ans,nums[mid]);
                high = mid-1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {3,4,5,1,2};
        System.out.println("Minimum element in rotated sorted array: " + findMin(nums));
        
        int[] nums2 = {4,5,6,7,0,1,2};
        System.out.println("Minimum element in rotated sorted array: " + findMin(nums2));
    }
}