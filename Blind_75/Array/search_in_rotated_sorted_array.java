import java.util.*;

/* LeetCode :- 33 https://leetcode.com/problems/search-in-rotated-sorted-array/description/ */

/* Brute force :- --> Search an element using a single for loop
 *                --> T.C :- O( n )
 * 
 * Optimal approach :- --> It's similar to the find the minimum in rotated sorted array.
 *                     --> T.C :- O( log n )
 *                     --> Refer the DSA notes.
  */

class search_in_rotated_sorted_array{
    
    public static int search(int[] arr, int target) {
        int low = 0;
        int high = arr.length-1;
        while(low<=high)
        {
            int mid = low + (high-low)/2;
            if(arr[mid]==target)
            {
                return mid;
            }
            if(arr[low]<=arr[mid])
            {
                if(arr[low]<=target && arr[mid]>target)
                {
                    high=mid-1;
                }
                else
                {
                    low=mid+1;
                }
            }
            else
            {
                if(arr[mid]<target && arr[high]>=target)
                {
                    low=mid+1;
                }
                else
                {
                    high=mid-1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {4,5,6,7,0,1,2};
        int target = 0;
        int result = search(arr, target);
        System.out.println("Target " + target + " found at index: " + result);
        target = 3;
        result = search(arr, target);
        System.out.println("Target " + target + " found at index: " + result);
    }
}