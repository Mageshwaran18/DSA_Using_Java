package Array.Strivers.Easy;
import java.util.*;


/* Leetcode No:- 1752  https://leetcode.com/problems/check-if-array-is-sorted-and-rotated/description/*/

/*
 * Brute force Approach --> Rotate the array n times and at each rotation 
 *                      --> Check whether the array is sorted or not
 *                      --> Rotating the array at max can happen for n times and for each rotation the array need to be checked which is also an another n times 
 *                      --> T.C :- O( n^2 )
 *                      --> S.C :- O( 1 )
 *                      
 *  
 * Optimal approach --> In a sorted array ( non - decreasing order ) , consider i am traversing from the backside . 
 *                  --> Then the arr[i] > arr[i-1] , if the condition fails , it shows that it's not sorted properly .
 *                  --> Hint :- Graph Approach 
 *                  --> Refer DSA - 1  notes
 *                  --> T.C :- O ( n )
 *                  --> S.C :- O ( 1 )
 */



public class check_if_array_is_sorted_rotated {

    public static boolean brute_help(LinkedList<Integer> arr)
    {
        for(int i = 0 ; i < arr.size()-1; i++)
        {
            if(arr.get(i)>arr.get(i+1))
            {
                return false;
            }
        }
        return true;
    }

    public static boolean brute_force(int []nums)
    {
        LinkedList<Integer> arr = new LinkedList<>();
        for(int i : nums)
        {
            arr.add(i);
        }

        for(int i = 0 ; i < arr.size() ; i++)
        {
            if(brute_help(arr))
            {
                return true;
            }
            int temp = arr.remove(0);
            arr.add(temp);
        }
        return false;
    }

    public static boolean optimal_approach(int []nums)
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
                System.out.println("Array 1 is sorted and rotated using the optimal : " + optimal_approach(nums1));
                System.out.println("Array 2 is sorted and rotated using the optimal : " + optimal_approach(nums2));
        
                System.out.println("Array 1 is sorted and rotated using brute force : " + brute_force(nums1));
                System.out.println("Array 2 is sorted and rotated using brute force : " + brute_force(nums2));    
    }
    
}