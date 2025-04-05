import java.util.*;

/* LeetCode :- 53 https://leetcode.com/problems/maximum-subarray/description/ */
/* Hint :- Once we get the negative sum ,
           then there is no point of taking that for the next point  
           
           T.C :- O(n)
*/

public class maximum_subarray {

    public static int maxSubArray(int[] nums) {
        
        int ans = Integer.MIN_VALUE , temp = 0;
        for(int i = 0 ; i < nums.length ;i++)
        {
            temp+=nums[i];
            if(temp>ans)
            {
                ans=temp;
            }
            if(temp<0)
            {
                temp=0;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println("Maximum subarray sum: " + maxSubArray(nums));
    }    
}
