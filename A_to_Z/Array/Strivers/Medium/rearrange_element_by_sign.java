package Array.Strivers.Medium;
import java.util.*;

/* 
 * LeetCode :- 2149 https://leetcode.com/problems/rearrange-array-elements-by-sign/
 * 
 * Brute Force :- --> Use two extra N/2 space for the pos and neg , 
 *                --> Store the positive in a array and negative inside the another 
 *                --> In the answer array fill positive , negative , positive etc.. respectively 
 *                --> T.C :- O( N ) [ for creating pos & neg array ] + O ( N/2 ) for filling the answer array = O( N + N/2)
 *                --> S.C :- O( 2N )  [ for pos and neg ]
 * 
 * Optimal Approach :- --> Using two pointers pos = 0  and neg = 1
 *                     --> They will increment by 2 , as we know that +ve numbers are filled in even and -ve numbers are filled in the odd indices.
 *                     --> Refer the code it's easy to understand 
 *                     --> T.C :- O ( N )
 *                     --> S.C :- O ( N ) --> We are not implementing the solution inplace hence the time complexity 
 */

class rearrange_element_by_sign
{
    public static int[] brute_force(int [] nums)
    {
        List<Integer> pos = new ArrayList<>();
        List<Integer> neg = new ArrayList<>();
        int n = nums.length;
        int [] arr = new int[n];

        for(int i : nums)
        {
            if(i > 0)
            {
                pos.add(i);
            }
            else
            {
                neg.add(i);
            }
        }

        for(int i = 0 ; i < n/2 ; i++)
        {
            nums[i*2] = pos.remove(0);
            nums[i*2 + 1] = neg.remove(0);
        }
        return nums;
        }
    
    public static int[] optimal_approach(int[] nums)
    {
        int pos = 0;
        int neg = 1;
        int n = nums.length;
        int []ans = new int[n];
        for(int i : nums)
        {
            if(i < 0)
            {
                ans[neg] = i;
                neg+=2;
            }
            else
            {
                ans[pos] = i;
                pos+=2;
            }
        }
        return ans;
    }

    public static void main(String []args)
    {
        int nums[] = {3,1,-2,-5,2,-4};
        System.out.println(Arrays.toString(brute_force(nums)));
        System.out.println(Arrays.toString(optimal_approach(nums)));

    }
}