import java.util.*;

/* LeetCode :- 238 https://leetcode.com/problems/product-of-array-except-self/ */

class product_of_array_except_self
{
    public static int[] productExceptSelf(int[] nums) {
        
        int n = nums.length;
        int ans[] = new int[n];
        Arrays.fill(ans, 1);
        int curr = 1;
        for(int i = 0; i < n; i++) {
            ans[i] *= curr;
            curr *= nums[i];
        }
        curr = 1;
        for(int i = n - 1; i >= 0; i--) {
            ans[i] *= curr;
            curr *= nums[i];
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        int[] result = productExceptSelf(nums);
        
        System.out.print("Output: [");
        for(int i = 0; i < result.length; i++) {
            System.out.print(result[i]);
            if(i < result.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
}
