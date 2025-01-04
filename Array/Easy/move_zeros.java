package Array.Easy;


/* LeetCode :-  283  https://leetcode.com/problems/move-zeroes/description/ */


/*
 * My Approach --> I just tried to implement the remove duplicates from array inplace code with some changes
 * 
 * Optimal Approach --> Choose the first zero element (j)
 *                  --> We know that , what ever the non zero element comes (from j+1 ) it should be before the first zero element 
 *                  -- Time complexity --> O(n)
 */
public class move_zeros {

    public static int[] moveZeros(int n, int []nums) {
    
        int j = -1;
        for(int i = 0 ; i < n ; i++)
        {
            if(nums[i]==0)
            {
                j = i;
                break;
            }
        }

        for(int i = j + 1 ; i < n ; i++)
        {
            if(nums[i]!=0)
            {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                j++;
            }

        }

        return nums;
    }
    
    public static void main(String[] args) {
        int[] arr = {0, 1, 0, 3, 12};
        int n = arr.length;
        
        System.out.println("Original array:");
        for (int num : arr) {
            System.out.print(num + " ");
        }
        
        int[] result = moveZeros(n, arr);
        
        System.out.println("\nArray after moving zeros to the end:");
        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}
