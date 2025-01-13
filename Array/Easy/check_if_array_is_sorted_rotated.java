package Array.Easy;


/* Leetcode No:- 1752  https://leetcode.com/problems/check-if-array-is-sorted-and-rotated/description/*/

/*
 * Optimal approach --> In a sorted array ( non - decreasing order ) , consider i am traversing from the backside . Then the arr[i] > arr[i-1] , if the condition fails , it shows that it's not sorted properly .
 *                  --> Refer DSA notes
 */



public class check_if_array_is_sorted_rotated {

    public static boolean check_if_array_is_sorted_rotated(int []nums)
    {
        int cmt = 0;
        for(int i = nums.length-1 ; i > -1 ;i--)
        {
            if(i==0)
            {
                if(nums[i] < nums[nums.length -1])
                {
                    cmt++;
                }
            }
            else if (nums[i] < nums[i-1])
            {
                cmt++;
            }
        }
        if(cmt > 1)
        {
            return false;
        }
        return true;
    }


    public static void main(String[] args) {
        int[] nums1 = {3, 4, 5, 1, 2};
        int[] nums2 = {2, 1, 3, 4};
        
        System.out.println("Array 1 is sorted and rotated: " + check_if_array_is_sorted_rotated(nums1));
        System.out.println("Array 2 is sorted and rotated: " + check_if_array_is_sorted_rotated(nums2));
    }
    
}