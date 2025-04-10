import java.util.*;

/* LeetCode :- 238 https://leetcode.com/problems/product-of-array-except-self/ */

/* Refer the DSA notes */

/* Better Approach :- --> Use two separate array for calculating the prefix and sufix product
 *                    --> T.C :- O ( N )
 *                    --> S.C :- O ( N )
 * 
 * Optimal Approach :- --> Use the resultant array as prefix and the store the suffix in the resultant array itself.
 *                     --> T.C :- O( N )
 *                     --> S.C :- O( 1 ) 
*/ 


class product_of_array_except_self
{

    public static int[] better_approach(int[] nums) {

        int n = nums.length;
        int pre[] = new int[n];
        int suf[] = new int[n];
        int ans[] = new int[n];
        int cur =1;
        for(int i=0;i<n;i++)
        {
            pre[i]=cur;
            cur = cur * nums[i];
        }

        cur=1;
        for(int i = n-1; i >=0 ; i--)
        {
            suf[i]=cur;
            cur=cur*nums[i];
        }

        for(int i = 0; i < n ; i++)
        {
            ans[i]=pre[i]*suf[i];
        }
        return ans;
    }

    public static int[] optimal_approach(int[] nums) {
        
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
        int[] result1 = better_approach(nums);
        int[] result2 = optimal_approach(nums);
        System.out.println(Arrays.toString(result1));
        System.out.println(Arrays.toString(result2));
    }
}