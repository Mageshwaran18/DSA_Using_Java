package Array;

/* LeetCode :-  283  https://leetcode.com/problems/move-zeroes/description/ */


/*
 * My Approach --> I just tried to implement the remove duplicates from array inplace code with some changes
 */
public class move_zeros {

    public static int[] moveZeros(int n, int []nums) {
        
        
        
        for(int i = 0 ; i < n ; i++)
        {
            if(nums[i]==0)
            {
                int j = i;
                while( j < n && nums[j]==0)
                {
                    j++;
                }
                if( j < n)
                {
                    nums[i]=nums[j];
                    nums[j]=0;
                }
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
