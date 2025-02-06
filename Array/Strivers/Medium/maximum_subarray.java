package Array.Strivers.Medium;

/* LeetCode:- 53 https://leetcode.com/problems/maximum-subarray/description/ */

/* The intuition of the algorithm is not to consider the subarray as a part of the answer if its sum is less than 0. 
A subarray with a sum less than 0 will always reduce our answer and so this type of subarray cannot be a part of the subarray with maximum sum. */
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
        int result = maxSubArray(nums);
        System.out.println("Maximum subarray sum: " + result);
    }
}
