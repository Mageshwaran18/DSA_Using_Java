package Binary_Search;
import java.util.*;

/* LeetCode :- 33 https://leetcode.com/problems/search-in-rotated-sorted-array/description/ */

/* Brute force :- --> Search an element using a single for loop
 *                --> T.C :- O( n )
 * 
 * Optimal approach :- --> It's similar to the find the minimum in rotated sorted array.
 *                     --> T.C :- O( log n )
 *                     --> Refer the DSA notes.
 */

class search_in_rotated_sorted_array {

    public static int search(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] == target) {
                return mid;
            }

            if (arr[low] <= arr[mid]) {
                // ✅ Now the array is sorted from low to mid.
                // Then check whether the element can be found in that array or not.
                // How to do that? Check the lowest and highest of that array.
                // If the target is bounded inside this, then move the high (shrink the search context),
                // else it will be found in the other part of the array, so move the low.

                if (arr[low] <= target && arr[mid] > target) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else {
                // ✅ In this case, the array is sorted from mid to high.
                // Check whether the element can be found in that sorted part.
                // If target lies between arr[mid] and arr[high], shrink the search window by moving 'low'.
                // Otherwise, move 'high' to search in the left unsorted part.

                if (arr[mid] < target && arr[high] >= target) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {4, 5, 6, 7, 0, 1, 2};
        int target = 0;
        int result = search(arr, target);
        System.out.println("Target " + target + " found at index: " + result);
        target = 3;
        result = search(arr, target);
        System.out.println("Target " + target + " found at index: " + result);
    }
}